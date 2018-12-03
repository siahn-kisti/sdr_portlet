package com.liferay.portal.search.lucene;

/**
 * @author goopsw
 */
import java.io.IOException;
import java.io.StringReader;
import java.text.Collator;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CachingTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.document.DateField;
import org.apache.lucene.document.DateTools;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.CharStream;
import org.apache.lucene.queryParser.FastCharStream;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParserConstants;
import org.apache.lucene.queryParser.QueryParserTokenManager;
import org.apache.lucene.queryParser.Token;
import org.apache.lucene.queryParser.TokenMgrError;
import org.apache.lucene.queryParser.standard.nodes.NumericRangeQueryNode;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.Version;
import org.apache.lucene.util.VirtualMethod;

public class QueryParser implements QueryParserConstants {

  private static final int CONJ_NONE   = 0;
  private static final int CONJ_AND    = 1;
  private static final int CONJ_OR     = 2;

  private static final int MOD_NONE    = 0;
  private static final int MOD_NOT     = 10;
  private static final int MOD_REQ     = 11;

  // make it possible to call setDefaultOperator() without accessing 
  // the nested class:
  /** Alternative form of QueryParser.Operator.AND */
  public static final Operator AND_OPERATOR = Operator.AND;
  /** Alternative form of QueryParser.Operator.OR */
  public static final Operator OR_OPERATOR = Operator.OR;

  /** The actual operator that parser uses to combine query terms */
  private Operator operator = OR_OPERATOR;

  boolean lowercaseExpandedTerms = true;
  MultiTermQuery.RewriteMethod multiTermRewriteMethod = MultiTermQuery.CONSTANT_SCORE_AUTO_REWRITE_DEFAULT;
  boolean allowLeadingWildcard = false;
  boolean enablePositionIncrements = true;

  Analyzer analyzer;
  String field;
  int phraseSlop = 0;
  float fuzzyMinSim = FuzzyQuery.defaultMinSimilarity;
  int fuzzyPrefixLength = FuzzyQuery.defaultPrefixLength;
  Locale locale = Locale.getDefault();

  // the default date resolution
  DateTools.Resolution dateResolution = null;
  // maps field names to date resolutions
  Map<String,DateTools.Resolution> fieldToDateResolution = null;

  // The collator to use when determining range inclusion,
  // for use when constructing RangeQuerys.
  Collator rangeCollator = null;

  /** @deprecated remove when getFieldQuery is removed */
  @Deprecated
  private static final VirtualMethod<QueryParser> getFieldQueryMethod =
    new VirtualMethod<QueryParser>(QueryParser.class, "getFieldQuery", String.class, String.class);
  /** @deprecated remove when getFieldQuery is removed */
  @Deprecated
  private static final VirtualMethod<QueryParser> getFieldQueryWithQuotedMethod =
    new VirtualMethod<QueryParser>(QueryParser.class, "getFieldQuery", String.class, String.class, boolean.class);
  /** @deprecated remove when getFieldQuery is removed */
  @Deprecated
  private final boolean hasNewAPI =
    VirtualMethod.compareImplementationDistance(getClass(),
        getFieldQueryWithQuotedMethod, getFieldQueryMethod) >= 0; // its ok for both to be overridden

  private boolean autoGeneratePhraseQueries;

  /** The default operator for parsing queries. 
   * Use {@link QueryParser#setDefaultOperator} to change it.
   */
  static public enum Operator { OR, AND }

  /** Constructs a query parser.
   *  @param matchVersion  Lucene version to match. See <a href="#version">above</a>.
   *  @param f  the default field for query terms.
   *  @param a   used to find terms in the query text.
   */
  public QueryParser(Version matchVersion, String f, Analyzer a) {
    this(new FastCharStream(new StringReader("")));
    analyzer = a;
    field = f;
    if (matchVersion.onOrAfter(Version.LUCENE_29)) {
      enablePositionIncrements = true;
    } else {
      enablePositionIncrements = false;
    }
    if (matchVersion.onOrAfter(Version.LUCENE_31)) {
      setAutoGeneratePhraseQueries(false);
    } else {
      setAutoGeneratePhraseQueries(true);
    }
  }

  /** Parses a query string, returning a {@link org.apache.lucene.search.Query}.
   *  @param query  the query string to be parsed.
   *  @throws ParseException if the parsing fails
   */
  public Query parse(String query) throws ParseException {
    ReInit(new FastCharStream(new StringReader(query)));
    try {
      // TopLevelQuery is a Query followed by the end-of-input (EOF)
      Query res = TopLevelQuery(field);
      return res!=null ? res : newBooleanQuery(false);
    }
    catch (ParseException tme) {
      // rethrow to include the original query:
      ParseException e = new ParseException("Cannot parse '" +query+ "': " + tme.getMessage());
      e.initCause(tme);
      throw e;
    }
    catch (TokenMgrError tme) {
      ParseException e = new ParseException("Cannot parse '" +query+ "': " + tme.getMessage());
      e.initCause(tme);
      throw e;
    }
    catch (BooleanQuery.TooManyClauses tmc) {
      ParseException e = new ParseException("Cannot parse '" +query+ "': too many boolean clauses");
      e.initCause(tmc);
      throw e;
    }
  }

   /**
   * @return Returns the analyzer.
   */
  public Analyzer getAnalyzer() {
    return analyzer;
  }

  /**
   * @return Returns the field.
   */
  public String getField() {
    return field;
  }

  /**
   * @see #setAutoGeneratePhraseQueries(boolean)
   */
  public final boolean getAutoGeneratePhraseQueries() {
    return autoGeneratePhraseQueries;
  }

  /**
   * Set to true if phrase queries will be automatically generated
   * when the analyzer returns more than one term from whitespace
   * delimited text.
   * NOTE: this behavior may not be suitable for all languages.
   * <p>
   * Set to false if phrase queries should only be generated when
   * surrounded by double quotes.
   */
  public final void setAutoGeneratePhraseQueries(boolean value) {
    if (value == false && !hasNewAPI)
      throw new IllegalArgumentException("You must implement the new API: getFieldQuery(String,String,boolean)"
       + " to use setAutoGeneratePhraseQueries(false)");
    this.autoGeneratePhraseQueries = value;
  }

   /**
   * Get the minimal similarity for fuzzy queries.
   */
  public float getFuzzyMinSim() {
      return fuzzyMinSim;
  }

  /**
   * Set the minimum similarity for fuzzy queries.
   * Default is 0.5f.
   */
  public void setFuzzyMinSim(float fuzzyMinSim) {
      this.fuzzyMinSim = fuzzyMinSim;
  }

   /**
   * Get the prefix length for fuzzy queries. 
   * @return Returns the fuzzyPrefixLength.
   */
  public int getFuzzyPrefixLength() {
    return fuzzyPrefixLength;
  }

  /**
   * Set the prefix length for fuzzy queries. Default is 0.
   * @param fuzzyPrefixLength The fuzzyPrefixLength to set.
   */
  public void setFuzzyPrefixLength(int fuzzyPrefixLength) {
    this.fuzzyPrefixLength = fuzzyPrefixLength;
  }

  /**
   * Sets the default slop for phrases.  If zero, then exact phrase matches
   * are required.  Default value is zero.
   */
  public void setPhraseSlop(int phraseSlop) {
    this.phraseSlop = phraseSlop;
  }

  /**
   * Gets the default slop for phrases.
   */
  public int getPhraseSlop() {
    return phraseSlop;
  }


  /**
   * Set to <code>true</code> to allow leading wildcard characters.
   * <p>
   * When set, <code>*</code> or <code>?</code> are allowed as 
   * the first character of a PrefixQuery and WildcardQuery.
   * Note that this can produce very slow
   * queries on big indexes. 
   * <p>
   * Default: false.
   */
  public void setAllowLeadingWildcard(boolean allowLeadingWildcard) {
    this.allowLeadingWildcard = allowLeadingWildcard;
  }

  /**
   * @see #setAllowLeadingWildcard(boolean)
   */
  public boolean getAllowLeadingWildcard() {
    return allowLeadingWildcard;
  }

  /**
   * Set to <code>true</code> to enable position increments in result query.
   * <p>
   * When set, result phrase and multi-phrase queries will
   * be aware of position increments.
   * Useful when e.g. a StopFilter increases the position increment of
   * the token that follows an omitted token.
   * <p>
   * Default: false.
   */
  public void setEnablePositionIncrements(boolean enable) {
    this.enablePositionIncrements = enable;
  }

  /**
   * @see #setEnablePositionIncrements(boolean)
   */
  public boolean getEnablePositionIncrements() {
    return enablePositionIncrements;
  }

  /**
   * Sets the boolean operator of the QueryParser.
   * In default mode (<code>OR_OPERATOR</code>) terms without any modifiers
   * are considered optional: for example <code>capital of Hungary</code> is equal to
   * <code>capital OR of OR Hungary</code>.<br/>
   * In <code>AND_OPERATOR</code> mode terms are considered to be in conjunction: the
   * above mentioned query is parsed as <code>capital AND of AND Hungary</code>
   */
  public void setDefaultOperator(Operator op) {
    this.operator = op;
  }


  /**
   * Gets implicit operator setting, which will be either AND_OPERATOR
   * or OR_OPERATOR.
   */
  public Operator getDefaultOperator() {
    return operator;
  }


  /**
   * Whether terms of wildcard, prefix, fuzzy and range queries are to be automatically
   * lower-cased or not.  Default is <code>true</code>.
   */
  public void setLowercaseExpandedTerms(boolean lowercaseExpandedTerms) {
    this.lowercaseExpandedTerms = lowercaseExpandedTerms;
  }


  /**
   * @see #setLowercaseExpandedTerms(boolean)
   */
  public boolean getLowercaseExpandedTerms() {
    return lowercaseExpandedTerms;
  }

  /**
   * By default QueryParser uses {@link MultiTermQuery#CONSTANT_SCORE_AUTO_REWRITE_DEFAULT}
   * when creating a PrefixQuery, WildcardQuery or RangeQuery. This implementation is generally preferable because it 
   * a) Runs faster b) Does not have the scarcity of terms unduly influence score 
   * c) avoids any "TooManyBooleanClauses" exception.
   * However, if your application really needs to use the
   * old-fashioned BooleanQuery expansion rewriting and the above
   * points are not relevant then use this to change
   * the rewrite method.
   */
  public void setMultiTermRewriteMethod(MultiTermQuery.RewriteMethod method) {
    multiTermRewriteMethod = method;
  }


  /**
   * @see #setMultiTermRewriteMethod
   */
  public MultiTermQuery.RewriteMethod getMultiTermRewriteMethod() {
    return multiTermRewriteMethod;
  }

  /**
   * Set locale used by date range parsing.
   */
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * Returns current locale, allowing access by subclasses.
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * Sets the default date resolution used by RangeQueries for fields for which no
   * specific date resolutions has been set. Field specific resolutions can be set
   * with {@link #setDateResolution(String, DateTools.Resolution)}.
   *  
   * @param dateResolution the default date resolution to set
   */
  public void setDateResolution(DateTools.Resolution dateResolution) {
    this.dateResolution = dateResolution;
  }

  /**
   * Sets the date resolution used by RangeQueries for a specific field.
   *  
   * @param fieldName field for which the date resolution is to be set 
   * @param dateResolution date resolution to set
   */
  public void setDateResolution(String fieldName, DateTools.Resolution dateResolution) {
    if (fieldName == null) {
      throw new IllegalArgumentException("Field cannot be null.");
    }

    if (fieldToDateResolution == null) {
      // lazily initialize HashMap
      fieldToDateResolution = new HashMap<String,DateTools.Resolution>();
    }

    fieldToDateResolution.put(fieldName, dateResolution);
  }

  /**
   * Returns the date resolution that is used by RangeQueries for the given field. 
   * Returns null, if no default or field specific date resolution has been set
   * for the given field.
   *
   */
  public DateTools.Resolution getDateResolution(String fieldName) {
    if (fieldName == null) {
      throw new IllegalArgumentException("Field cannot be null.");
    }

    if (fieldToDateResolution == null) {
      // no field specific date resolutions set; return default date resolution instead
      return this.dateResolution;
    }

    DateTools.Resolution resolution = fieldToDateResolution.get(fieldName);
    if (resolution == null) {
      // no date resolutions set for the given field; return default date resolution instead
      resolution = this.dateResolution;
    }

    return resolution;
  }

  /** 
   * Sets the collator used to determine index term inclusion in ranges
   * for RangeQuerys.
   * <p/>
   * <strong>WARNING:</strong> Setting the rangeCollator to a non-null
   * collator using this method will cause every single index Term in the
   * Field referenced by lowerTerm and/or upperTerm to be examined.
   * Depending on the number of index Terms in this Field, the operation could
   * be very slow.
   *
   *  @param rc  the collator to use when constructing RangeQuerys
   */
  public void setRangeCollator(Collator rc) {
    rangeCollator = rc;
  }

  /**
   * @return the collator used to determine index term inclusion in ranges
   * for RangeQuerys.
   */
  public Collator getRangeCollator() {
    return rangeCollator;
  }

  protected void addClause(List<BooleanClause> clauses, int conj, int mods, Query q) {
    boolean required, prohibited;

    // If this term is introduced by AND, make the preceding term required,
    // unless it's already prohibited
    if (clauses.size() > 0 && conj == CONJ_AND) {
      BooleanClause c = clauses.get(clauses.size()-1);
      if (!c.isProhibited())
        c.setOccur(BooleanClause.Occur.MUST);
    }

    if (clauses.size() > 0 && operator == AND_OPERATOR && conj == CONJ_OR) {
      // If this term is introduced by OR, make the preceding term optional,
      // unless it's prohibited (that means we leave -a OR b but +a OR b-->a OR b)
      // notice if the input is a OR b, first term is parsed as required; without
      // this modification a OR b would parsed as +a OR b
      BooleanClause c = clauses.get(clauses.size()-1);
      if (!c.isProhibited())
        c.setOccur(BooleanClause.Occur.SHOULD);
    }

    // We might have been passed a null query; the term might have been
    // filtered away by the analyzer.
    if (q == null)
      return;

    if (operator == OR_OPERATOR) {
      // We set REQUIRED if we're introduced by AND or +; PROHIBITED if
      // introduced by NOT or -; make sure not to set both.
      prohibited = (mods == MOD_NOT);
      required = (mods == MOD_REQ);
      if (conj == CONJ_AND && !prohibited) {
        required = true;
      }
    } else {
      // We set PROHIBITED if we're introduced by NOT or -; We set REQUIRED
      // if not PROHIBITED and not introduced by OR
      prohibited = (mods == MOD_NOT);
      required   = (!prohibited && conj != CONJ_OR);
    }
    if (required && !prohibited)
      clauses.add(newBooleanClause(q, BooleanClause.Occur.MUST));
    else if (!required && !prohibited)
      clauses.add(newBooleanClause(q, BooleanClause.Occur.SHOULD));
    else if (!required && prohibited)
      clauses.add(newBooleanClause(q, BooleanClause.Occur.MUST_NOT));
    else
      throw new RuntimeException("Clause cannot be both required and prohibited");
  }

  /**
   * @deprecated Use {@link #getFieldQuery(String,String,boolean)} instead.
   */
  @Deprecated
  protected Query getFieldQuery(String field, String queryText) throws ParseException {
    // treat the text as if it was quoted, to drive phrase logic with old versions.
    return getFieldQuery(field, queryText, true);
  }

  /**
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getFieldQuery(String field, String queryText, boolean quoted)  throws ParseException {
    // Use the analyzer to get all the tokens, and then build a TermQuery,
    // PhraseQuery, or nothing based on the term count
    TokenStream source;
    try {
      source = analyzer.reusableTokenStream(field, new StringReader(queryText));
      source.reset();
    } catch (IOException e) {
      source = analyzer.tokenStream(field, new StringReader(queryText));
    }
    CachingTokenFilter buffer = new CachingTokenFilter(source);
    CharTermAttribute termAtt = null;
    PositionIncrementAttribute posIncrAtt = null;
    int numTokens = 0;

    boolean success = false;
    try {
      buffer.reset();
      success = true;
    } catch (IOException e) {
      // success==false if we hit an exception
    }
    if (success) {
      if (buffer.hasAttribute(CharTermAttribute.class)) {
        termAtt = buffer.getAttribute(CharTermAttribute.class);
      }
      if (buffer.hasAttribute(PositionIncrementAttribute.class)) {
        posIncrAtt = buffer.getAttribute(PositionIncrementAttribute.class);
      }
    }

    int positionCount = 0;
    boolean severalTokensAtSamePosition = false;

    boolean hasMoreTokens = false;
    if (termAtt != null) {
      try {
        hasMoreTokens = buffer.incrementToken();
        while (hasMoreTokens) {
          numTokens++;
          int positionIncrement = (posIncrAtt != null) ? posIncrAtt.getPositionIncrement() : 1;
          if (positionIncrement != 0) {
            positionCount += positionIncrement;
          } else {
            severalTokensAtSamePosition = true;
          }
          hasMoreTokens = buffer.incrementToken();
        }
      } catch (IOException e) {
        // ignore
      }
    }
    try {
      // rewind the buffer stream
      buffer.reset();

      // close original stream - all tokens buffered
      source.close();
    }
    catch (IOException e) {
      // ignore
    }

    if (numTokens == 0)
      return null;
    else if (numTokens == 1) {
      String term = null;
      try {
        boolean hasNext = buffer.incrementToken();
        assert hasNext == true;
        term = termAtt.toString();
      } catch (IOException e) {
        // safe to ignore, because we know the number of tokens
      }
      return newTermQuery(new Term(field, term));
    } else {
      if (severalTokensAtSamePosition || (!quoted && !autoGeneratePhraseQueries)) {
        if (positionCount == 1 || (!quoted && !autoGeneratePhraseQueries)) {
          // no phrase query:
          BooleanQuery q = newBooleanQuery(positionCount == 1);

          BooleanClause.Occur occur = positionCount > 1 && operator == AND_OPERATOR ?
            BooleanClause.Occur.MUST : BooleanClause.Occur.SHOULD;

          for (int i = 0; i < numTokens; i++) {
            String term = null;
            try {
              boolean hasNext = buffer.incrementToken();
              assert hasNext == true;
              term = termAtt.toString();
            } catch (IOException e) {
              // safe to ignore, because we know the number of tokens
            }
           
            Query currentQuery = newTermQuery(
                new Term(field, term));
            q.add(currentQuery, occur);
          }
          return q;
        }
        else {
          // phrase query:
          MultiPhraseQuery mpq = newMultiPhraseQuery();
          mpq.setSlop(phraseSlop);
          List<Term> multiTerms = new ArrayList<Term>();
          int position = -1;
          for (int i = 0; i < numTokens; i++) {
            String term = null;
            int positionIncrement = 1;
            try {
              boolean hasNext = buffer.incrementToken();
              assert hasNext == true;
              term = termAtt.toString();
              if (posIncrAtt != null) {
                positionIncrement = posIncrAtt.getPositionIncrement();
              }
            } catch (IOException e) {
              // safe to ignore, because we know the number of tokens
            }

            if (positionIncrement > 0 && multiTerms.size() > 0) {
              if (enablePositionIncrements) {
                mpq.add(multiTerms.toArray(new Term[0]),position);
              } else {
                mpq.add(multiTerms.toArray(new Term[0]));
              }
              multiTerms.clear();
            }
            position += positionIncrement;
            
            multiTerms.add(new Term(field, term));
          }
          if (enablePositionIncrements) {
            mpq.add(multiTerms.toArray(new Term[0]),position);
          } else {
            mpq.add(multiTerms.toArray(new Term[0]));
          }
          return mpq;
        }
      }
      else {
        PhraseQuery pq = newPhraseQuery();
        pq.setSlop(phraseSlop);
        int position = -1;


        for (int i = 0; i < numTokens; i++) {
          String term = null;
          int positionIncrement = 1;

          try {
            boolean hasNext = buffer.incrementToken();
            assert hasNext == true;
            term = termAtt.toString();
            if (posIncrAtt != null) {
              positionIncrement = posIncrAtt.getPositionIncrement();
            }
          } catch (IOException e) {
            // safe to ignore, because we know the number of tokens
          }
         
          if (enablePositionIncrements) {
            position += positionIncrement;
            pq.add(new Term(field, term),position);
          } else {
            pq.add(new Term(field, term));
          }
        }
        return pq;
      }
    }
  }



  /**
   * Base implementation delegates to {@link #getFieldQuery(String,String,boolean)}.
   * This method may be overridden, for example, to return
   * a SpanNearQuery instead of a PhraseQuery.
   *
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getFieldQuery(String field, String queryText, int slop)
        throws ParseException {
    Query query = hasNewAPI ? getFieldQuery(field, queryText, true) : getFieldQuery(field, queryText);

    if (query instanceof PhraseQuery) {
      ((PhraseQuery) query).setSlop(slop);
    }
    if (query instanceof MultiPhraseQuery) {
      ((MultiPhraseQuery) query).setSlop(slop);
    }

    return query;
  }


  /**
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getRangeQuery(String field,
                                String part1,
                                String part2,
                                boolean inclusive) throws ParseException
  {
    if (lowercaseExpandedTerms) {
      part1 = part1.toLowerCase();
      part2 = part2.toLowerCase();
    }
    try {
      DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
      df.setLenient(true);
      Date d1 = df.parse(part1);
      Date d2 = df.parse(part2);
      if (inclusive) {
        // The user can only specify the date, not the time, so make sure
        // the time is set to the latest possible time of that date to really
        // include all documents:
        Calendar cal = Calendar.getInstance(locale);
        cal.setTime(d2);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        d2 = cal.getTime();
      }
      DateTools.Resolution resolution = getDateResolution(field);
      if (resolution == null) {
        // no default or field specific date resolution has been set,
        // use deprecated DateField to maintain compatibility with
        // pre-1.9 Lucene versions.
        part1 = DateField.dateToString(d1);
        part2 = DateField.dateToString(d2);
      } else {
        part1 = DateTools.dateToString(d1, resolution);
        part2 = DateTools.dateToString(d2, resolution);
      }
    }
    catch (Exception e) { }

    return newRangeQuery(field, part1, part2, inclusive);
  }

 /**
  * Builds a new BooleanQuery instance
  * @param disableCoord disable coord
  * @return new BooleanQuery instance
  */
  protected BooleanQuery newBooleanQuery(boolean disableCoord) {
    return new BooleanQuery(disableCoord);
  }

 /**
  * Builds a new BooleanClause instance
  * @param q sub query
  * @param occur how this clause should occur when matching documents
  * @return new BooleanClause instance
  */
  protected BooleanClause newBooleanClause(Query q, BooleanClause.Occur occur) {
    return new BooleanClause(q, occur);
  }

  /**
   * Builds a new TermQuery instance
   * @param term term
   * @return new TermQuery instance
   */
  protected Query newTermQuery(Term term){
    return new TermQuery(term);
  }

  /**
   * Builds a new PhraseQuery instance
   * @return new PhraseQuery instance
   */
  protected PhraseQuery newPhraseQuery(){
    return new PhraseQuery();
  }

  /**
   * Builds a new MultiPhraseQuery instance
   * @return new MultiPhraseQuery instance
   */
  protected MultiPhraseQuery newMultiPhraseQuery(){
    return new MultiPhraseQuery();
  }

  /**
   * Builds a new PrefixQuery instance
   * @param prefix Prefix term
   * @return new PrefixQuery instance
   */
  protected Query newPrefixQuery(Term prefix){
    PrefixQuery query = new PrefixQuery(prefix);
    query.setRewriteMethod(multiTermRewriteMethod);
    return query;
  }

  /**
   * Builds a new FuzzyQuery instance
   * @param term Term
   * @param minimumSimilarity minimum similarity
   * @param prefixLength prefix length
   * @return new FuzzyQuery Instance
   */
  protected Query newFuzzyQuery(Term term, float minimumSimilarity, int prefixLength) {
    // FuzzyQuery doesn't yet allow constant score rewrite
    return new FuzzyQuery(term,minimumSimilarity,prefixLength);
  }

  /**
   * Builds a new TermRangeQuery instance
   * @param field Field
   * @param part1 min
   * @param part2 max
   * @param inclusive true if range is inclusive
   * @return new TermRangeQuery instance
   */
  protected Query newRangeQuery(String field, String part1, String part2, boolean inclusive) {
	 if(isInteger(part1) && isInteger(part1)) {
       final NumericRangeQuery<?> query = NumericRangeQuery.newIntRange(field+"_sortable", Integer.parseInt(part1), Integer.parseInt(part2), true, true);
	   query.setRewriteMethod(multiTermRewriteMethod);
	   return query;
	 }else if(isDouble(part1) && isDouble(part2)) {
	   final NumericRangeQuery<?> query = NumericRangeQuery.newDoubleRange(field+"_sortable", Double.parseDouble(part1), Double.parseDouble(part2), true, true);
	   query.setRewriteMethod(multiTermRewriteMethod);
	   return query;
	 }else {
       final TermRangeQuery query = new TermRangeQuery(field, part1, part2, inclusive, inclusive, rangeCollator);
       query.setRewriteMethod(multiTermRewriteMethod);
       return query;
	 }
  }
  
  private static boolean isDouble(String str) {
	boolean result = false;
	try {
	  Double.parseDouble(str) ;
	  result = true;
	} catch (Exception e) {}
	return result;
  }
	
  private static boolean isInteger(String str) {
  	boolean result = false;
  	try {
  	  Integer.parseInt(str) ;
  	  result = true;
  	} catch (Exception e) {}
	return result;
  }

  /**
   * Builds a new MatchAllDocsQuery instance
   * @return new MatchAllDocsQuery instance
   */
  protected Query newMatchAllDocsQuery() {
    return new MatchAllDocsQuery();
  }

  /**
   * Builds a new WildcardQuery instance
   * @param t wildcard term
   * @return new WildcardQuery instance
   */
  protected Query newWildcardQuery(Term t) {
    WildcardQuery query = new WildcardQuery(t);
    query.setRewriteMethod(multiTermRewriteMethod);
    return query;
  }

  /**
   * Factory method for generating query, given a set of clauses.
   * By default creates a boolean query composed of clauses passed in.
   *
   * Can be overridden by extending classes, to modify query being
   * returned.
   *
   * @param clauses List that contains {@link BooleanClause} instances
   *    to join.
   *
   * @return Resulting {@link Query} object.
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getBooleanQuery(List<BooleanClause> clauses) throws ParseException {
    return getBooleanQuery(clauses, false);
  }

  /**
   * Factory method for generating query, given a set of clauses.
   * By default creates a boolean query composed of clauses passed in.
   *
   * Can be overridden by extending classes, to modify query being
   * returned.
   *
   * @param clauses List that contains {@link BooleanClause} instances
   *    to join.
   * @param disableCoord true if coord scoring should be disabled.
   *
   * @return Resulting {@link Query} object.
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getBooleanQuery(List<BooleanClause> clauses, boolean disableCoord)
    throws ParseException
  {
    if (clauses.size()==0) {
      return null; // all clause words were filtered away by the analyzer.
    }
    BooleanQuery query = newBooleanQuery(disableCoord);
    for(final BooleanClause clause: clauses) {
      query.add(clause);
    }
    return query;
  }

  /**
   * Factory method for generating a query. Called when parser
   * parses an input term token that contains one or more wildcard
   * characters (? and *), but is not a prefix term token (one
   * that has just a single * character at the end)
   *<p>
   * Depending on settings, prefix term may be lower-cased
   * automatically. It will not go through the default Analyzer,
   * however, since normal Analyzers are unlikely to work properly
   * with wildcard templates.
   *<p>
   * Can be overridden by extending classes, to provide custom handling for
   * wildcard queries, which may be necessary due to missing analyzer calls.
   *
   * @param field Name of the field query will use.
   * @param termStr Term token that contains one or more wild card
   *   characters (? or *), but is not simple prefix term
   *
   * @return Resulting {@link Query} built for the term
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getWildcardQuery(String field, String termStr) throws ParseException
  {
    if ("*".equals(field)) {
      if ("*".equals(termStr)) return newMatchAllDocsQuery();
    }
    if (!allowLeadingWildcard && (termStr.startsWith("*") || termStr.startsWith("?")))
      throw new ParseException("'*' or '?' not allowed as first character in WildcardQuery");
    if (lowercaseExpandedTerms) {
      termStr = termStr.toLowerCase();
    }
    Term t = new Term(field, termStr);
    return newWildcardQuery(t);
  }

  /**
   * Factory method for generating a query (similar to
   * {@link #getWildcardQuery}). Called when parser parses an input term
   * token that uses prefix notation; that is, contains a single '*' wildcard
   * character as its last character. Since this is a special case
   * of generic wildcard term, and such a query can be optimized easily,
   * this usually results in a different query object.
   *<p>
   * Depending on settings, a prefix term may be lower-cased
   * automatically. It will not go through the default Analyzer,
   * however, since normal Analyzers are unlikely to work properly
   * with wildcard templates.
   *<p>
   * Can be overridden by extending classes, to provide custom handling for
   * wild card queries, which may be necessary due to missing analyzer calls.
   *
   * @param field Name of the field query will use.
   * @param termStr Term token to use for building term for the query
   *    (<b>without</b> trailing '*' character!)
   *
   * @return Resulting {@link Query} built for the term
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getPrefixQuery(String field, String termStr) throws ParseException
  {
    if (!allowLeadingWildcard && termStr.startsWith("*"))
      throw new ParseException("'*' not allowed as first character in PrefixQuery");
    if (lowercaseExpandedTerms) {
      termStr = termStr.toLowerCase();
    }
    Term t = new Term(field, termStr);
    return newPrefixQuery(t);
  }

   /**
   * Factory method for generating a query (similar to
   * {@link #getWildcardQuery}). Called when parser parses
   * an input term token that has the fuzzy suffix (~) appended.
   *
   * @param field Name of the field query will use.
   * @param termStr Term token to use for building term for the query
   *
   * @return Resulting {@link Query} built for the term
   * @exception ParseException throw in overridden method to disallow
   */
  protected Query getFuzzyQuery(String field, String termStr, float minSimilarity) throws ParseException
  {
    if (lowercaseExpandedTerms) {
      termStr = termStr.toLowerCase();
    }
    Term t = new Term(field, termStr);
    return newFuzzyQuery(t, minSimilarity, fuzzyPrefixLength);
  }

  /**
   * Returns a String where the escape char has been
   * removed, or kept only once if there was a double escape.
   * 
   * Supports escaped unicode characters, e. g. translates
   * <code>\\u0041</code> to <code>A</code>.
   * 
   */
  private String discardEscapeChar(String input) throws ParseException {
    // Create char array to hold unescaped char sequence
    char[] output = new char[input.length()];

    // The length of the output can be less than the input
    // due to discarded escape chars. This variable holds
    // the actual length of the output
    int length = 0;

    // We remember whether the last processed character was 
    // an escape character
    boolean lastCharWasEscapeChar = false;

    // The multiplier the current unicode digit must be multiplied with.
    // E. g. the first digit must be multiplied with 16^3, the second with 16^2...
    int codePointMultiplier = 0;

    // Used to calculate the codepoint of the escaped unicode character
    int codePoint = 0;

    for (int i = 0; i < input.length(); i++) {
      char curChar = input.charAt(i);
      if (codePointMultiplier > 0) {
        codePoint += hexToInt(curChar) * codePointMultiplier;
        codePointMultiplier >>>= 4;
        if (codePointMultiplier == 0) {
          output[length++] = (char)codePoint;
          codePoint = 0;
        }
      } else if (lastCharWasEscapeChar) {
        if (curChar == 'u') {
          // found an escaped unicode character
          codePointMultiplier = 16 * 16 * 16;
        } else {
          // this character was escaped
          output[length] = curChar;
          length++;
        }
        lastCharWasEscapeChar = false;
      } else {
        if (curChar == '\\') {
          lastCharWasEscapeChar = true;
        } else {
          output[length] = curChar;
          length++;
        }
      }
    }

    if (codePointMultiplier > 0) {
      throw new ParseException("Truncated unicode escape sequence.");
    }

    if (lastCharWasEscapeChar) {
      throw new ParseException("Term can not end with escape character.");
    }

    return new String(output, 0, length);
  }

  /** Returns the numeric value of the hexadecimal character */
  private static final int hexToInt(char c) throws ParseException {
    if ('0' <= c && c <= '9') {
      return c - '0';
    } else if ('a' <= c && c <= 'f'){
      return c - 'a' + 10;
    } else if ('A' <= c && c <= 'F') {
      return c - 'A' + 10;
    } else {
      throw new ParseException("None-hex character in unicode escape sequence: " + c);
    }
  }

  /**
   * Returns a String where those characters that QueryParser
   * expects to be escaped are escaped by a preceding <code>\</code>.
   */
  public static String escape(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // These characters are part of the query syntax and must be escaped
      if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == ':'
        || c == '^' || c == '[' || c == ']' || c == '\"' || c == '{' || c == '}' || c == '~'
        || c == '*' || c == '?' || c == '|' || c == '&') {
        sb.append('\\');
      }
      sb.append(c);
    }
    return sb.toString();
  }

  /**
   * Command line tool to test QueryParser, using {@link org.apache.lucene.analysis.SimpleAnalyzer}.
   * Usage:<br>
   * <code>java org.apache.lucene.queryParser.QueryParser &lt;input&gt;</code>
   */
  public static void main(String[] args) throws Exception {
    if (args.length == 0) {
      System.out.println("Usage: java org.apache.lucene.queryParser.QueryParser <input>");
      System.exit(0);
    }
    QueryParser qp = new QueryParser(Version.LUCENE_CURRENT, "field",
                           new org.apache.lucene.analysis.SimpleAnalyzer());
    Query q = qp.parse(args[0]);
    System.out.println(q.toString("field"));
  }

// *   Query  ::= ( Clause )*
// *   Clause ::= ["+", "-"] [<TERM> ":"] ( <TERM> | "(" Query ")" )
  final public int Conjunction() throws ParseException {
  int ret = CONJ_NONE;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AND:
    case OR:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        jj_consume_token(AND);
            ret = CONJ_AND;
        break;
      case OR:
        jj_consume_token(OR);
              ret = CONJ_OR;
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public int Modifiers() throws ParseException {
  int ret = MOD_NONE;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NOT:
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        jj_consume_token(PLUS);
              ret = MOD_REQ;
        break;
      case MINUS:
        jj_consume_token(MINUS);
                 ret = MOD_NOT;
        break;
      case NOT:
        jj_consume_token(NOT);
               ret = MOD_NOT;
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

// This makes sure that there is no garbage after the query string
  final public Query TopLevelQuery(String field) throws ParseException {
        Query q;
    q = Query(field);
    jj_consume_token(0);
                {if (true) return q;}
    throw new Error("Missing return statement in function");
  }

  final public Query Query(String field) throws ParseException {
  List<BooleanClause> clauses = new ArrayList<BooleanClause>();
  Query q, firstQuery=null;
  int conj, mods;
    mods = Modifiers();
    q = Clause(field);
    addClause(clauses, CONJ_NONE, mods, q);
    if (mods == MOD_NONE)
        firstQuery=q;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
      case OR:
      case NOT:
      case PLUS:
      case MINUS:
      case LPAREN:
      case STAR:
      case QUOTED:
      case TERM:
      case PREFIXTERM:
      case WILDTERM:
      case RANGEIN_START:
      case RANGEEX_START:
      case NUMBER:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_1;
      }
      conj = Conjunction();
      mods = Modifiers();
      q = Clause(field);
      addClause(clauses, conj, mods, q);
    }
      if (clauses.size() == 1 && firstQuery != null)
        {if (true) return firstQuery;}
      else {
  {if (true) return getBooleanQuery(clauses);}
      }
    throw new Error("Missing return statement in function");
  }

  final public Query Clause(String field) throws ParseException {
  Query q;
  Token fieldToken=null, boost=null;
    if (jj_2_1(2)) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TERM:
        fieldToken = jj_consume_token(TERM);
        jj_consume_token(COLON);
                               field=discardEscapeChar(fieldToken.image);
        break;
      case STAR:
        jj_consume_token(STAR);
        jj_consume_token(COLON);
                      field="*";
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
    case QUOTED:
    case TERM:
    case PREFIXTERM:
    case WILDTERM:
    case RANGEIN_START:
    case RANGEEX_START:
    case NUMBER:
      q = Term(field);
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      q = Query(field);
      jj_consume_token(RPAREN);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARAT:
        jj_consume_token(CARAT);
        boost = jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      if (boost != null) {
        float f = (float)1.0;
  try {
    f = Float.valueOf(boost.image).floatValue();
          q.setBoost(f);
  } catch (Exception ignored) { }
      }
      {if (true) return q;}
    throw new Error("Missing return statement in function");
  }

  final public Query Term(String field) throws ParseException {
  Token term, boost=null, fuzzySlop=null, goop1, goop2;
  boolean prefix = false;
  boolean wildcard = false;
  boolean fuzzy = false;
  Query q;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STAR:
    case TERM:
    case PREFIXTERM:
    case WILDTERM:
    case NUMBER:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case TERM:
        term = jj_consume_token(TERM);
        break;
      case STAR:
        term = jj_consume_token(STAR);
                       wildcard=true;
        break;
      case PREFIXTERM:
        term = jj_consume_token(PREFIXTERM);
                             prefix=true;
        break;
      case WILDTERM:
        term = jj_consume_token(WILDTERM);
                           wildcard=true;
        break;
      case NUMBER:
        term = jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUZZY_SLOP:
        fuzzySlop = jj_consume_token(FUZZY_SLOP);
                                fuzzy=true;
        break;
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARAT:
        jj_consume_token(CARAT);
        boost = jj_consume_token(NUMBER);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FUZZY_SLOP:
          fuzzySlop = jj_consume_token(FUZZY_SLOP);
                                                         fuzzy=true;
          break;
        default:
          jj_la1[10] = jj_gen;
          ;
        }
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
       String termImage=discardEscapeChar(term.image);
       if (wildcard) {
       q = getWildcardQuery(field, termImage);
       } else if (prefix) {
         q = getPrefixQuery(field,
           discardEscapeChar(term.image.substring
          (0, term.image.length()-1)));
       } else if (fuzzy) {
          float fms = fuzzyMinSim;
          try {
            fms = Float.valueOf(fuzzySlop.image.substring(1)).floatValue();
          } catch (Exception ignored) { }
         if(fms < 0.0f || fms > 1.0f){
           {if (true) throw new ParseException("Minimum similarity for a FuzzyQuery has to be between 0.0f and 1.0f !");}
         }
         q = getFuzzyQuery(field, termImage,fms);
       } else {
         q = hasNewAPI ? getFieldQuery(field, termImage, false) : getFieldQuery(field, termImage);
       }
      break;
    case RANGEIN_START:
      jj_consume_token(RANGEIN_START);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEIN_GOOP:
        goop1 = jj_consume_token(RANGEIN_GOOP);
        break;
      case RANGEIN_QUOTED:
        goop1 = jj_consume_token(RANGEIN_QUOTED);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEIN_TO:
        jj_consume_token(RANGEIN_TO);
        break;
      default:
        jj_la1[13] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEIN_GOOP:
        goop2 = jj_consume_token(RANGEIN_GOOP);
        break;
      case RANGEIN_QUOTED:
        goop2 = jj_consume_token(RANGEIN_QUOTED);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(RANGEIN_END);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARAT:
        jj_consume_token(CARAT);
        boost = jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[15] = jj_gen;
        ;
      }
          if (goop1.kind == RANGEIN_QUOTED) {
            goop1.image = goop1.image.substring(1, goop1.image.length()-1);
          }
          if (goop2.kind == RANGEIN_QUOTED) {
            goop2.image = goop2.image.substring(1, goop2.image.length()-1);
          }
          q = getRangeQuery(field, discardEscapeChar(goop1.image), discardEscapeChar(goop2.image), true);
      break;
    case RANGEEX_START:
      jj_consume_token(RANGEEX_START);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEEX_GOOP:
        goop1 = jj_consume_token(RANGEEX_GOOP);
        break;
      case RANGEEX_QUOTED:
        goop1 = jj_consume_token(RANGEEX_QUOTED);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEEX_TO:
        jj_consume_token(RANGEEX_TO);
        break;
      default:
        jj_la1[17] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case RANGEEX_GOOP:
        goop2 = jj_consume_token(RANGEEX_GOOP);
        break;
      case RANGEEX_QUOTED:
        goop2 = jj_consume_token(RANGEEX_QUOTED);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(RANGEEX_END);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARAT:
        jj_consume_token(CARAT);
        boost = jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[19] = jj_gen;
        ;
      }
          if (goop1.kind == RANGEEX_QUOTED) {
            goop1.image = goop1.image.substring(1, goop1.image.length()-1);
          }
          if (goop2.kind == RANGEEX_QUOTED) {
            goop2.image = goop2.image.substring(1, goop2.image.length()-1);
          }

          q = getRangeQuery(field, discardEscapeChar(goop1.image), discardEscapeChar(goop2.image), false);
      break;
    case QUOTED:
      term = jj_consume_token(QUOTED);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUZZY_SLOP:
        fuzzySlop = jj_consume_token(FUZZY_SLOP);
        break;
      default:
        jj_la1[20] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CARAT:
        jj_consume_token(CARAT);
        boost = jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[21] = jj_gen;
        ;
      }
         int s = phraseSlop;

         if (fuzzySlop != null) {
           try {
             s = Float.valueOf(fuzzySlop.image.substring(1)).intValue();
           }
           catch (Exception ignored) { }
         }
         q = getFieldQuery(field, discardEscapeChar(term.image.substring(1, term.image.length()-1)), s);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    if (boost != null) {
      float f = (float) 1.0;
      try {
        f = Float.valueOf(boost.image).floatValue();
      }
      catch (Exception ignored) {
    /* Should this be handled somehow? (defaults to "no boost", if
     * boost number is invalid)
     */
      }

      // avoid boosting null queries, such as those caused by stop words
      if (q != null) {
        q.setBoost(f);
      }
    }
    {if (true) return q;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3R_3() {
    if (jj_scan_token(STAR)) return true;
    if (jj_scan_token(COLON)) return true;
    return false;
  }

  private boolean jj_3R_2() {
    if (jj_scan_token(TERM)) return true;
    if (jj_scan_token(COLON)) return true;
    return false;
  }

  private boolean jj_3_1() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_2()) {
    jj_scanpos = xsp;
    if (jj_3R_3()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public QueryParserTokenManager token_source;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[23];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x300,0x300,0x1c00,0x1c00,0x3ed3f00,0x90000,0x20000,0x3ed2000,0x2690000,0x100000,0x100000,0x20000,0x30000000,0x4000000,0x30000000,0x20000,0x0,0x40000000,0x0,0x20000,0x100000,0x20000,0x3ed0000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x0,0x3,0x0,0x0,0x0,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with user supplied CharStream. */
  protected QueryParser(CharStream stream) {
    token_source = new QueryParserTokenManager(stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CharStream stream) {
    token_source.ReInit(stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  protected QueryParser(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(QueryParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 23; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[34];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 23; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 34; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}

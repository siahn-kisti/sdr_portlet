package com.liferay.portal.search.lucene;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.search.QueryTranslator;
import com.liferay.portal.kernel.security.pacl.DoPrivileged;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.MultiTermQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.WildcardQuery;

/**
 * @author goopsw
 */
@DoPrivileged
public class QueryTranslatorImpl implements QueryTranslator {

	@Override
	public Object translate(Query query) throws ParseException {
		if (query instanceof BooleanQueryImpl) {
			return ((BooleanQueryImpl)query).getBooleanQuery();
		}
		else if (query instanceof LuceneQueryImpl) {
			return ((LuceneQueryImpl)query).getQuery();
		}
		else if (query instanceof StringQueryImpl) {
			QueryParser queryParser = new QueryParser(
				LuceneHelperUtil.getVersion(), StringPool.BLANK,
				LuceneHelperUtil.getAnalyzer());
//			QueryParser queryParser = new QueryParser(
//					LuceneHelperUtil.getVersion(), StringPool.BLANK,
//					new KeywordAnalyzer());
			try {
				org.apache.lucene.search.Query qq = queryParser.parse(query.toString());
				return qq;
			}
			catch (org.apache.lucene.queryParser.ParseException pe) {
				throw new ParseException(pe);
			}
		}
		else if (query instanceof TermQueryImpl) {
			return ((TermQueryImpl)query).getTermQuery();
		}
		else if (query instanceof TermRangeQueryImpl) {
			return ((TermRangeQueryImpl)query).getTermRangeQuery();
		}
		else {
			return null;
		}
	}

	@Override
	public Object translateForSolr(Query query) {
		Object queryObject = query.getWrappedQuery();

		if (queryObject instanceof org.apache.lucene.search.Query) {
			adjustQuery((org.apache.lucene.search.Query)queryObject);
		}

		return query;
	}

	protected void adjustQuery(org.apache.lucene.search.Query query) {
		if (query instanceof BooleanQuery) {
			BooleanQuery booleanQuery = (BooleanQuery)query;

			for (BooleanClause booleanClause : booleanQuery.getClauses()) {
				adjustQuery(booleanClause.getQuery());
			}
		}
		else if (query instanceof TermQuery) {
			TermQuery termQuery = (TermQuery)query;

			Term term = termQuery.getTerm();

			try {
				String text = term.text();

				if (text.matches("^\\s*[^\"].*\\s+.*[^\"]\\s*$(?m)")) {
					text = StringPool.QUOTE.concat(text).concat(
						StringPool.QUOTE);

					_textField.set(term, text);
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		else if (query instanceof WildcardQuery) {
			WildcardQuery wildcardQuery = (WildcardQuery)query;

			Term term = wildcardQuery.getTerm();

			try {
				String text = term.text();

				if (Validator.equals(term.field(), Field.TREE_PATH)) {
					text = text.replaceAll("/", "\\\\/");
				}

				if (text.matches("^\\s*\\*.*(?m)")) {
					text = text.replaceFirst("\\*", StringPool.BLANK);

					_textField.set(term, text);
				}
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(QueryTranslatorImpl.class);

	private static java.lang.reflect.Field _textField = null;

	static {
		try {
			_textField = Term.class.getDeclaredField("text");

			_textField.setAccessible(true);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

}
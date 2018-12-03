package com.liferay.portal.search.lucene;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.standard.StandardFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.IOUtils;
import org.apache.lucene.util.Version;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Set;

public class CustomStandardAnalyzer extends StopwordAnalyzerBase {
	/** Default maximum allowed token length */
	public static final int DEFAULT_MAX_TOKEN_LENGTH = 255;

	private int maxTokenLength = DEFAULT_MAX_TOKEN_LENGTH;
	private final boolean replaceInvalidAcronym;

	/**
	 * An unmodifiable set containing some common English words that are usually
	 * not useful for searching.
	 */
	public static final Set<?> STOP_WORDS_SET = StopAnalyzer.ENGLISH_STOP_WORDS_SET;

	/**
	 * Builds an analyzer with the given stop words.
	 * 
	 * @param stopWords
	 *            stop words
	 */
	public CustomStandardAnalyzer(Version matchVersion, Set<?> stopWords) {
		super(matchVersion, stopWords);
		replaceInvalidAcronym = matchVersion.onOrAfter(Version.LUCENE_24);
	}

	public CustomStandardAnalyzer(Version matchVersion) {
		this(matchVersion, STOP_WORDS_SET);
	}

	/**
	 * Builds an analyzer with the default stop words ({@link #STOP_WORDS_SET}).
	 */
	public CustomStandardAnalyzer(Version matchVersion, File stopwords) throws IOException {
		this(matchVersion,
				WordlistLoader.getWordSet(IOUtils.getDecodingReader(stopwords, IOUtils.CHARSET_UTF_8), matchVersion));
	}
	
	public CustomStandardAnalyzer(Version matchVersion, Reader stopwords) throws IOException {
		this(matchVersion, WordlistLoader.getWordSet(stopwords, matchVersion));
	}
	
	public void setMaxTokenLength(int length) {
	    maxTokenLength = length;
	}
	
	public int getMaxTokenLength() {
	    return maxTokenLength;
	}

	@Override
	protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
	    final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
	    src.setMaxTokenLength(maxTokenLength);
	    src.setReplaceInvalidAcronym(replaceInvalidAcronym);
	    TokenStream tok = new StandardFilter(matchVersion, src);
	    //tok = new LowerCaseFilter(matchVersion, tok);
	    tok = new StopFilter(matchVersion, tok, stopwords);
	    return new TokenStreamComponents(src, tok) {
	    	@Override
	    	protected boolean reset(final Reader reader) throws IOException {
	    		src.setMaxTokenLength(CustomStandardAnalyzer.this.maxTokenLength);
	    		return super.reset(reader);
	    	}
	    };
	}

}

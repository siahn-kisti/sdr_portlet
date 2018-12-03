package com.liferay.portal.search.lucene;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactory;
/**
 * @author Jaesung Kim
 */
public class BooleanQueryFactoryImpl implements BooleanQueryFactory {
	
	@Override
	public BooleanQuery create() {
		return new BooleanQueryImpl();
	}
}

/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package mgkportlet.search.spi.model.query.contributor;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true, property = "indexer.class.name=mgkportlet.model.Person",
	service = KeywordQueryContributor.class
)
public class PersonKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(
		String keywords, BooleanQuery booleanQuery,
		KeywordQueryContributorHelper keywordQueryContributorHelper) {

		SearchContext searchContext =
			keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, "name", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "family", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "email", false);
		queryHelper.addSearchTerm(
			booleanQuery, searchContext, "address", false);
		queryHelper.addSearchTerm(
			booleanQuery, searchContext, "description", false);
		//		queryHelper.addSearchTerm(
		//			booleanQuery, searchContext, "lastName", false);
		//		queryHelper.addSearchTerm(
		//			booleanQuery, searchContext, "middleName", false);
		//		queryHelper.addSearchTerm(booleanQuery, searchContext, "region", false);
		//		queryHelper.addSearchTerm(
		//			booleanQuery, searchContext, "screenName", false);
		//		queryHelper.addSearchTerm(booleanQuery, searchContext, "street", false);
		//		queryHelper.addSearchTerm(booleanQuery, searchContext, "zip", false);
	}

	@Reference
	protected QueryHelper queryHelper;

}
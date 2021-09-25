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

package mgkportlet.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import mgkportlet.rest.dto.v1_0.MGKPerson;
import mgkportlet.rest.resource.v1_0.MGKPersonResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author USER
 * @generated
 */
@Generated("")
public class Query {

	public static void setMGKPersonResourceComponentServiceObjects(
		ComponentServiceObjects<MGKPersonResource>
			mgkPersonResourceComponentServiceObjects) {

		_mgkPersonResourceComponentServiceObjects =
			mgkPersonResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {persons(page: ___, pageSize: ___, siteKey: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the persons. Results can be paginated."
	)
	public MGKPersonPage persons(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects,
			this::_populateResourceContext,
			mgkPersonResource -> new MGKPersonPage(
				mgkPersonResource.getPersonsPage(
					Long.valueOf(siteKey), Pagination.of(page, pageSize))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {person(personId: ___, siteKey: ___){email, firstName, id, lastName}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the person.")
	public MGKPerson person(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("personId") Integer personId)
		throws Exception {

		return _applyComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects,
			this::_populateResourceContext,
			mgkPersonResource -> mgkPersonResource.getPerson(
				Long.valueOf(siteKey), personId));
	}

	@GraphQLName("MGKPersonPage")
	public class MGKPersonPage {

		public MGKPersonPage(Page mgkPersonPage) {
			actions = mgkPersonPage.getActions();

			items = mgkPersonPage.getItems();
			lastPage = mgkPersonPage.getLastPage();
			page = mgkPersonPage.getPage();
			pageSize = mgkPersonPage.getPageSize();
			totalCount = mgkPersonPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<MGKPerson> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(MGKPersonResource mgkPersonResource)
		throws Exception {

		mgkPersonResource.setContextAcceptLanguage(_acceptLanguage);
		mgkPersonResource.setContextCompany(_company);
		mgkPersonResource.setContextHttpServletRequest(_httpServletRequest);
		mgkPersonResource.setContextHttpServletResponse(_httpServletResponse);
		mgkPersonResource.setContextUriInfo(_uriInfo);
		mgkPersonResource.setContextUser(_user);
		mgkPersonResource.setGroupLocalService(_groupLocalService);
		mgkPersonResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<MGKPersonResource>
		_mgkPersonResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}
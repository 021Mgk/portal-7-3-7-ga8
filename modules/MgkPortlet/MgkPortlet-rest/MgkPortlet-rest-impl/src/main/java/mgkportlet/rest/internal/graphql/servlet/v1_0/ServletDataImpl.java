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

package mgkportlet.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import mgkportlet.rest.internal.graphql.mutation.v1_0.Mutation;
import mgkportlet.rest.internal.graphql.query.v1_0.Query;
import mgkportlet.rest.resource.v1_0.MGKPersonResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author USER
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setMGKPersonResourceComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects);

		Query.setMGKPersonResourceComponentServiceObjects(
			_mgkPersonResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/MgkPortlet-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MGKPersonResource>
		_mgkPersonResourceComponentServiceObjects;

}
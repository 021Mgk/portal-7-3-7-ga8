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

package mgkportlet.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import mgkportlet.model.Person;
import mgkportlet.rest.dto.v1_0.MGKPerson;
import mgkportlet.rest.internal.dto.v1_0.converter.PersonDTOConverter;
import mgkportlet.rest.resource.v1_0.MGKPersonResource;

import mgkportlet.service.PersonLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;

/**
 * @author USER
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/mgk-person.properties",
	scope = ServiceScope.PROTOTYPE, service = MGKPersonResource.class
)
public class MGKPersonResourceImpl extends BaseMGKPersonResourceImpl {

	@Override
	public Page<MGKPerson> getPersonsPage(@NotNull Long siteId, Pagination pagination) throws Exception {

		int page = 0;
		int pageSize = 20;
		if (pagination != null){
			page = pagination.getPage();
			pageSize = pagination.getPageSize();
		}

		return Page.of(
				transform(
						_personLocalService.getPersons(
								siteId,
								page, pageSize, null),
						this::_toMGKPerson));
	}


	@Override
	public MGKPerson getPerson(@NotNull Long siteId, @NotNull Integer personId) throws Exception {
		return _toMGKPerson(_personLocalService.getPerson(personId));
	}

	@Override
	public void deletePerson(@NotNull Long siteId, @NotNull Integer personId) throws Exception {
		_personLocalService.deletePerson(personId);
	}

	@Override
	public MGKPerson addPerson(@NotNull Long siteId, MGKPerson mgkPerson) throws Exception {
		Person person =  _personLocalService.addPerson(contextUser.getUserId(), mgkPerson.getFirstName() , mgkPerson.getLastName() ,
				mgkPerson.getEmail() , null, null , null , null, null , null , null , null,null);
		return _toMGKPerson(person);
	}

	@Override
	public MGKPerson updatePerson(@NotNull Long siteId, MGKPerson mgkPerson) throws Exception {



		Person person = _personLocalService.updatePerson(contextUser.getUserId() , mgkPerson.getId() , mgkPerson.getFirstName(),
				mgkPerson.getLastName(), mgkPerson.getEmail() , null, null, null , null, null, null
		);

		return _toMGKPerson(person);
	}

	private MGKPerson _toMGKPerson(Person person) throws Exception {
		return _personDTOConverter.toDTO(person);
	}


	@Reference
	private PersonDTOConverter _personDTOConverter;

	@Reference
	private PersonLocalService _personLocalService;

}
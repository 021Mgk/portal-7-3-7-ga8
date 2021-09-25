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

package mgkportlet.rest.internal.dto.v1_0.converter;

import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;
import mgkportlet.model.Person;
import mgkportlet.rest.dto.v1_0.MGKPerson;
import mgkportlet.service.PersonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bijan Moloudi
 */
@Component(
		property = "dto.class.name=mgkportlet.model.Person",
		service = {mgkportlet.rest.internal.dto.v1_0.converter.PersonDTOConverter.class, DTOConverter.class}
)

public class PersonDTOConverter implements DTOConverter<Person, MGKPerson> {

	@Override
	public String getContentType() {
		return MGKPerson.class.getSimpleName();
	}

	@Override
	public MGKPerson toDTO(DTOConverterContext dtoConverterContext)
			throws Exception {

		Person person = _personLocalService.getPerson((Long)dtoConverterContext.getId());

		return _toPerson(person);
	}

	@Override
	public MGKPerson toDTO(Person person) throws Exception {
		return _toPerson(person);
	}

	private MGKPerson _toPerson(Person person) throws Exception {
		return new MGKPerson() {
			{
				firstName = person.getName();
				lastName = person.getFamily();
				email = person.getEmail();
				id = person.getPersonId();
			}
		};
	}

	@Reference
	private PersonLocalService _personLocalService;

}
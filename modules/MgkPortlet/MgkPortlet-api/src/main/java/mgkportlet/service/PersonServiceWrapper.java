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

package mgkportlet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersonService}.
 *
 * @author 021mgk
 * @see PersonService
 * @generated
 */
public class PersonServiceWrapper
	implements PersonService, ServiceWrapper<PersonService> {

	public PersonServiceWrapper(PersonService personService) {
		_personService = personService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 * <p>
	 * Never reference this class directly. Always use <code>mgkportlet.service.PersonServiceUtil</code> to access the person remote service.
	 */
	@Override
	public mgkportlet.model.Person addPerson(
			long pId, String name, String family, String email, String address,
			String phoneNumber, String nationalCode, String description,
			String image, java.io.InputStream inputStream, String contentType,
			Long size,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.addPerson(
			pId, name, family, email, address, phoneNumber, nationalCode,
			description, image, inputStream, contentType, size, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _personService.getOSGiServiceIdentifier();
	}

	@Override
	public mgkportlet.model.Person updatePerson(
			long pId, long personId, String name, String family, String email,
			String address, String phoneNumber, String nationalCode,
			String description, String image,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _personService.updatePerson(
			pId, personId, name, family, email, address, phoneNumber,
			nationalCode, description, image, serviceContext);
	}

	@Override
	public PersonService getWrappedService() {
		return _personService;
	}

	@Override
	public void setWrappedService(PersonService personService) {
		_personService = personService;
	}

	private PersonService _personService;

}
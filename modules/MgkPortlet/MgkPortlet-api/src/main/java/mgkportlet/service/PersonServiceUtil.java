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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Person. This utility wraps
 * <code>mgkportlet.service.impl.PersonServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author 021mgk
 * @see PersonService
 * @generated
 */
public class PersonServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>mgkportlet.service.impl.PersonServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 * <p>
	 * Never reference this class directly. Always use <code>mgkportlet.service.PersonServiceUtil</code> to access the person remote service.
	 */
	public static mgkportlet.model.Person addPerson(
			long pId, String name, String family, String email, String address,
			String phoneNumber, String nationalCode, String description,
			String image, java.io.InputStream inputStream, String contentType,
			Long size,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPerson(
			pId, name, family, email, address, phoneNumber, nationalCode,
			description, image, inputStream, contentType, size, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static mgkportlet.model.Person updatePerson(
			long pId, long personId, String name, String family, String email,
			String address, String phoneNumber, String nationalCode,
			String description, String image,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePerson(
			pId, personId, name, family, email, address, phoneNumber,
			nationalCode, description, image, serviceContext);
	}

	public static PersonService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonService, PersonService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersonService.class);

		ServiceTracker<PersonService, PersonService> serviceTracker =
			new ServiceTracker<PersonService, PersonService>(
				bundle.getBundleContext(), PersonService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
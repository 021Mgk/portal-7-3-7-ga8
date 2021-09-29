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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.InputStream;

import mgkportlet.model.Person;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Person. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author 021mgk
 * @see PersonServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersonService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>mgkportlet.service.impl.PersonServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the person remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersonServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 * <p>
	 * Never reference this class directly. Always use <code>mgkportlet.service.PersonServiceUtil</code> to access the person remote service.
	 */
	public Person addPerson(
			long pId, String name, String family, String email, String address,
			String phoneNumber, String nationalCode, String description,
			String image, InputStream inputStream, String contentType,
			Long size, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Person updatePerson(
			long pId, long personId, String name, String family, String email,
			String address, String phoneNumber, String nationalCode,
			String description, String image, ServiceContext serviceContext)
		throws PortalException;

}
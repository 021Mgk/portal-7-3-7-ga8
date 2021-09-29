/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package mgkportlet.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import mgkportlet.model.Person;
import mgkportlet.service.base.PersonServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.InputStream;

/**
 * The implementation of the person remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>mgkportlet.service.PersonService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author 021mgk
 * @see PersonServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=mgk",
                "json.web.service.context.path=Person"
        },
        service = AopService.class
)
public class PersonServiceImpl extends PersonServiceBaseImpl {

    /**
     * NOTE FOR DEVELOPERS:
     * <p>
     * Never reference this class directly. Always use <code>mgkportlet.service.PersonServiceUtil</code> to access the person remote service.
     */


    public Person addPerson(
            long pId, String name, String family, String email, String address,
            String phoneNumber, String nationalCode, String description,
            String image, InputStream inputStream, String contentType, Long size,
            ServiceContext serviceContext) throws PortalException {

        PortletResourcePermission portletResourcePermission = _personModelResourcePermission.getPortletResourcePermission();

        portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), ActionKeys.ADD_ENTRY);


        return personLocalService.addPerson(pId, name, family, email, address,
                phoneNumber, nationalCode, description, image, inputStream, contentType, size, serviceContext);
    }


    public Person updatePerson(
            long pId, long personId, String name, String family, String email,
            String address, String phoneNumber, String nationalCode,
            String description, String image, ServiceContext serviceContext)
            throws PortalException {


    	_personModelResourcePermission.check(getPermissionChecker() , personId , ActionKeys.UPDATE);

        return personLocalService.updatePerson(
                pId, personId, name, family, email, address, phoneNumber, nationalCode, description, image, serviceContext);
    }


    @Reference(target = "(model.class.name=mgkportlet.model.Person)")
    private ModelResourcePermission<Person> _personModelResourcePermission;


}
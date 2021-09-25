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

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import mgkportlet.model.Person;

import mgkportlet.service.base.PersonLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * The implementation of the person local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>mgkportlet.service.PersonLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author 021mgk
 * @see PersonLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=mgkportlet.model.Person",
        service = AopService.class
)
public class PersonLocalServiceImpl extends PersonLocalServiceBaseImpl {

    /**
     * NOTE FOR DEVELOPERS:
     * <p>
     * Never reference this class directly. Use <code>mgkportlet.service.PersonLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>mgkportlet.service.PersonLocalServiceUtil</code>.
     */


    @Indexable(type = IndexableType.REINDEX)
    public Person addPerson(
            long pId, String name, String family, String email, String address,
            String phoneNumber, String nationalCode, String description,
            String image, InputStream inputStream, String contentType, Long size, ServiceContext serviceContext) {

        if (serviceContext == null) {
            serviceContext = ServiceContextThreadLocal.getServiceContext();
        }

        Person person = null;

        try {
            long groupId = serviceContext.getScopeGroupId();
            User user = userLocalService.getUserById(pId);
            Date now = new Date();

            long personId = counterLocalService.increment();

            person = personPersistence.create(personId);

            person.setUuid(serviceContext.getUuid());
            person.setUserId(pId);
            person.setGroupId(groupId);
            person.setCompanyId(user.getCompanyId());
            person.setUserName(user.getFullName());

            person.setCreateDate(serviceContext.getCreateDate(now));
            person.setModifiedDate(serviceContext.getModifiedDate(now));

            person.setName(name);
            person.setFamily(family);
            person.setEmail(email);
            person.setAddress(address);
            person.setPhoneNumber(phoneNumber);
            person.setNationalCode(nationalCode);
            person.setDescription(description);
            person.setRegisterDate(now);

            Folder folder = addFolder("person_gallery", "persons images", 0l, serviceContext);

            String ext = MimeTypesUtil.getExtensions(contentType).iterator().next();
            String fileName = name + "_" + family + ext;
            String uniqueFileName = PortletFileRepositoryUtil.getUniqueFileName(
                    serviceContext.getScopeGroupId(), folder.getFolderId(), fileName);

            FileEntry fileEntry = _dlAppService.addFileEntry(
                    serviceContext.getScopeGroupId(), folder.getFolderId(), uniqueFileName, contentType, uniqueFileName,
                    description, uniqueFileName, inputStream, size, serviceContext);


            person.setImage(fileEntry.getFileName());

            person.setExpandoBridgeAttributes(serviceContext);

            personPersistence.update(person);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    @Indexable(type = IndexableType.DELETE)
    public Person deletePerson(long personId, ServiceContext serviceContext)
            throws PortalException {

        //		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
        //				Person.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
        //				personId);

        return deletePerson(personId);
    }

    public List<Person> getPersons(long groupId) {
        return personPersistence.findByGroupId(groupId);
    }

    public List<Person> getPersons(long groupId, int start, int end) {
        return personPersistence.findByGroupId(groupId, start, end);
    }

    public List<Person> getPersons(
            long groupId, int start, int end, OrderByComparator<Person> obc) {

        return personPersistence.findByGroupId(groupId, start, end, obc);
    }

    public int getPersonsCount(long groupId) {
        return personPersistence.countByGroupId(groupId);
    }


    @Indexable(type = IndexableType.REINDEX)
    public Person updatePerson(
            long pId, long personId, String name, String family, String email,
            String address, String phoneNumber, String nationalCode,
            String description, String image, ServiceContext serviceContext)
            throws PortalException {

        Date now = new Date();

        if (serviceContext == null) {
            serviceContext = ServiceContextThreadLocal.getServiceContext();
        }

        Person person = getPerson(personId);

        User user = userLocalService.getUser(pId);

        person.setUserId(pId);
        person.setUserName(user.getFullName());
        person.setModifiedDate(serviceContext.getModifiedDate(now));

        person.setName(name);
        person.setFamily(family);
        person.setEmail(email);
        person.setAddress(address);
        person.setPhoneNumber(phoneNumber);
        person.setNationalCode(nationalCode);
        person.setDescription(description);
        person.setRegisterDate(now);
        person.setImage(image);
        person.setExpandoBridgeAttributes(serviceContext);

        personPersistence.update(person);

        //		resourceLocalService.updateResources(serviceContext.getCompanyId(),
        //				serviceContext.getScopeGroupId(),
        //				Person.class.getName(), personId,
        //				serviceContext.getModelPermissions());

        return person;
    }


    public Folder addFolder(String name, String description, Long parentId, ServiceContext serviceContext) throws PortalException {
        Folder folder;
        try {
            folder = _dlAppService.getFolder(serviceContext.getScopeGroupId(), parentId, name);
        } catch (NoSuchFolderException e) {
            folder = _dlAppService.addFolder(serviceContext.getScopeGroupId(), parentId, name, description, serviceContext);
        }
        return folder;
    }


    @Reference
    private DLAppService _dlAppService;


}
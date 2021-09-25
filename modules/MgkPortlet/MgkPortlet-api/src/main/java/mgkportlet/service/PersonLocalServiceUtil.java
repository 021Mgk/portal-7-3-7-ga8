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
 * Provides the local service utility for Person. This utility wraps
 * <code>mgkportlet.service.impl.PersonLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author 021mgk
 * @see PersonLocalService
 * @generated
 */
public class PersonLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>mgkportlet.service.impl.PersonLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.repository.model.Folder addFolder(
			String name, String description, Long parentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFolder(
			name, description, parentId, serviceContext);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>mgkportlet.service.PersonLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>mgkportlet.service.PersonLocalServiceUtil</code>.
	 */
	public static mgkportlet.model.Person addPerson(
		long pId, String name, String family, String email, String address,
		String phoneNumber, String nationalCode, String description,
		String image, java.io.InputStream inputStream, String contentType,
		Long size,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().addPerson(
			pId, name, family, email, address, phoneNumber, nationalCode,
			description, image, inputStream, contentType, size, serviceContext);
	}

	/**
	 * Adds the person to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param person the person
	 * @return the person that was added
	 */
	public static mgkportlet.model.Person addPerson(
		mgkportlet.model.Person person) {

		return getService().addPerson(person);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new person with the primary key. Does not add the person to the database.
	 *
	 * @param personId the primary key for the new person
	 * @return the new person
	 */
	public static mgkportlet.model.Person createPerson(long personId) {
		return getService().createPerson(personId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the person with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param personId the primary key of the person
	 * @return the person that was removed
	 * @throws PortalException if a person with the primary key could not be found
	 */
	public static mgkportlet.model.Person deletePerson(long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePerson(personId);
	}

	public static mgkportlet.model.Person deletePerson(
			long personId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePerson(personId, serviceContext);
	}

	/**
	 * Deletes the person from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param person the person
	 * @return the person that was removed
	 */
	public static mgkportlet.model.Person deletePerson(
		mgkportlet.model.Person person) {

		return getService().deletePerson(person);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>mgkportlet.model.impl.PersonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>mgkportlet.model.impl.PersonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static mgkportlet.model.Person fetchPerson(long personId) {
		return getService().fetchPerson(personId);
	}

	/**
	 * Returns the person matching the UUID and group.
	 *
	 * @param uuid the person's UUID
	 * @param groupId the primary key of the group
	 * @return the matching person, or <code>null</code> if a matching person could not be found
	 */
	public static mgkportlet.model.Person fetchPersonByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPersonByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the person with the primary key.
	 *
	 * @param personId the primary key of the person
	 * @return the person
	 * @throws PortalException if a person with the primary key could not be found
	 */
	public static mgkportlet.model.Person getPerson(long personId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPerson(personId);
	}

	/**
	 * Returns the person matching the UUID and group.
	 *
	 * @param uuid the person's UUID
	 * @param groupId the primary key of the group
	 * @return the matching person
	 * @throws PortalException if a matching person could not be found
	 */
	public static mgkportlet.model.Person getPersonByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersonByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>mgkportlet.model.impl.PersonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of persons
	 */
	public static java.util.List<mgkportlet.model.Person> getPersons(
		int start, int end) {

		return getService().getPersons(start, end);
	}

	public static java.util.List<mgkportlet.model.Person> getPersons(
		long groupId) {

		return getService().getPersons(groupId);
	}

	public static java.util.List<mgkportlet.model.Person> getPersons(
		long groupId, int start, int end) {

		return getService().getPersons(groupId, start, end);
	}

	public static java.util.List<mgkportlet.model.Person> getPersons(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<mgkportlet.model.Person> obc) {

		return getService().getPersons(groupId, start, end, obc);
	}

	/**
	 * Returns all the persons matching the UUID and company.
	 *
	 * @param uuid the UUID of the persons
	 * @param companyId the primary key of the company
	 * @return the matching persons, or an empty list if no matches were found
	 */
	public static java.util.List<mgkportlet.model.Person>
		getPersonsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getPersonsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of persons matching the UUID and company.
	 *
	 * @param uuid the UUID of the persons
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching persons, or an empty list if no matches were found
	 */
	public static java.util.List<mgkportlet.model.Person>
		getPersonsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<mgkportlet.model.Person> orderByComparator) {

		return getService().getPersonsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persons.
	 *
	 * @return the number of persons
	 */
	public static int getPersonsCount() {
		return getService().getPersonsCount();
	}

	public static int getPersonsCount(long groupId) {
		return getService().getPersonsCount(groupId);
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

	/**
	 * Updates the person in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param person the person
	 * @return the person that was updated
	 */
	public static mgkportlet.model.Person updatePerson(
		mgkportlet.model.Person person) {

		return getService().updatePerson(person);
	}

	public static PersonLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonLocalService, PersonLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersonLocalService.class);

		ServiceTracker<PersonLocalService, PersonLocalService> serviceTracker =
			new ServiceTracker<PersonLocalService, PersonLocalService>(
				bundle.getBundleContext(), PersonLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
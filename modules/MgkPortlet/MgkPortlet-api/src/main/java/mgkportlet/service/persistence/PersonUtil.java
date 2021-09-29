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

package mgkportlet.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import mgkportlet.model.Person;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the person service. This utility wraps <code>mgkportlet.service.persistence.impl.PersonPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author 021mgk
 * @see PersonPersistence
 * @generated
 */
public class PersonUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Person person) {
		getPersistence().clearCache(person);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Person> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Person> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Person> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Person> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Person update(Person person) {
		return getPersistence().update(person);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Person update(Person person, ServiceContext serviceContext) {
		return getPersistence().update(person, serviceContext);
	}

	/**
	 * Returns all the persons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persons
	 */
	public static List<Person> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of matching persons
	 */
	public static List<Person> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Person> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first person in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByUuid_First(
			String uuid, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first person in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUuid_First(
		String uuid, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByUuid_Last(
			String uuid, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUuid_Last(
		String uuid, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persons before and after the current person in the ordered set where uuid = &#63;.
	 *
	 * @param personId the primary key of the current person
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person[] findByUuid_PrevAndNext(
			long personId, String uuid,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_PrevAndNext(
			personId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persons where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persons
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the person where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPersonException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByUUID_G(String uuid, long groupId)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the person where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the person where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the person where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the person that was removed
	 */
	public static Person removeByUUID_G(String uuid, long groupId)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of persons where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching persons
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the persons where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persons
	 */
	public static List<Person> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persons where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of matching persons
	 */
	public static List<Person> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persons where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persons where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Person> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first person in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first person in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the persons before and after the current person in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param personId the primary key of the current person
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person[] findByUuid_C_PrevAndNext(
			long personId, String uuid, long companyId,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByUuid_C_PrevAndNext(
			personId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persons where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persons where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persons
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the persons where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @return the matching persons
	 */
	public static List<Person> findByNationalCode(String nationalCode) {
		return getPersistence().findByNationalCode(nationalCode);
	}

	/**
	 * Returns a range of all the persons where nationalCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalCode the national code
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of matching persons
	 */
	public static List<Person> findByNationalCode(
		String nationalCode, int start, int end) {

		return getPersistence().findByNationalCode(nationalCode, start, end);
	}

	/**
	 * Returns an ordered range of all the persons where nationalCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalCode the national code
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByNationalCode(
		String nationalCode, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().findByNationalCode(
			nationalCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persons where nationalCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param nationalCode the national code
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByNationalCode(
		String nationalCode, int start, int end,
		OrderByComparator<Person> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNationalCode(
			nationalCode, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first person in the ordered set where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByNationalCode_First(
			String nationalCode, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByNationalCode_First(
			nationalCode, orderByComparator);
	}

	/**
	 * Returns the first person in the ordered set where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByNationalCode_First(
		String nationalCode, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByNationalCode_First(
			nationalCode, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByNationalCode_Last(
			String nationalCode, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByNationalCode_Last(
			nationalCode, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByNationalCode_Last(
		String nationalCode, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByNationalCode_Last(
			nationalCode, orderByComparator);
	}

	/**
	 * Returns the persons before and after the current person in the ordered set where nationalCode = &#63;.
	 *
	 * @param personId the primary key of the current person
	 * @param nationalCode the national code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person[] findByNationalCode_PrevAndNext(
			long personId, String nationalCode,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByNationalCode_PrevAndNext(
			personId, nationalCode, orderByComparator);
	}

	/**
	 * Removes all the persons where nationalCode = &#63; from the database.
	 *
	 * @param nationalCode the national code
	 */
	public static void removeByNationalCode(String nationalCode) {
		getPersistence().removeByNationalCode(nationalCode);
	}

	/**
	 * Returns the number of persons where nationalCode = &#63;.
	 *
	 * @param nationalCode the national code
	 * @return the number of matching persons
	 */
	public static int countByNationalCode(String nationalCode) {
		return getPersistence().countByNationalCode(nationalCode);
	}

	/**
	 * Returns all the persons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching persons
	 */
	public static List<Person> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the persons where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of matching persons
	 */
	public static List<Person> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the persons where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persons where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persons
	 */
	public static List<Person> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Person> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first person in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByGroupId_First(
			long groupId, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first person in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByGroupId_First(
		long groupId, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person
	 * @throws NoSuchPersonException if a matching person could not be found
	 */
	public static Person findByGroupId_Last(
			long groupId, OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last person in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching person, or <code>null</code> if a matching person could not be found
	 */
	public static Person fetchByGroupId_Last(
		long groupId, OrderByComparator<Person> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the persons before and after the current person in the ordered set where groupId = &#63;.
	 *
	 * @param personId the primary key of the current person
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person[] findByGroupId_PrevAndNext(
			long personId, long groupId,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByGroupId_PrevAndNext(
			personId, groupId, orderByComparator);
	}

	/**
	 * Returns all the persons that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching persons that the user has permission to view
	 */
	public static List<Person> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the persons that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of matching persons that the user has permission to view
	 */
	public static List<Person> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the persons that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persons that the user has permission to view
	 */
	public static List<Person> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Person> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the persons before and after the current person in the ordered set of persons that the user has permission to view where groupId = &#63;.
	 *
	 * @param personId the primary key of the current person
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person[] filterFindByGroupId_PrevAndNext(
			long personId, long groupId,
			OrderByComparator<Person> orderByComparator)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			personId, groupId, orderByComparator);
	}

	/**
	 * Removes all the persons where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of persons where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching persons
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of persons that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching persons that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Caches the person in the entity cache if it is enabled.
	 *
	 * @param person the person
	 */
	public static void cacheResult(Person person) {
		getPersistence().cacheResult(person);
	}

	/**
	 * Caches the persons in the entity cache if it is enabled.
	 *
	 * @param persons the persons
	 */
	public static void cacheResult(List<Person> persons) {
		getPersistence().cacheResult(persons);
	}

	/**
	 * Creates a new person with the primary key. Does not add the person to the database.
	 *
	 * @param personId the primary key for the new person
	 * @return the new person
	 */
	public static Person create(long personId) {
		return getPersistence().create(personId);
	}

	/**
	 * Removes the person with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personId the primary key of the person
	 * @return the person that was removed
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person remove(long personId)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().remove(personId);
	}

	public static Person updateImpl(Person person) {
		return getPersistence().updateImpl(person);
	}

	/**
	 * Returns the person with the primary key or throws a <code>NoSuchPersonException</code> if it could not be found.
	 *
	 * @param personId the primary key of the person
	 * @return the person
	 * @throws NoSuchPersonException if a person with the primary key could not be found
	 */
	public static Person findByPrimaryKey(long personId)
		throws mgkportlet.exception.NoSuchPersonException {

		return getPersistence().findByPrimaryKey(personId);
	}

	/**
	 * Returns the person with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param personId the primary key of the person
	 * @return the person, or <code>null</code> if a person with the primary key could not be found
	 */
	public static Person fetchByPrimaryKey(long personId) {
		return getPersistence().fetchByPrimaryKey(personId);
	}

	/**
	 * Returns all the persons.
	 *
	 * @return the persons
	 */
	public static List<Person> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @return the range of persons
	 */
	public static List<Person> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persons
	 */
	public static List<Person> findAll(
		int start, int end, OrderByComparator<Person> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persons
	 * @param end the upper bound of the range of persons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persons
	 */
	public static List<Person> findAll(
		int start, int end, OrderByComparator<Person> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persons from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persons.
	 *
	 * @return the number of persons
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersonPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersonPersistence, PersonPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersonPersistence.class);

		ServiceTracker<PersonPersistence, PersonPersistence> serviceTracker =
			new ServiceTracker<PersonPersistence, PersonPersistence>(
				bundle.getBundleContext(), PersonPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}
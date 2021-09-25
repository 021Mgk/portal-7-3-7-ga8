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

package mgkportlet.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Person}.
 * </p>
 *
 * @author 021mgk
 * @see Person
 * @generated
 */
public class PersonWrapper
	extends BaseModelWrapper<Person> implements ModelWrapper<Person>, Person {

	public PersonWrapper(Person person) {
		super(person);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("personId", getPersonId());
		attributes.put("name", getName());
		attributes.put("family", getFamily());
		attributes.put("nationalCode", getNationalCode());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("image", getImage());
		attributes.put("description", getDescription());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("registerDate", getRegisterDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String family = (String)attributes.get("family");

		if (family != null) {
			setFamily(family);
		}

		String nationalCode = (String)attributes.get("nationalCode");

		if (nationalCode != null) {
			setNationalCode(nationalCode);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		Date registerDate = (Date)attributes.get("registerDate");

		if (registerDate != null) {
			setRegisterDate(registerDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the address of this person.
	 *
	 * @return the address of this person
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this person.
	 *
	 * @return the company ID of this person
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this person.
	 *
	 * @return the create date of this person
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this person.
	 *
	 * @return the description of this person
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the email of this person.
	 *
	 * @return the email of this person
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the family of this person.
	 *
	 * @return the family of this person
	 */
	@Override
	public String getFamily() {
		return model.getFamily();
	}

	/**
	 * Returns the group ID of this person.
	 *
	 * @return the group ID of this person
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image of this person.
	 *
	 * @return the image of this person
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the modified date of this person.
	 *
	 * @return the modified date of this person
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this person.
	 *
	 * @return the mvcc version of this person
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the name of this person.
	 *
	 * @return the name of this person
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the national code of this person.
	 *
	 * @return the national code of this person
	 */
	@Override
	public String getNationalCode() {
		return model.getNationalCode();
	}

	/**
	 * Returns the person ID of this person.
	 *
	 * @return the person ID of this person
	 */
	@Override
	public long getPersonId() {
		return model.getPersonId();
	}

	/**
	 * Returns the phone number of this person.
	 *
	 * @return the phone number of this person
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this person.
	 *
	 * @return the primary key of this person
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the register date of this person.
	 *
	 * @return the register date of this person
	 */
	@Override
	public Date getRegisterDate() {
		return model.getRegisterDate();
	}

	/**
	 * Returns the user ID of this person.
	 *
	 * @return the user ID of this person
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this person.
	 *
	 * @return the user name of this person
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this person.
	 *
	 * @return the user uuid of this person
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this person.
	 *
	 * @return the uuid of this person
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this person.
	 *
	 * @param address the address of this person
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this person.
	 *
	 * @param companyId the company ID of this person
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this person.
	 *
	 * @param createDate the create date of this person
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this person.
	 *
	 * @param description the description of this person
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the email of this person.
	 *
	 * @param email the email of this person
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the family of this person.
	 *
	 * @param family the family of this person
	 */
	@Override
	public void setFamily(String family) {
		model.setFamily(family);
	}

	/**
	 * Sets the group ID of this person.
	 *
	 * @param groupId the group ID of this person
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image of this person.
	 *
	 * @param image the image of this person
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the modified date of this person.
	 *
	 * @param modifiedDate the modified date of this person
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this person.
	 *
	 * @param mvccVersion the mvcc version of this person
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the name of this person.
	 *
	 * @param name the name of this person
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the national code of this person.
	 *
	 * @param nationalCode the national code of this person
	 */
	@Override
	public void setNationalCode(String nationalCode) {
		model.setNationalCode(nationalCode);
	}

	/**
	 * Sets the person ID of this person.
	 *
	 * @param personId the person ID of this person
	 */
	@Override
	public void setPersonId(long personId) {
		model.setPersonId(personId);
	}

	/**
	 * Sets the phone number of this person.
	 *
	 * @param phoneNumber the phone number of this person
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this person.
	 *
	 * @param primaryKey the primary key of this person
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the register date of this person.
	 *
	 * @param registerDate the register date of this person
	 */
	@Override
	public void setRegisterDate(Date registerDate) {
		model.setRegisterDate(registerDate);
	}

	/**
	 * Sets the user ID of this person.
	 *
	 * @param userId the user ID of this person
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this person.
	 *
	 * @param userName the user name of this person
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this person.
	 *
	 * @param userUuid the user uuid of this person
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this person.
	 *
	 * @param uuid the uuid of this person
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersonWrapper wrap(Person person) {
		return new PersonWrapper(person);
	}

}
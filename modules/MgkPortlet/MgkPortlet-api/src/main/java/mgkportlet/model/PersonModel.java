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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Person service. Represents a row in the &quot;mgk_Person&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>mgkportlet.model.impl.PersonModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>mgkportlet.model.impl.PersonImpl</code>.
 * </p>
 *
 * @author 021mgk
 * @see Person
 * @generated
 */
@ProviderType
public interface PersonModel
	extends BaseModel<Person>, GroupedModel, MVCCModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a person model instance should use the {@link Person} interface instead.
	 */

	/**
	 * Returns the primary key of this person.
	 *
	 * @return the primary key of this person
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this person.
	 *
	 * @param primaryKey the primary key of this person
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this person.
	 *
	 * @return the mvcc version of this person
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this person.
	 *
	 * @param mvccVersion the mvcc version of this person
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this person.
	 *
	 * @return the uuid of this person
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this person.
	 *
	 * @param uuid the uuid of this person
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the person ID of this person.
	 *
	 * @return the person ID of this person
	 */
	public long getPersonId();

	/**
	 * Sets the person ID of this person.
	 *
	 * @param personId the person ID of this person
	 */
	public void setPersonId(long personId);

	/**
	 * Returns the name of this person.
	 *
	 * @return the name of this person
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this person.
	 *
	 * @param name the name of this person
	 */
	public void setName(String name);

	/**
	 * Returns the family of this person.
	 *
	 * @return the family of this person
	 */
	@AutoEscape
	public String getFamily();

	/**
	 * Sets the family of this person.
	 *
	 * @param family the family of this person
	 */
	public void setFamily(String family);

	/**
	 * Returns the national code of this person.
	 *
	 * @return the national code of this person
	 */
	@AutoEscape
	public String getNationalCode();

	/**
	 * Sets the national code of this person.
	 *
	 * @param nationalCode the national code of this person
	 */
	public void setNationalCode(String nationalCode);

	/**
	 * Returns the email of this person.
	 *
	 * @return the email of this person
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this person.
	 *
	 * @param email the email of this person
	 */
	public void setEmail(String email);

	/**
	 * Returns the address of this person.
	 *
	 * @return the address of this person
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this person.
	 *
	 * @param address the address of this person
	 */
	public void setAddress(String address);

	/**
	 * Returns the image of this person.
	 *
	 * @return the image of this person
	 */
	@AutoEscape
	public String getImage();

	/**
	 * Sets the image of this person.
	 *
	 * @param image the image of this person
	 */
	public void setImage(String image);

	/**
	 * Returns the description of this person.
	 *
	 * @return the description of this person
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this person.
	 *
	 * @param description the description of this person
	 */
	public void setDescription(String description);

	/**
	 * Returns the phone number of this person.
	 *
	 * @return the phone number of this person
	 */
	@AutoEscape
	public String getPhoneNumber();

	/**
	 * Sets the phone number of this person.
	 *
	 * @param phoneNumber the phone number of this person
	 */
	public void setPhoneNumber(String phoneNumber);

	/**
	 * Returns the register date of this person.
	 *
	 * @return the register date of this person
	 */
	public Date getRegisterDate();

	/**
	 * Sets the register date of this person.
	 *
	 * @param registerDate the register date of this person
	 */
	public void setRegisterDate(Date registerDate);

	/**
	 * Returns the group ID of this person.
	 *
	 * @return the group ID of this person
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this person.
	 *
	 * @param groupId the group ID of this person
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this person.
	 *
	 * @return the company ID of this person
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this person.
	 *
	 * @param companyId the company ID of this person
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this person.
	 *
	 * @return the user ID of this person
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this person.
	 *
	 * @param userId the user ID of this person
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this person.
	 *
	 * @return the user uuid of this person
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this person.
	 *
	 * @param userUuid the user uuid of this person
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this person.
	 *
	 * @return the user name of this person
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this person.
	 *
	 * @param userName the user name of this person
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this person.
	 *
	 * @return the create date of this person
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this person.
	 *
	 * @param createDate the create date of this person
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this person.
	 *
	 * @return the modified date of this person
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this person.
	 *
	 * @param modifiedDate the modified date of this person
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

}
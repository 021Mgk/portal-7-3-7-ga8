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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link mgkportlet.service.http.PersonServiceSoap}.
 *
 * @author 021mgk
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PersonSoap implements Serializable {

	public static PersonSoap toSoapModel(Person model) {
		PersonSoap soapModel = new PersonSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setUuid(model.getUuid());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setName(model.getName());
		soapModel.setFamily(model.getFamily());
		soapModel.setNationalCode(model.getNationalCode());
		soapModel.setEmail(model.getEmail());
		soapModel.setAddress(model.getAddress());
		soapModel.setImage(model.getImage());
		soapModel.setDescription(model.getDescription());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setRegisterDate(model.getRegisterDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PersonSoap[] toSoapModels(Person[] models) {
		PersonSoap[] soapModels = new PersonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[][] toSoapModels(Person[][] models) {
		PersonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[] toSoapModels(List<Person> models) {
		List<PersonSoap> soapModels = new ArrayList<PersonSoap>(models.size());

		for (Person model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonSoap[soapModels.size()]);
	}

	public PersonSoap() {
	}

	public long getPrimaryKey() {
		return _personId;
	}

	public void setPrimaryKey(long pk) {
		setPersonId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getFamily() {
		return _family;
	}

	public void setFamily(String family) {
		_family = family;
	}

	public String getNationalCode() {
		return _nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		_nationalCode = nationalCode;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public Date getRegisterDate() {
		return _registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		_registerDate = registerDate;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _mvccVersion;
	private String _uuid;
	private long _personId;
	private String _name;
	private String _family;
	private String _nationalCode;
	private String _email;
	private String _address;
	private String _image;
	private String _description;
	private String _phoneNumber;
	private Date _registerDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}
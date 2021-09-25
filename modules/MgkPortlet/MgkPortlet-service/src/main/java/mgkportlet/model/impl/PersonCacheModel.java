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

package mgkportlet.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import mgkportlet.model.Person;

/**
 * The cache model class for representing Person in entity cache.
 *
 * @author 021mgk
 * @generated
 */
public class PersonCacheModel
	implements CacheModel<Person>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersonCacheModel)) {
			return false;
		}

		PersonCacheModel personCacheModel = (PersonCacheModel)object;

		if ((personId == personCacheModel.personId) &&
			(mvccVersion == personCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, personId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", family=");
		sb.append(family);
		sb.append(", nationalCode=");
		sb.append(nationalCode);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", image=");
		sb.append(image);
		sb.append(", description=");
		sb.append(description);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", registerDate=");
		sb.append(registerDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Person toEntityModel() {
		PersonImpl personImpl = new PersonImpl();

		personImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			personImpl.setUuid("");
		}
		else {
			personImpl.setUuid(uuid);
		}

		personImpl.setPersonId(personId);

		if (name == null) {
			personImpl.setName("");
		}
		else {
			personImpl.setName(name);
		}

		if (family == null) {
			personImpl.setFamily("");
		}
		else {
			personImpl.setFamily(family);
		}

		if (nationalCode == null) {
			personImpl.setNationalCode("");
		}
		else {
			personImpl.setNationalCode(nationalCode);
		}

		if (email == null) {
			personImpl.setEmail("");
		}
		else {
			personImpl.setEmail(email);
		}

		if (address == null) {
			personImpl.setAddress("");
		}
		else {
			personImpl.setAddress(address);
		}

		if (image == null) {
			personImpl.setImage("");
		}
		else {
			personImpl.setImage(image);
		}

		if (description == null) {
			personImpl.setDescription("");
		}
		else {
			personImpl.setDescription(description);
		}

		if (phoneNumber == null) {
			personImpl.setPhoneNumber("");
		}
		else {
			personImpl.setPhoneNumber(phoneNumber);
		}

		if (registerDate == Long.MIN_VALUE) {
			personImpl.setRegisterDate(null);
		}
		else {
			personImpl.setRegisterDate(new Date(registerDate));
		}

		personImpl.setGroupId(groupId);
		personImpl.setCompanyId(companyId);
		personImpl.setUserId(userId);

		if (userName == null) {
			personImpl.setUserName("");
		}
		else {
			personImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personImpl.setCreateDate(null);
		}
		else {
			personImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personImpl.setModifiedDate(null);
		}
		else {
			personImpl.setModifiedDate(new Date(modifiedDate));
		}

		personImpl.resetOriginalValues();

		return personImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		personId = objectInput.readLong();
		name = objectInput.readUTF();
		family = objectInput.readUTF();
		nationalCode = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		image = objectInput.readUTF();
		description = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		registerDate = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(personId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (family == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(family);
		}

		if (nationalCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nationalCode);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeLong(registerDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long mvccVersion;
	public String uuid;
	public long personId;
	public String name;
	public String family;
	public String nationalCode;
	public String email;
	public String address;
	public String image;
	public String description;
	public String phoneNumber;
	public long registerDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}
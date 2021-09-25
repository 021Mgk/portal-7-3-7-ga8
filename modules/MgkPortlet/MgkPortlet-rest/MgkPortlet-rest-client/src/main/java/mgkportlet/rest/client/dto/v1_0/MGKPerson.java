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

package mgkportlet.rest.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import mgkportlet.rest.client.function.UnsafeSupplier;
import mgkportlet.rest.client.serdes.v1_0.MGKPersonSerDes;

/**
 * @author USER
 * @generated
 */
@Generated("")
public class MGKPerson implements Cloneable, Serializable {

	public static MGKPerson toDTO(String json) {
		return MGKPersonSerDes.toDTO(json);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String firstName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(
		UnsafeSupplier<String, Exception> lastNameUnsafeSupplier) {

		try {
			lastName = lastNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastName;

	@Override
	public MGKPerson clone() throws CloneNotSupportedException {
		return (MGKPerson)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MGKPerson)) {
			return false;
		}

		MGKPerson mgkPerson = (MGKPerson)object;

		return Objects.equals(toString(), mgkPerson.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MGKPersonSerDes.toJSON(this);
	}

}
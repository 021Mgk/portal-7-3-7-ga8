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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Person service. Represents a row in the &quot;mgk_Person&quot; database table, with each column mapped to a property of this class.
 *
 * @author 021mgk
 * @see PersonModel
 * @generated
 */
@ImplementationClassName("mgkportlet.model.impl.PersonImpl")
@ProviderType
public interface Person extends PersistedModel, PersonModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>mgkportlet.model.impl.PersonImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Person, Long> PERSON_ID_ACCESSOR =
		new Accessor<Person, Long>() {

			@Override
			public Long get(Person person) {
				return person.getPersonId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Person> getTypeClass() {
				return Person.class;
			}

		};

}
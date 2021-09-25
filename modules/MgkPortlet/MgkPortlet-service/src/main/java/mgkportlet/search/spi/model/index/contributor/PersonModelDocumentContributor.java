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

package mgkportlet.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import mgkportlet.model.Person;

import org.osgi.service.component.annotations.Component;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true, property = "indexer.class.name=mgkportlet.model.Person",
	service = ModelDocumentContributor.class
)
public class PersonModelDocumentContributor
	implements ModelDocumentContributor<Person> {

	@Override
	public void contribute(Document document, Person person) {
		//		if (contact.isUser()) {
		//			User user = userLocalService.fetchUserByContactId(
		//				contact.getContactId());
		//
		//			if ((user == null) || user.isDefaultUser() ||
		//				(user.getStatus() != WorkflowConstants.STATUS_APPROVED)) {
		//
		//				return;
		//			}
		//		}

		String fullName = person.getName() + " " + person.getFamily();
		document.addKeyword(Field.COMPANY_ID, person.getCompanyId());
		document.addDate(Field.MODIFIED_DATE, person.getModifiedDate());
		document.addKeyword(Field.USER_ID, person.getUserId());
		document.addKeyword(Field.USER_NAME, fullName);

		document.addText("email", person.getEmail());
		document.addText("name", person.getName());
		document.addText("family", person.getFamily());
		document.addText("address", person.getAddress());
		document.addText("description", person.getDescription());
	}

	//	@Reference
	//	protected UserLocalService userLocalService;

}
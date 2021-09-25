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

import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import java.util.function.Consumer;

import mgkportlet.model.Person;

import mgkportlet.service.PersonLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lucas Marques de Paula
 */
@Component(
	immediate = true, property = "indexer.class.name=mgkportlet.model.Person",
	service = ModelIndexerWriterContributor.class
)
public class PersonModelIndexerWriterContributor
	implements ModelIndexerWriterContributor<Person> {

	@Override
	public void customize(
		final BatchIndexingActionable batchIndexingActionable,
		final ModelIndexerWriterDocumentHelper
			modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod(
			new Consumer<Person>() {

				@Override
				public void accept(Person person) {
					batchIndexingActionable.addDocuments(
						modelIndexerWriterDocumentHelper.getDocument(person));
				}

			});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.
			getBatchIndexingActionable(
				contactLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Person person) {
		return person.getCompanyId();
	}

	@Reference
	protected PersonLocalService contactLocalService;

	@Reference
	protected DynamicQueryBatchIndexingActionableFactory
		dynamicQueryBatchIndexingActionableFactory;

}
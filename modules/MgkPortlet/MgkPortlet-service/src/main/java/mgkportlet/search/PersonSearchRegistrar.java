/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package mgkportlet.search;

import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchDefinition;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.registrar.contributor.ModelSearchDefinitionContributor;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import mgkportlet.model.Person;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Lucas Marques de Paula
 */
@Component(immediate = true, service = {})
public class PersonSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			Person.class, bundleContext,
			new ModelSearchDefinitionContributor() {

				@Override
				public void contribute(
					ModelSearchDefinition modelSearchDefinition) {

					modelSearchDefinition.setModelIndexWriteContributor(
						modelIndexWriterContributor);
					modelSearchDefinition.setModelSummaryContributor(
						modelSummaryContributor);
				}

			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=mgkportlet.model.Person)")
	protected ModelIndexerWriterContributor<Person> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=mgkportlet.model.Person)")
	protected ModelSummaryContributor modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;

}
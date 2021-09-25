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

package mgkportlet.web.internal.clay;

import com.liferay.frontend.taglib.clay.servlet.taglib.soy.BaseVerticalCard;
import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import mgkportlet.model.Person;
import mgkportlet.web.constants.MgkPortletWebPortletKeys;


import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ResourceBundle;

/**
 * @author Adolfo Pérez
 */
public class PersonEntryVerticalCard extends BaseVerticalCard {

	public PersonEntryVerticalCard(
			Person person, RenderRequest renderRequest,
			RenderResponse renderResponse, RowChecker rowChecker,
			String personsURL,
			PermissionChecker permissionChecker, ResourceBundle resourceBundle) {

		super(person, renderRequest, rowChecker);

		_person = person;
		_renderResponse = renderResponse;
		_personsEntryURL = personsURL;
		_permissionChecker = permissionChecker;
		_resourceBundle = resourceBundle;
	}

//	@Override
//	public List<DropdownItem> getActionDropdownItems() {
//		try {
//			BlogsEntryActionDropdownItemsProvider
//				blogsEntryActionDropdownItemsProvider =
//					new BlogsEntryActionDropdownItemsProvider(
//						_blogsEntry, renderRequest, _renderResponse,
//						_permissionChecker, _resourceBundle, _trashHelper);
//
//			return blogsEntryActionDropdownItemsProvider.
//				getActionDropdownItems();
//		}
//		catch (PortalException portalException) {
//			return ReflectionUtil.throwException(portalException);
//		}
//	}

	@Override
	public String getAspectRatioCssClasses() {
		return "aspect-ratio-item-center-middle " +
			"aspect-ratio-item-vertical-fluid";
	}

	@Override
	public String getDefaultEventHandler() {
		return MgkPortletWebPortletKeys.PERSONS_ELEMENTS_DEFAULT_EVENT_HANDLER;
	}

	@Override
	public String getHref() {
//		try {
//			if (!BlogsEntryPermission.contains(
//					_permissionChecker, _blogsEntry, ActionKeys.UPDATE)) {
//
//				return null;
//			}

			return _personsEntryURL;
//		}
//		catch (PortalException portalException) {
//			return ReflectionUtil.throwException(portalException);
//		}
	}

	@Override
	public String getIcon() {
		return "blogs";
	}

	@Override
	public String getImageSrc() {
//		try {
//			String coverImageURL = _blogsEntry.getCoverImageURL(themeDisplay);
//
//			if (Validator.isNull(coverImageURL)) {
//				return _blogsEntry.getSmallImageURL(themeDisplay);
//			}
//
//			return coverImageURL;
//		}
//		catch (PortalException portalException) {
//			return ReflectionUtil.throwException(portalException);
//		}

//		TODO: replace with actual image url

		return "https://images.unsplash.com/photo-1578496480157-697fc14d2e55?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
	}

	@Override
	public String getSubtitle() {
		return _person.getEmail();
	}

	@Override
	public String getTitle() {

		return _person.getName() + _person.getFamily();
	}

	private final Person _person;
	private final String _personsEntryURL;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;
	private final ResourceBundle _resourceBundle;

}
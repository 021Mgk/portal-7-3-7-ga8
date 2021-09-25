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

package mgkportlet.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author 021mgk
 */
public class PersonPhoneNumberException extends PortalException {

	public PersonPhoneNumberException() {
	}

	public PersonPhoneNumberException(String msg) {
		super(msg);
	}

	public PersonPhoneNumberException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public PersonPhoneNumberException(Throwable cause) {
		super(cause);
	}

}
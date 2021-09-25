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

package mgkportlet.rest.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import mgkportlet.rest.client.dto.v1_0.MGKPerson;
import mgkportlet.rest.client.json.BaseJSONParser;

/**
 * @author USER
 * @generated
 */
@Generated("")
public class MGKPersonSerDes {

	public static MGKPerson toDTO(String json) {
		MGKPersonJSONParser mgkPersonJSONParser = new MGKPersonJSONParser();

		return mgkPersonJSONParser.parseToDTO(json);
	}

	public static MGKPerson[] toDTOs(String json) {
		MGKPersonJSONParser mgkPersonJSONParser = new MGKPersonJSONParser();

		return mgkPersonJSONParser.parseToDTOs(json);
	}

	public static String toJSON(MGKPerson mgkPerson) {
		if (mgkPerson == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (mgkPerson.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(mgkPerson.getEmail()));

			sb.append("\"");
		}

		if (mgkPerson.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(mgkPerson.getFirstName()));

			sb.append("\"");
		}

		if (mgkPerson.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(mgkPerson.getId());
		}

		if (mgkPerson.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(mgkPerson.getLastName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MGKPersonJSONParser mgkPersonJSONParser = new MGKPersonJSONParser();

		return mgkPersonJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(MGKPerson mgkPerson) {
		if (mgkPerson == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (mgkPerson.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(mgkPerson.getEmail()));
		}

		if (mgkPerson.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(mgkPerson.getFirstName()));
		}

		if (mgkPerson.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(mgkPerson.getId()));
		}

		if (mgkPerson.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(mgkPerson.getLastName()));
		}

		return map;
	}

	public static class MGKPersonJSONParser extends BaseJSONParser<MGKPerson> {

		@Override
		protected MGKPerson createDTO() {
			return new MGKPerson();
		}

		@Override
		protected MGKPerson[] createDTOArray(int size) {
			return new MGKPerson[size];
		}

		@Override
		protected void setField(
			MGKPerson mgkPerson, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					mgkPerson.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					mgkPerson.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					mgkPerson.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					mgkPerson.setLastName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}
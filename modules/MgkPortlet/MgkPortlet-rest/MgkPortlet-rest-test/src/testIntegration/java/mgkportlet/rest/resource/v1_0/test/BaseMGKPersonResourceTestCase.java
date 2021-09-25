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

package mgkportlet.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import mgkportlet.rest.client.dto.v1_0.MGKPerson;
import mgkportlet.rest.client.http.HttpInvoker;
import mgkportlet.rest.client.pagination.Page;
import mgkportlet.rest.client.pagination.Pagination;
import mgkportlet.rest.client.resource.v1_0.MGKPersonResource;
import mgkportlet.rest.client.serdes.v1_0.MGKPersonSerDes;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author USER
 * @generated
 */
@Generated("")
public abstract class BaseMGKPersonResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_mgkPersonResource.setContextCompany(testCompany);

		MGKPersonResource.Builder builder = MGKPersonResource.builder();

		mgkPersonResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MGKPerson mgkPerson1 = randomMGKPerson();

		String json = objectMapper.writeValueAsString(mgkPerson1);

		MGKPerson mgkPerson2 = MGKPersonSerDes.toDTO(json);

		Assert.assertTrue(equals(mgkPerson1, mgkPerson2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		MGKPerson mgkPerson = randomMGKPerson();

		String json1 = objectMapper.writeValueAsString(mgkPerson);
		String json2 = MGKPersonSerDes.toJSON(mgkPerson);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		MGKPerson mgkPerson = randomMGKPerson();

		mgkPerson.setEmail(regex);
		mgkPerson.setFirstName(regex);
		mgkPerson.setLastName(regex);

		String json = MGKPersonSerDes.toJSON(mgkPerson);

		Assert.assertFalse(json.contains(regex));

		mgkPerson = MGKPersonSerDes.toDTO(json);

		Assert.assertEquals(regex, mgkPerson.getEmail());
		Assert.assertEquals(regex, mgkPerson.getFirstName());
		Assert.assertEquals(regex, mgkPerson.getLastName());
	}

	@Test
	public void testDeletePerson() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		MGKPerson mgkPerson = testDeletePerson_addMGKPerson();

		assertHttpResponseStatusCode(
			204, mgkPersonResource.deletePersonHttpResponse(null, null));

		assertHttpResponseStatusCode(
			404, mgkPersonResource.getPersonHttpResponse(null, null));

		assertHttpResponseStatusCode(
			404, mgkPersonResource.getPersonHttpResponse(null, null));
	}

	protected MGKPerson testDeletePerson_addMGKPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetPersonsPage() throws Exception {
		Page<MGKPerson> page = mgkPersonResource.getPersonsPage(
			testGetPersonsPage_getSiteId(), Pagination.of(1, 2));

		Assert.assertEquals(0, page.getTotalCount());

		Long siteId = testGetPersonsPage_getSiteId();
		Long irrelevantSiteId = testGetPersonsPage_getIrrelevantSiteId();

		if (irrelevantSiteId != null) {
			MGKPerson irrelevantMGKPerson = testGetPersonsPage_addMGKPerson(
				irrelevantSiteId, randomIrrelevantMGKPerson());

			page = mgkPersonResource.getPersonsPage(
				irrelevantSiteId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantMGKPerson),
				(List<MGKPerson>)page.getItems());
			assertValid(page);
		}

		MGKPerson mgkPerson1 = testGetPersonsPage_addMGKPerson(
			siteId, randomMGKPerson());

		MGKPerson mgkPerson2 = testGetPersonsPage_addMGKPerson(
			siteId, randomMGKPerson());

		page = mgkPersonResource.getPersonsPage(siteId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(mgkPerson1, mgkPerson2),
			(List<MGKPerson>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetPersonsPageWithPagination() throws Exception {
		Long siteId = testGetPersonsPage_getSiteId();

		MGKPerson mgkPerson1 = testGetPersonsPage_addMGKPerson(
			siteId, randomMGKPerson());

		MGKPerson mgkPerson2 = testGetPersonsPage_addMGKPerson(
			siteId, randomMGKPerson());

		MGKPerson mgkPerson3 = testGetPersonsPage_addMGKPerson(
			siteId, randomMGKPerson());

		Page<MGKPerson> page1 = mgkPersonResource.getPersonsPage(
			siteId, Pagination.of(1, 2));

		List<MGKPerson> mgkPersons1 = (List<MGKPerson>)page1.getItems();

		Assert.assertEquals(mgkPersons1.toString(), 2, mgkPersons1.size());

		Page<MGKPerson> page2 = mgkPersonResource.getPersonsPage(
			siteId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<MGKPerson> mgkPersons2 = (List<MGKPerson>)page2.getItems();

		Assert.assertEquals(mgkPersons2.toString(), 1, mgkPersons2.size());

		Page<MGKPerson> page3 = mgkPersonResource.getPersonsPage(
			siteId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(mgkPerson1, mgkPerson2, mgkPerson3),
			(List<MGKPerson>)page3.getItems());
	}

	protected MGKPerson testGetPersonsPage_addMGKPerson(
			Long siteId, MGKPerson mgkPerson)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetPersonsPage_getSiteId() throws Exception {
		return testGroup.getGroupId();
	}

	protected Long testGetPersonsPage_getIrrelevantSiteId() throws Exception {
		return irrelevantGroup.getGroupId();
	}

	@Test
	public void testAddPerson() throws Exception {
		MGKPerson randomMGKPerson = randomMGKPerson();

		MGKPerson postMGKPerson = testAddPerson_addMGKPerson(randomMGKPerson);

		assertEquals(randomMGKPerson, postMGKPerson);
		assertValid(postMGKPerson);
	}

	protected MGKPerson testAddPerson_addMGKPerson(MGKPerson mgkPerson)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdatePerson() throws Exception {
		MGKPerson postMGKPerson = testUpdatePerson_addMGKPerson();

		MGKPerson randomMGKPerson = randomMGKPerson();

		MGKPerson putMGKPerson = mgkPersonResource.updatePerson(
			null, randomMGKPerson);

		assertEquals(randomMGKPerson, putMGKPerson);
		assertValid(putMGKPerson);

		MGKPerson getMGKPerson = mgkPersonResource.updatePerson();

		assertEquals(randomMGKPerson, getMGKPerson);
		assertValid(getMGKPerson);
	}

	protected MGKPerson testUpdatePerson_addMGKPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetPerson() throws Exception {
		MGKPerson postMGKPerson = testGetPerson_addMGKPerson();

		MGKPerson getMGKPerson = mgkPersonResource.getPerson(null, null);

		assertEquals(postMGKPerson, getMGKPerson);
		assertValid(getMGKPerson);
	}

	protected MGKPerson testGetPerson_addMGKPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPerson() throws Exception {
		MGKPerson mgkPerson = testGraphQLMGKPerson_addMGKPerson();

		Assert.assertTrue(
			equals(
				mgkPerson,
				MGKPersonSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"person",
								new HashMap<String, Object>() {
									{
										put(
											"siteKey",
											"\"" + mgkPerson.getSiteId() +
												"\"");
										put("personId", null);
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/person"))));
	}

	@Test
	public void testGraphQLGetPersonNotFound() throws Exception {
		Integer irrelevantPersonId = RandomTestUtil.randomInt();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"person",
						new HashMap<String, Object>() {
							{
								put(
									"siteKey",
									"\"" + irrelevantGroup.getGroupId() + "\"");
								put("personId", irrelevantPersonId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	protected MGKPerson testGraphQLMGKPerson_addMGKPerson() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(MGKPerson mgkPerson1, MGKPerson mgkPerson2) {
		Assert.assertTrue(
			mgkPerson1 + " does not equal " + mgkPerson2,
			equals(mgkPerson1, mgkPerson2));
	}

	protected void assertEquals(
		List<MGKPerson> mgkPersons1, List<MGKPerson> mgkPersons2) {

		Assert.assertEquals(mgkPersons1.size(), mgkPersons2.size());

		for (int i = 0; i < mgkPersons1.size(); i++) {
			MGKPerson mgkPerson1 = mgkPersons1.get(i);
			MGKPerson mgkPerson2 = mgkPersons2.get(i);

			assertEquals(mgkPerson1, mgkPerson2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<MGKPerson> mgkPersons1, List<MGKPerson> mgkPersons2) {

		Assert.assertEquals(mgkPersons1.size(), mgkPersons2.size());

		for (MGKPerson mgkPerson1 : mgkPersons1) {
			boolean contains = false;

			for (MGKPerson mgkPerson2 : mgkPersons2) {
				if (equals(mgkPerson1, mgkPerson2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				mgkPersons2 + " does not contain " + mgkPerson1, contains);
		}
	}

	protected void assertValid(MGKPerson mgkPerson) throws Exception {
		boolean valid = true;

		if (mgkPerson.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (mgkPerson.getEmail() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (mgkPerson.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (mgkPerson.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<MGKPerson> page) {
		boolean valid = false;

		java.util.Collection<MGKPerson> mgkPersons = page.getItems();

		int size = mgkPersons.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					mgkportlet.rest.dto.v1_0.MGKPerson.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(MGKPerson mgkPerson1, MGKPerson mgkPerson2) {
		if (mgkPerson1 == mgkPerson2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("email", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mgkPerson1.getEmail(), mgkPerson2.getEmail())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mgkPerson1.getFirstName(), mgkPerson2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mgkPerson1.getId(), mgkPerson2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						mgkPerson1.getLastName(), mgkPerson2.getLastName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_mgkPersonResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_mgkPersonResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, MGKPerson mgkPerson) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("email")) {
			sb.append("'");
			sb.append(String.valueOf(mgkPerson.getEmail()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(mgkPerson.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("lastName")) {
			sb.append("'");
			sb.append(String.valueOf(mgkPerson.getLastName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected MGKPerson randomMGKPerson() throws Exception {
		return new MGKPerson() {
			{
				email =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				firstName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				lastName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected MGKPerson randomIrrelevantMGKPerson() throws Exception {
		MGKPerson randomIrrelevantMGKPerson = randomMGKPerson();

		return randomIrrelevantMGKPerson;
	}

	protected MGKPerson randomPatchMGKPerson() throws Exception {
		return randomMGKPerson();
	}

	protected MGKPersonResource mgkPersonResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMGKPersonResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private mgkportlet.rest.resource.v1_0.MGKPersonResource _mgkPersonResource;

}
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList" %>
<%@ page import="mgkportlet.web.internal.clay.PersonEntryVerticalCard" %>
<%@include file="init.jsp" %>


<%


//    String keywords = ParamUtil.getString(request, "keywords");


//    PersonsManagementToolbarDisplayContext personsManagementToolbarDisplayContext =
//            new PersonsManagementToolbarDisplayContext(request, liferayPortletRequest,
//                    liferayPortletResponse, displayStyle);

    ViewTypeItemList viewTypeItems = new ViewTypeItemList(currentURLObj, displayStyle) {
        {
            addCardViewTypeItem();
            addListViewTypeItem();
            addTableViewTypeItem();
        }
    };


%>

<%--<h1><%=keywords %></h1>--%>

<%--<%--%>
<%--    SearchContext searchContext = SearchContextFactory.getInstance(request);--%>
<%--    searchContext.setKeywords(keywords);--%>
<%--    searchContext.setAttribute("paginationType", "more");--%>
<%--    searchContext.setStart(0);--%>
<%--    searchContext.setEnd(10);--%>
<%--    Indexer<Person> indexer = IndexerRegistryUtil.getIndexer(Person.class);--%>
<%--    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");--%>
<%--        Hits hits = indexer.search(searchContext);--%>
<%--        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> " +  hits.getDocs().length);--%>
<%--        List<Person> personList = new ArrayList<Person>();--%>
<%--        for (int i = 0; i < hits.getDocs().length; i++) {--%>
<%--            Document doc = hits.doc(i);--%>
<%--            System.out.println(doc.toString());--%>
<%--            long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));--%>
<%--            Person entry = null;--%>
<%--            try {--%>
<%--                entry = PersonLocalServiceUtil.getPerson(entryId);--%>
<%--                System.out.println(entry.getName());--%>
<%--            } catch (PortalException pe) {--%>
<%--                _log.error(pe.getLocalizedMessage());--%>
<%--            } catch (SystemException se) {--%>
<%--                _log.error(se.getLocalizedMessage());--%>
<%--            }--%>
<%--            personList.add(entry);--%>
<%--        }--%>

<%--//--%>
<%--//    List<Person> guestbooks = PersonLocalServiceUtil.getPersons(scopeGroupId);--%>
<%--//    Map<String, String> guestbookMap = new HashMap<String, String>();--%>
<%--//    for (Person person : entries) {--%>
<%--//        guestbookMap.put(Long.toString(person.getPersonId()), person.getName());--%>
<%--//    }--%>
<%--%>--%>







<%--<div style="background: red;">--%>

<%--    <liferay-ui:search-container delta="10"--%>
<%--                                 emptyResultsMessage="no-entries-were-found"--%>
<%--                                 total="<%= personList.size() %>">--%>

<%--        <liferay-ui:search-container-results results="<%= personList %>"/>--%>

<%--        <liferay-ui:search-container-row--%>
<%--                className="com.mgk.portlet.model.Person"--%>
<%--                keyProperty="personId" modelVar="person" escapedModel="<%=true%>">--%>


<%--            <liferay-ui:search-container-column-text property="name"/>--%>
<%--            <liferay-ui:search-container-column-text property="family"/>--%>
<%--            &lt;%&ndash;        <liferay-ui:search-container-column-status property="status" />&ndash;%&gt;--%>
<%--            <liferay-ui:search-container-column-jsp align="right" path="/person_actions.jsp" />--%>



<%--        </liferay-ui:search-container-row>--%>

<%--        <liferay-ui:search-iterator />--%>

<%--    </liferay-ui:search-container>--%>
<%--</div>--%>


<%--<hr />--%>
<%--<hr />--%>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcRenderCommandName" value="/person/search"/>
</portlet:renderURL>


<clay:management-toolbar
        viewTypeItems="<%=viewTypeItems%>"
        searchContainerId="personEntries"
        supportsBulkActions="<%= true %>"
        searchActionURL="<%= searchURL.toString() %>"
        searchInputName="keywords"
/>

<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="mvcRenderCommandName" value="/person/list"></portlet:param>
</liferay-portlet:renderURL>

<clay:container-fluid
        cssClass="main-content-body"
>

<liferay-ui:search-container
        id="personEntries"
        total="<%= PersonLocalServiceUtil.getPersonsCount(scopeGroupId.longValue())%>"
        delta="20" iteratorURL="<%= iteratorURL %>">

    <liferay-ui:search-container-results
            results="<%= PersonLocalServiceUtil.getPersons(scopeGroupId,
			searchContainer.getStart(), searchContainer.getEnd()) %>" />

    <liferay-ui:search-container-row className="mgkportlet.model.Person" modelVar="person">
        <c:choose>
            <c:when test="<%=displayStyle.equals("icon")%>">
                <%
                    row.setCssClass("entry-card lfr-asset-item");
                %>

                <liferay-portlet:renderURL varImpl="rowURL">
                    <portlet:param name="mvcRenderCommandName" value="/person/view" />
                    <portlet:param name="personId" value="<%= String.valueOf(person.getPersonId()) %>"/>
                </liferay-portlet:renderURL>

                <liferay-ui:search-container-column-text>
                    <clay:vertical-card
                            verticalCard="<%=
				new PersonEntryVerticalCard(person, renderRequest, renderResponse, null, rowURL.toString(),
				 permissionChecker, resourceBundle) %>"
                    />
                </liferay-ui:search-container-column-text>
            </c:when>

            <c:otherwise>
                <liferay-ui:search-container-column-text property="name"/>
                <liferay-ui:search-container-column-text property="family"/>
                <%--        <liferay-ui:search-container-column-status property="status" />--%>
                <liferay-ui:search-container-column-jsp align="right" path="/person_actions.jsp" />
            </c:otherwise>
        </c:choose>





    </liferay-ui:search-container-row >

    <liferay-ui:search-iterator
            displayStyle="<%= displayStyle %>"
            markupView="lexicon"

    />


</liferay-ui:search-container>

</clay:container-fluid>


<%--<div id="error">--%>
<%--    <c:if test="${!empty personList}">--%>

<%--        <table>--%>
<%--            <tr>--%>
<%--                <th>name</th>--%>
<%--                <th>family</th>--%>
<%--                <th>email</th>--%>
<%--            </tr>--%>
<%--            <c:forEach items="${personList}" var="person">--%>
<%--                <tr>--%>
<%--                    <td>${person.name}</td>--%>
<%--                    <td>${person.family}</td>--%>
<%--                    <td>${person.email}</td>--%>
<%--                </tr>--%>
<%--            </c:forEach>--%>
<%--        </table>--%>
<%--    </c:if>--%>

<%--</div>--%>
<%--                    <span>${person.name}</span>--%>
<%--                    <span></span>--%>
<%--                    <span>${person.phoneNumber}</span>--%>
<%--                    <span>${person.address}</span>--%>
<%--                    <span>${person.description}</span>--%>
<%--                    <span></span>--%>
<%--                    <span>${person.nationaCode}</span>--%>
<%--                    <c:out value="${person}"></c:out>--%>



<%--<%!--%>
<%--    private static Log _log = LogFactoryUtil.getLog("html.view_search_jsp");--%>
<%--%>--%>
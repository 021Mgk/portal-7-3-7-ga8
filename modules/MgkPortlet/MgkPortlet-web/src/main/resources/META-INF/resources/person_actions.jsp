<%@include file="/init.jsp" %>

<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    Person person = (Person) row.getObject();
%>

<liferay-ui:icon-menu>


    <portlet:renderURL var="viewPersonURL">
        <portlet:param name="personId" value="<%= String.valueOf(person.getPersonId()) %>"/>
        <portlet:param name="mvcRenderCommandName" value="/person/view"/>
    </portlet:renderURL>

    <liferay-ui:icon message="View" url="<%= viewPersonURL.toString() %>"/>


    <portlet:renderURL var="editURL">
        <portlet:param name="pID" value="<%= String.valueOf(person.getPersonId()) %>"/>
        <portlet:param name="mvcPath" value="/edit_person.jsp"></portlet:param>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>"/>

    <%--        <c:if--%>
    <%--                test="<%= PersonPermission.contains(permissionChecker, person.getPersonId(), ActionKeys.UPDATE) %>">--%>
    <%--            <portlet:renderURL var="editURL">--%>
    <%--                <portlet:param name="entryId"--%>
    <%--                               value="<%= String.valueOf(person.getPersonId()) %>" />--%>
    <%--                <portlet:param name="mvcPath" value="/guestbook/edit_entry.jsp" />--%>
    <%--            </portlet:renderURL>--%>

    <%--            <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />--%>
    <%--        </c:if>--%>

<%--    <c:if test="<%=PersonPermission.contains(permissionChecker, person.getPersonId(), ActionKeys.PERMISSIONS) %>">--%>

<%--        <liferay-security:permissionsURL--%>
<%--                modelResource="<%= Person.class.getName() %>"--%>
<%--                modelResourceDescription="<%= person.getName() + person.getFamily()%>"--%>
<%--                resourcePrimKey="<%= String.valueOf(person.getPersonId()) %>"--%>
<%--                var="permissionsURL"/>--%>

<%--        <liferay-ui:icon image="permissions" url="<%= permissionsURL %>"/>--%>

<%--    </c:if>--%>



    <%--    <c:if--%>
    <%--            test="<%=GuestbookEntryPermission.contains(permissionChecker, entry.getEntryId(), ActionKeys.DELETE) %>">--%>

    <%--        <portlet:actionURL name="deleteEntry" var="deleteURL">--%>
    <%--            <portlet:param name="entryId"--%>
    <%--                           value="<%= String.valueOf(entry.getEntryId()) %>" />--%>
    <%--            <portlet:param name="guestbookId"--%>
    <%--                           value="<%= String.valueOf(entry.getGuestbookId()) %>" />--%>
    <%--        </portlet:actionURL>--%>

    <%--        <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />--%>
    <%--    </c:if>--%>

</liferay-ui:icon-menu>
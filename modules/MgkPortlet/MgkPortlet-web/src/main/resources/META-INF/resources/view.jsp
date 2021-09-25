<%@ include file="/init.jsp" %>


<%--&lt;%&ndash;&lt;%&ndash;%>--%>
<%--&lt;%&ndash;    long personId = ParamUtil.getLong(renderRequest, "personId");&ndash;%&gt;--%>
<%--&lt;%&ndash;    Person person = null;&ndash;%&gt;--%>
<%--&lt;%&ndash;    if (personId > 0) {&ndash;%&gt;--%>
<%--&lt;%&ndash;        person = PersonLocalServiceUtil.getPerson(personId);&ndash;%&gt;--%>
<%--&lt;%&ndash;    }&ndash;%&gt;--%>
<%--&lt;%&ndash;%>&ndash;%&gt;--%>

<%--&lt;%&ndash;<aui:input name="pId" type="hidden" value="<%= person.getPersonId() %>"/>&ndash;%&gt;--%>


<%--<div id="error">--%>
<%--    <c:if test="${!empty errors}">--%>
<%--        <ul>--%>
<%--            <c:forEach items="${errors}" var="error">--%>
<%--                <li style="color: red"><c:out value="${error}"></c:out></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </c:if>--%>
<%--</div>--%>
<%--<liferay-ui:error exception="<%= PersonEmailException.class %>" message="email email"/>--%>

<portlet:renderURL var="searchURL">
    <portlet:param name="mvcRenderCommandName" value="/person/search"/>
</portlet:renderURL>


<aui:form action="<%= searchURL.toString() %>" name="fm">

    <div class="row">
        <div class="col-md-8">
            <aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
        </div>

        <div class="col-md-4">
            <aui:button type="submit" value="search" />
        </div>
    </div>

</aui:form>



<portlet:renderURL var="showPersonURL">
    <portlet:param name="mvcRenderCommandName" value="/person/list"></portlet:param>
</portlet:renderURL>


<%--<c:if test='<%= PersonPermission.contains(permissionChecker, scopeGroupId, "ADD_ENTRY") %>'>--%>
<portlet:renderURL var="addPersonURL">
    <portlet:param name="mvcPath" value="/edit_person.jsp"></portlet:param>
</portlet:renderURL>
<aui:button-row>
    <aui:button onClick="<%= addPersonURL.toString() %>" value="Add Person"></aui:button>
</aui:button-row>

<%--</c:if>--%>
<%--    <portlet:renderURL var="addEntryURL">--%>
<%--        <portlet:param name="mvcPath" value="/guestbook/edit_entry.jsp" />--%>
<%--        <portlet:param name="guestbookId" value="<%=String.valueOf(guestbookId)%>" />--%>
<%--    </portlet:renderURL>--%>

<%--    <aui:button onClick="<%=addEntryURL.toString()%>" value="Add Entry"></aui:button>--%>


<aui:button-row>
    <aui:button onClick="<%= showPersonURL.toString() %>" value="show Persons"></aui:button>
</aui:button-row>


<aui:button-row>
    <aui:button
            value="add person pop-up"
            onClick='<%= liferayPortletResponse.getNamespace() + "uploadUrlLink();" %>'
    ></aui:button>
</aui:button-row>


<aui:script>
    function <portlet:namespace/>uploadUrlLink() {
    Liferay.Util.openWindow({
    // refreshWindow: WIN,
    dialog: {
    destroyOnHide: true,
    // after: {
    // destroy: function (event) {
    // window.location.reload();
    // },
    // },
    cssClass:'qqqqq'
    },
    dialogIframe: {
    bodyCssClass: 'task-dialog',
    },
    title: 'add person',
    uri:
    '<liferay-portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath"
                                                                                                         value="/edit_person.jsp"/></liferay-portlet:renderURL>',
    });
    }
</aui:script>

<%--<aui:script>--%>

<%--    Liferay.Util.openWindow(--%>
<%--    {--%>
<%--    id: dialogId,--%>
<%--    dialog: {--%>
<%--    bodyContent:--%>
<%--    '<p><liferay-ui:message key="<%= messageKey %>"/></p><div aria-hidden="true" class="loading-animation"></div>',--%>
<%--    cssClass: 'google-docs-redirect-modal',--%>
<%--    height: 172,--%>
<%--    modal: true,--%>
<%--    resizable: false,--%>
<%--    title: '',--%>
<%--    width: 320,--%>
<%--    },--%>
<%--    },--%>
<%--    function () {--%>
<%--    setTimeout(polling, TIME_POLLING);--%>

<%--    setTimeout(function () {--%>
<%--    isTimeConsumed = true;--%>

<%--    navigate();--%>
<%--    }, TIME_SHOW_MSG);--%>
<%--    }--%>
<%--    );--%>
<%--</aui:script>--%>
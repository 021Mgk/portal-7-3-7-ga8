<%@ include file="/init.jsp" %>


<%
    long pID = ParamUtil.getLong(renderRequest, "pID");
    Person person = null;
    if (pID > 0) {
        person = PersonLocalServiceUtil.getPerson(pID);
    }
%>

<%= pID %>


<liferay-ui:success key="personAdded" message="person-added"/>
<liferay-ui:success key="personUpdated" message="person-updated"/>
<liferay-ui:error key="personError" message="person-error"/>


<%--<liferay-ui:error exception="<%= PersonEmailException.class %>" message="email email"/>--%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>


<portlet:actionURL name="addPerson" var="addPersonURL"></portlet:actionURL>

<portlet:resourceURL var="downloadURL"></portlet:resourceURL>

<aui:form action="<%= addPersonURL %>" name="<portlet:namespace />fm" enctype="multipart/form-data">

    <aui:model-context bean="<%= person %>" model="<%= Person.class %>"/>


    <aui:fieldset>

        <aui:input name="name">
            <aui:validator name="required"/>
        </aui:input>
        <p style="color: red"><c:out value="${errors.name}"></c:out></p>
        <aui:input name="family">
            <aui:validator name="required"/>
        </aui:input>
        <p style="color: red"><c:out value="${errors.family}"></c:out></p>
        <aui:input name="email">
            <liferay-ui:message key="${errors.email}"/>
            <%--            <aui:validator name="required"  />--%>
            <%--            <aui:validator name="email" />--%>
        </aui:input>

        <p style="color: red"><c:out value="${errors.email}"></c:out></p>
        <aui:input name="address"/>
        <p style="color: red"><c:out value="${errors.address}"></c:out></p>
        <aui:input name="phoneNumber">
            <aui:validator name="digits"/>
        </aui:input>
        <p style="color: red"><c:out value="${errors.phoneNumber}"></c:out></p>
        <aui:input name="nationalCode">
            <aui:validator name="digits"/>
            <aui:validator name="maxLength">10</aui:validator>
            <aui:validator name="minLength">10</aui:validator>
        </aui:input>
        <p style="color: red"><c:out value="${errors.nationalCode}"></c:out></p>
        <aui:input name="description" type="textarea" helpMessage="text"/>
        <p style="color: red"><c:out value="${errors.description}"></c:out></p>

                <aui:input type="file" name="userImage" />
        <%--        <a href="<%= downloadURL %>">Click Here for Download</a>--%>

        <c:if test="<%= pID != 0 %>">
            <aui:input name="PID" type="hidden" value="<%= pID %>"/>
        </c:if>


    </aui:fieldset>


    <aui:button-row>


        <c:choose>
            <c:when test="<%= pID == 0 %>">
                <aui:button type="submit" value="Send" cssClass="mgk-btn"></aui:button>
            </c:when>
            <c:otherwise>

                <aui:button type="submit" value="Update" cssClass="mgk-btn-2"></aui:button>
                <portlet:renderURL var="addPersonURL">
                    <portlet:param name="mvcPath" value="/edit_person.jsp"></portlet:param>
                </portlet:renderURL>

                <aui:button  onClick="<%= addPersonURL.toString() %>" cssClass="btn-info" value="New"></aui:button>
            </c:otherwise>
        </c:choose>


        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>

</aui:form>

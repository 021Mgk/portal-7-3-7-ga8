<%@include file="/init.jsp" %>


<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>


<aui:button-row>
    <aui:button onClick="<%= viewURL.toString() %>" value="Back"> </aui:button>
</aui:button-row>


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


<liferay-ui:search-container delta="10"
                             emptyResultsMessage="no-entries-were-found"
                             total="${personList.size()}">
    <liferay-ui:search-container-results
            results="${personList}"
    />

    <liferay-ui:search-container-row
            className="mgkportlet.model.Person"
            keyProperty="personId" modelVar="person" escapedModel="<%=true%>">

        <liferay-ui:search-container-column-text property="name"/>
        <liferay-ui:search-container-column-text property="family"/>
        <%--        <liferay-ui:search-container-column-status property="status" />--%>
        <liferay-ui:search-container-column-jsp align="right" path="/person_actions.jsp"/>


    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>

</liferay-ui:search-container>


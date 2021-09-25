<%@ include file="/init.jsp" %>




<portlet:renderURL var="showPersonURL">
    <portlet:param name="mvcRenderCommandName" value="/person/list"></portlet:param>
</portlet:renderURL>




<aui:button-row>
    <aui:button onClick="<%= showPersonURL.toString() %>" value="Back"> </aui:button>
</aui:button-row>



<div><strong>name:  </strong> <span>${person.name}</span></div>
<div><strong>family:  </strong> <span>${person.family}</span></div>
<div><strong>email:  </strong> <span>${person.email}</span></div>
<div><strong>address:  </strong> <span>${person.address}</span></div>
<div><strong>nationalCode:  </strong> <span>${person.nationalCode}</span></div>
<div><strong>phoneNumber:  </strong> <span>${person.phoneNumber}</span></div>




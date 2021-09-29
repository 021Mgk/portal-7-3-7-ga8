package mgkportlet.web.portlet;



import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.*;
import mgkportlet.model.Person;
import mgkportlet.service.PersonLocalService;
import mgkportlet.constants.MgkPortletWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;


import mgkportlet.service.PersonService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author USER
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=MgkPortletWeb",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + MgkPortletWebPortletKeys.MGKPORTLETWEB,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MgkPortletWebPortlet extends MVCPortlet {


    public void addPerson(ActionRequest request, ActionResponse response) throws Exception {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Person.class.getName(), request);
        UploadPortletRequest uploadPortletRequest = _portal.getUploadPortletRequest(request);

        String name = ParamUtil.getString(request, "name");
        System.out.println("name: " + name);
        String family = ParamUtil.getString(request, "family");
        System.out.println("family: " + family);
        String email = ParamUtil.getString(request, "email");
        System.out.println("email:" + email);
        String address = ParamUtil.getString(request, "address");
        System.out.println("address: " + address);
        String nationalcode = ParamUtil.getString(request, "nationalCode");
        System.out.println("nationalcode:" + nationalcode);
        String description = ParamUtil.getString(request, "description");
        System.out.println("des:" + description);
        String phoneNumber = ParamUtil.getString(request, "phoneNumber");
        System.out.println("phone:" + phoneNumber);
        //  String filename =  uploadFile(request , response);
        String image = "file.png";


        Long PID = ParamUtil.getLong(request, "PID");
        System.out.println(PID);

//		try (InputStream inputStream =   uploadPortletRequest.getFileAsStream("userImage")) {
//
//			String contentType = uploadPortletRequest.getContentType("userImage");
//			long size = uploadPortletRequest.getSize("userImage");
//
//
//			Folder folder = addFolder("person_gallary", "person images" , 0l , serviceContext);
//
//
//			String uniqueFileName = PortletFileRepositoryUtil.getUniqueFileName(
//					serviceContext.getScopeGroupId(), 40602, fileName);
//
//			System.out.println("fileName " + uniqueFileName);
//
//			System.out.println(MimeTypesUtil.getContentType(inputStream , fileName));
//
//
//			FileEntry fileEntry = _dlAppService.addFileEntry(
//					serviceContext.getScopeGroupId(), folder.getFolderId(), uniqueFileName, contentType, uniqueFileName,
//					description, uniqueFileName, inputStream, size, serviceContext);
//
//
//
//			System.out.println(size);
//			System.out.println(contentType);
//			System.out.println(fileEntry.getExtension());
//			System.out.println(fileEntry.getMimeType());
//			image = fileEntry.getFileName()+"."+fileEntry.getExtension();
//		}catch (Exception e){
//			e.printStackTrace();
//		}

//        try {
//            validate(email);
//
//            if (PID == 0) {
//                try {
//                    Person person = _personLocalService.addPerson(serviceContext.getUserId(), name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
//
//                    System.out.println(person.toString());
//
//                    String pID = Long.toString(person.getPersonId());
//                    System.out.println(pID);
//                    response.getRenderParameters().setValue("pID", pID);
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionMessages.add(request, "personAdded");
//                } catch (Exception e) {
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionErrors.add(request, "personError");
//                }
//            } else {
//                try {
//                    Person person = _personLocalService.updatePerson(serviceContext.getUserId(), PID, name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
//                    System.out.println(person.toString());
//                    String pID = Long.toString(person.getPersonId());
//                    System.out.println(pID);
//                    response.getRenderParameters().setValue("pID", pID);
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionMessages.add(request, "personAdded");
//                } catch (Exception e) {
//                    PortalUtil.copyRequestParameters(request, response);
//                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//                    SessionErrors.add(request, "personError");
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("--------------------------------------------------------------------------");
//            e.printStackTrace();
//            SessionErrors.add(request, "personError");
//            PortalUtil.copyRequestParameters(request, response);
//            response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
//        }


        Map<String, String> errors = validate(name, family, email, address, nationalcode, description, phoneNumber, request);
        if (errors.size() != 0) {
            request.setAttribute("errors", errors);
            SessionErrors.add(request, "personError");
            PortalUtil.copyRequestParameters(request, response);
            response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
        } else {


            if (PID == 0) {
                try (InputStream inputStream = uploadPortletRequest.getFileAsStream("userImage")) {
                    String contentType = uploadPortletRequest.getContentType("userImage");
                    long size = uploadPortletRequest.getSize("userImage");

                    Person person = _personLocalService.addPerson(serviceContext.getUserId(), name, family, email, address, phoneNumber, nationalcode, description, image, inputStream , contentType , size , serviceContext);

                    System.out.println(person.toString());

                    String pID = Long.toString(person.getPersonId());
                    System.out.println(pID);
                    response.getRenderParameters().setValue("pID", pID);
                    PortalUtil.copyRequestParameters(request, response);
                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
                    SessionMessages.add(request, "personAdded");
                } catch (Exception e) {
                    PortalUtil.copyRequestParameters(request, response);
                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
                    SessionErrors.add(request, "personError");
                }
            } else {
                try {
                    Person person = _personService.updatePerson(serviceContext.getUserId(), PID, name, family, email, address, phoneNumber, nationalcode, description, image, serviceContext);
                    System.out.println(person.toString());
                    String pID = Long.toString(person.getPersonId());
                    System.out.println(pID);
                    response.getRenderParameters().setValue("pID", pID);
                    PortalUtil.copyRequestParameters(request, response);
                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
                    SessionMessages.add(request, "personAdded");
                } catch (Exception e) {
                    PortalUtil.copyRequestParameters(request, response);
                    response.getRenderParameters().setValue("mvcPath", "/edit_person.jsp");
                    SessionErrors.add(request, "personError");
                }
            }

        }

    }


    public Map<String, String> validate(String name, String family, String email, String address, String nationalCode, String description,
                                        String phoneNumber, ActionRequest request) throws Exception {
        Map<String, String> errors = new HashMap<>();
        ResourceBundle bundle = getPortletConfig().getResourceBundle(request.getLocale());
        if (Validator.isNull(name)) {
            errors.put("name", "name zarori ast");
            //throw  new PersonEmailException("sadsd");

        }
        if (Validator.isNull(family)) {
            errors.put("family", "family zarorti ast");
        }
        if (Validator.isNull(address)) {
            errors.put("address", "family zarorti ast");
        }
        if (Validator.isNull(phoneNumber) && phoneNumber.length() == 11) {
            errors.put("phoneNumber", "phone number");
        }
        if (Validator.isNull(nationalCode)) {
            errors.put("nationalCode", "cod zarorti ast");
        }
        if (Validator.isNull(description)) {
            errors.put("description", "family zarorti ast");
        }
        if (!Validator.isEmailAddress(email)) {
            errors.put("email", "email sahih vared nammaid");
            //throw  new PersonEmailException();
        }
        return errors;
    }

//
//    public void validate(String email) throws Exception {
//
//        if (!Validator.isEmailAddress(email)) {
//            throw new PersonEmailException();
//        }
//    }

    /////////////////////////////

//    SOAPBody soapBody = _webService.fetchGolestanData(
//            SBUWebServiceConstants.GOLESTAN_1030_SECRET_CODE, SBUWebServiceConstants.PUBLIC_FILTER,
//            SBUWebServiceConstants.PRIVATE_FILTER, SBUWebServiceConstants.GOLESTAN_1030_REPORT_ID);
//
//    NodeList nodeList = soapBody.getElementsByTagName(SBUWebServiceConstants.GOLESTAN_1030_TAG_NAME);
//
//    int nodeSize = nodeList.getLength();
//
//    List<DepartmentWebservice> departmentWebserviceList = new ArrayList<>();
//
//        /*Locale enLocale = new Locale("en", "US");
//		Locale faLocale = new Locale("fa", "IR");*/
//
//    Locale enLocale = UniversityLanguageUtil.getLocale("en");
//
//    Locale faLocale = UniversityLanguageUtil.getLocale("fa");
//
//    String departmentTitleEng = null;
//
//        for(int idx = 0; idx < nodeSize;idx++) {
//        Node node = nodeList.item(idx);
//
//        NamedNodeMap namedNodeMap = node.getAttributes();
//
//        Node departmentCodeNode = namedNodeMap.getNamedItem("C1");
//
//        String departmentCode = (departmentCodeNode == null) ? "" : departmentCodeNode.getNodeValue();
//
//        Node departmentTitleNode = namedNodeMap.getNamedItem("C2");
//
//        departmentTitleEng = getStringEnglishDepartment(departmentCode);
//
//        String departmentTitleFa = departmentTitleNode == null ? "" : departmentTitleNode.getNodeValue();
//
//        Map<Locale, String> name = new HashMap<>();
//
//        ArrayList<String> languageValid = UniversityLanguageUtil.languageValid(departmentTitleFa, departmentTitleEng);
//
//        name.put(enLocale, languageValid.get(1));
//        name.put(faLocale, languageValid.get(0));
//
//        DepartmentWebservice departmentWebservice = new DepartmentWebservice(name, departmentCode, 0L);
//
//        departmentWebserviceList.add(departmentWebservice);
//    }
//
//
//    //////////////////////////////
//    public String getResponse(String address, String body) {
//
//        HttpURLConnection httpURLConnection = this.restWebservice.getBasicHttpURLConnection(address, body, "POST", "application/json", false);
//
//        if (httpURLConnection == null || this.restWebservice.getResponseCodeFromConnection(httpURLConnection) != HttpURLConnection.HTTP_OK){
//            if (httpURLConnection == null){
//                this.uniResponseStatusMessage = "connection-error";
//                this.uniResponseStatusCode = HttpURLConnection.HTTP_NOT_FOUND;
//            }else {
//                this.uniResponseStatusMessage = "connection-error";
//                this.uniResponseStatusCode = restWebservice.getResponseCodeFromConnection(httpURLConnection);
//            }
//            return null;
//        }else {
//            return this.restWebservice.getResponseFromConnection(httpURLConnection);
//        }
//    }
//
//    public void callWebservice() {
//        try {
//
//            String userInfoResponse = getUserInfo(this.username);
//
//            if (Validator.isNotNull(userInfoResponse)) {
//
//                JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userInfoResponse);
//
//                JSONObject jsonObjectResult = jsonObject.getJSONObject("result");
//
//                JSONArray jsonObjectReport = jsonObjectResult.names();
//
//                JSONObject jsonObjectUserId = jsonObjectResult.getJSONObject(jsonObjectReport.getString(0));
//
//                JSONObject jsonObjectBasicInfo = jsonObjectUserId.getJSONObject("basic_info");
//
//                double result = jsonObjectBasicInfo.getDouble("credit");
//                if (result > 0) {
//                    credit = Math.round((result / 1000) * 100.0) / 100.0;
//                }
//
//                String groupName = jsonObjectBasicInfo.getString("group_name");
//
//                int groupId = jsonObjectBasicInfo.getInt("group_id");
//
//                String groupInfoResponse = getGroupInfo(groupName, groupId);
//
//                if (Validator.isNotNull(groupInfoResponse)) {
//
//                    JSONObject jsonGroupObject = JSONFactoryUtil.createJSONObject(groupInfoResponse);
//
//                    JSONObject jsonObjectGroupResult = jsonGroupObject.getJSONObject("result");
//
//                    JSONObject jsonObjectGroupAttrs = jsonObjectGroupResult.getJSONObject("attrs");
//
//                    String chargeReset = jsonObjectGroupAttrs.getString("monthly_periodic_credit_change_reset");
//
//                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//                    Date chargeResetDate = dateFormat.parse(chargeReset);
//
//                    Date now = new Date();
//
//                    long differenceInTime
//                            = chargeResetDate.getTime() - now.getTime();
//
//                    differenceInDays
//                            = (int) ((differenceInTime
//                            / (1000 * 60 * 60 * 24))
//                            % 365);
//
//                }
//
//            }
//
//
//
//        } catch (Exception e) {
//            this.uniResponseStatusCode = HttpURLConnection.HTTP_BAD_METHOD;
//            this.uniResponseStatusMessage = "connection-error";
//            e.printStackTrace();
//        }
//    }
//
//    private String getUserInfo(String username) {
//        String input = "{\"method\":\"user.getUserInfo\",\"params\":{\"normal_username\":\"" + username + "\"," +
//                "\"auth_name\":\"" + AUTH_NAME + "\",\"auth_pass\":\"" + AUTH_PATH + "\",\"auth_type\":\"ADMIN\"},\"id\":1}";
//
//        return getResponse(BASE_URL, input);
//    }
//
//    private String getGroupInfo(String groupName, int groupId) {
//        String input = "{\n" +
//                "    \"method\": \"group.getGroupInfo\",\n" +
//                "    \"params\": {\n" +
//                "        \"group_name\": \"" + groupName + "\",\n" +
//                "        \"auth_name\": \"" + AUTH_NAME + "\",\n" +
//                "        \"auth_pass\": \"" + AUTH_PATH + "\",\n" +
//                "        \"auth_type\": \"ADMIN\",\n" +
//                "        \"group_id\": " + groupId + "\n" +
//                "    }\n" +
//                "}";
//
//        return getResponse(BASE_URL, input);
//    }





    @Reference
    private PersonLocalService _personLocalService;

    @Reference
    private PersonService _personService;


    @Reference
    private Portal _portal;

}
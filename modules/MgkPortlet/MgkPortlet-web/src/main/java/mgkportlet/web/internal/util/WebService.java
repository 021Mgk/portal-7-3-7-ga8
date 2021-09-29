package mgkportlet.web.internal.util;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.ServiceScope;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import java.util.Map;

/**
 * @author Hossein Khoshniat
 */
@Component(
        scope = ServiceScope.SINGLETON
)
public class WebService {

//    public SOAPMessage createGolestanSOAPRequest(String secText, String pubText, String priText, String iFIDText) throws SOAPException {
//
//        MessageFactory messageFactory = MessageFactory.newInstance();
//
//        SOAPMessage soapMessage = messageFactory.createMessage();
//
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//
//        SOAPEnvelope envelope = soapPart.getEnvelope();
//
//        SOAPBody soapBody = envelope.getBody();
//
//        SOAPElement soapBodyElem = soapBody.addChildElement(
//                "golInfo", "", "urn:nowpardaz");
//
//        SOAPElement login = soapBodyElem.addChildElement("login");
//
//        login.addTextNode(
//                _universityConnectionConfiguration.getGolestanUserName());
//
//        SOAPElement pass = soapBodyElem.addChildElement("pass");
//
//        pass.addTextNode(
//                _universityConnectionConfiguration.getGolestanPassword());
//
//        SOAPElement sec = soapBodyElem.addChildElement("sec");
//
//        sec.addTextNode(secText);
//
//        SOAPElement pub = soapBodyElem.addChildElement("pub");
//
//        pub.addTextNode(pubText);
//
//        SOAPElement pri = soapBodyElem.addChildElement("pri");
//
//        pri.addTextNode(priText);
//
//        SOAPElement prv = soapBodyElem.addChildElement("prv");
//
//        prv.addTextNode("");
//
//        SOAPElement mor = soapBodyElem.addChildElement("Mor");
//
//        mor.addTextNode("");
//
//        SOAPElement ifid = soapBodyElem.addChildElement("iFID");
//
//        ifid.addTextNode(iFIDText);
//
//        MimeHeaders headers = soapMessage.getMimeHeaders();
//
//        headers.addHeader("SOAPAction", "urn:nowpardaz/golInfo");
//
//        soapMessage.saveChanges();
//
//        return soapMessage;
//    }
//
//    public SOAPBody fetchGolestanData(
//            String secretCode, String publicFilter, String privateFilter,
//            String reportId) {
//
//        SOAPBody soapBody = null;
//
//        try {
//            SOAPConnectionFactory soapConnectionFactory =
//                    SOAPConnectionFactory.newInstance();
//
//            SOAPConnection soapConnection =
//                    soapConnectionFactory.createConnection();
//
//            SOAPMessage soapResponse = soapConnection.call(
//                    createGolestanSOAPRequest(
//                            secretCode, publicFilter, privateFilter, reportId),
//                    _universityConnectionConfiguration.getUniversityAddress());
//
////						soapResponse.writeTo(System.out);
//            soapBody = soapResponse.getSOAPBody();
//
//            NodeList errorNodeList = soapBody.getElementsByTagName(
//                    "e");
//
//            if (errorNodeList.getLength() > 0){
//                throw new Exception(errorNodeList.item(0).getTextContent());
//            }
//        }
//        catch (Exception e) {
//            System.err.println(
//                    "Error occurred while sending SOAP Request to Server");
//            e.printStackTrace();
//        }
//
//        return soapBody;
//    }
//
//    @Activate
//    @Modified
//    protected void activate(Map<String, Object> properties) {
//        _universityConnectionConfiguration =
//                ConfigurableUtil.createConfigurable(
//                        UniversityConnectionConfiguration.class, properties);
//    }
//
//    private UniversityConnectionConfiguration
//            _universityConnectionConfiguration;

}
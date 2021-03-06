package mgkportlet.web.portlet;


import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import mgkportlet.model.Person;
import mgkportlet.service.PersonLocalService;
import mgkportlet.constants.MgkPortletWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MgkPortletWebPortletKeys.MGKPORTLETWEB,
                "mvc.command.name=/person/view"
        },
        service = MVCRenderCommand.class
)
public class PersonRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {


        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(Person.class.getName(), renderRequest);

            Long personId = ParamUtil.getLong(renderRequest, "personId");
            System.out.println(personId + " from PersonRenderCommand");
            Person person = _personLocalService.getPerson(personId);
            renderRequest.setAttribute("person", person);

//            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//            Date startDate = df.parse(actionRequest.getParameter("startDate"));


            return "/person_view.jsp";


        } catch (Exception e) {
            throw new PortletException(e);
        }


    }

    @Reference
    private PersonLocalService _personLocalService;

}




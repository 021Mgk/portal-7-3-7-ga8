package mgkportlet.web.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import mgkportlet.model.Person;
import mgkportlet.service.PersonLocalService;
import mgkportlet.web.constants.MgkPortletWebPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MgkPortletWebPortletKeys.MGKPORTLETWEB,
                "mvc.command.name=/person/list"
        },
        service = MVCRenderCommand.class
)
public class PersonListRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Person.class.getName(), renderRequest);

            List<Person> personList = _personLocalService.getPersons(serviceContext.getScopeGroupId());


            renderRequest.setAttribute("personList", personList);
        } catch (Exception e) {
            throw new PortletException(e);
        }


        return "/person_list.jsp";
    }

    @Reference
    private PersonLocalService _personLocalService;
}

package mgkportlet.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import mgkportlet.model.Person;
import mgkportlet.service.PersonLocalServiceUtil;
import mgkportlet.web.constants.MgkPortletWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + MgkPortletWebPortletKeys.MGKPORTLETWEB,
                "mvc.command.name=/person/search"
        },
        service = MVCRenderCommand.class
)
public class PersonSearchViewRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {

            String keywords = ParamUtil.getString(renderRequest, "keywords");

            System.out.println("keeeeeey " + keywords);
            List<Person> personList = new ArrayList<Person>();

            if (!keywords.equals("")) {
                HttpServletRequest _request = PortalUtil.getHttpServletRequest(renderRequest);

                SearchContext searchContext = SearchContextFactory.getInstance(_request);
                searchContext.setKeywords(keywords);
                searchContext.setAttribute("paginationType", "more");
                searchContext.setStart(0);
                searchContext.setEnd(10);
                Indexer<Person> indexer = IndexerRegistryUtil.getIndexer(Person.class);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                Hits hits = indexer.search(searchContext);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + hits.getDocs().length);

                for (int i = 0; i < hits.getDocs().length; i++) {
                    Document doc = hits.doc(i);
                    long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
                    Person entry = null;
                    try {
                        entry = PersonLocalServiceUtil.getPerson(entryId);
                        System.out.println(entry.getName());
                    } catch (PortalException pe) {
                        _log.error(pe.getLocalizedMessage());
                    } catch (SystemException se) {
                        _log.error(se.getLocalizedMessage());
                    }
                    personList.add(entry);
                }

            }


            renderRequest.setAttribute("personList", personList);
        } catch (Exception e) {
            throw new PortletException(e);
        }


        return "/view_search.jsp";
    }


    private static Log _log = LogFactoryUtil.getLog("html.view_search_jsp");
}

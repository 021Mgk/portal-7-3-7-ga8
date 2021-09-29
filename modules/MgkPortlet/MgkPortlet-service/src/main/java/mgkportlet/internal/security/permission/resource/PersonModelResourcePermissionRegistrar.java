package mgkportlet.internal.security.permission.resource;



import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import mgkportlet.constants.MgkPortletWebPortletKeys;
import mgkportlet.model.Person;
import mgkportlet.service.PersonLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

@Component (immediate=true)
public class PersonModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", Person.class.getName());

        _serviceRegistration = bundleContext.registerService(
                ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(
                        Person.class, Person::getPersonId,
                        _personLocalService::getPerson, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(
                                    new StagedModelPermissionLogic<>(
                                            _stagingPermission, MgkPortletWebPortletKeys.MGKPORTLETWEB,
                                            Person::getPersonId));
//                            consumer.accept(
//                                    new WorkflowedModelPermissionLogic<>(
//                                            _workflowPermission, modelResourcePermission,
//                                            _groupLocalService, Person::getPersonId));
                        }),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private PersonLocalService _personLocalService;

    @Reference(target = "(resource.name=" + MgkPortletWebPortletKeys.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

//    @Reference
//    private WorkflowPermission _workflowPermission;
//
//    @Reference
//    private GroupLocalService _groupLocalService;
}
package mgkportlet.web.internal.security.permission.resource;



import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import mgkportlet.model.Person;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class PersonModelPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, Person person, String actionId) throws PortalException {

        return _personModelResourcePermission.contains(permissionChecker, person, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, long personId, String actionId) throws PortalException {

        return _personModelResourcePermission.contains(permissionChecker, personId, actionId);
    }

    @Reference(
            target = "(model.class.name=mgkportlet.model.Person)",
            unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Person> modelResourcePermission) {

        _personModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Person> _personModelResourcePermission;

}
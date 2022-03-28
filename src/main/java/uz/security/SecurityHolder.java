package uz.security;

import lombok.Setter;
import uz.services.projectList.ProjectList;

import java.util.List;
import java.util.Objects;

@Setter
public class SecurityHolder {
    public static SessionUser session;
    public static Long organizationId;
    public static List<PermissionsItem> permissions;
    public static ProjectList projectList;

    public static boolean hasPermission(String permission) {
        if (Objects.isNull(session))
            throw new RuntimeException("NOT_AUTHORIZED");
        for (PermissionsItem sessionPermission : session.getPermissions()) {
            if (sessionPermission.getCode().equals(permission)) return true;
        }
        return false;
    }

    public static void setSession(SessionUser just_session) {
        permissions = just_session.getPermissions();
        session = just_session;
        organizationId = session.getOrganization().getId();
    }

    public  static void setProjectList(ProjectList list){
        projectList=list;
    }


    public static void  killSession(){
        permissions = null;
        session = null;
        organizationId = null;
    }

}

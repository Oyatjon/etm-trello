package uz.ui;

import uz.jl.utils.Color;
import uz.jl.utils.Print;
import uz.security.PermissionsItem;
import uz.security.SecurityHolder;

import java.util.Objects;

/**
 * @author : Oyatjon  -> @data : 22:51
 */

public class Menu {
    public static void getMainMenu() {
        if (Objects.isNull(SecurityHolder.session)){
            Print.println(Color.BLUE,"Login -> LOGIN");
        }else {
            if (SecurityHolder.session.isIsSuperUser()){
                Print.println(Color.BLUE, "Create organization -> CREATE_ORG");
                Print.println(Color.BLUE, "Update organization -> UPDATE_ORG");
                Print.println(Color.BLUE, "Block organization -> BLOCK_ORG");
                Print.println(Color.BLUE, "UnBlock organization -> UNBLOCK_ORG");
                Print.println(Color.BLUE, "Delete organization -> DELETE_ORG");
            }
            for (PermissionsItem permission : SecurityHolder.permissions) {
                Print.println(Color.BLUE,permission.getName() + " -> " + permission.getCode());
            }
            Print.println("Logout -> LOGOUT");
        }
        Print.println(Color.BLUE, "Exit -> EXIT");
    }
}

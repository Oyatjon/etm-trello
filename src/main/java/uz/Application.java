package uz;

import uz.container.UNIContainer;
import uz.jl.utils.Input;
import uz.security.SecurityHolder;
import uz.ui.*;
import uz.ui.Menu;

import java.util.Locale;

/**
 * created by Oyatjon ON 1/17/2022
 *
 * @author : Oyatjon  -> @data : 23:54
 */

public class Application {
    public static void main(String[] args) {
        Menu.getMainMenu();
        menu(args);
    }
    private static void menu(String[] args) {
        AuthUI authUI = UNIContainer.getBean(AuthUI.class);
        ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
        OrgUI orgUI = UNIContainer.getBean(OrgUI.class);
        ColumnUI commentUI = UNIContainer.getBean((ColumnUI.class));
    //    TaskUI taskUI =UNIContainer.getBean(TaskUI.class);
       // CommentUI commentUI = UNIContainer.getBean(CommentUI.class);
        String choice = Input.getStr("Your choice : ").toLowerCase(Locale.ROOT);
        switch (choice){
            case "login" -> authUI.login();
            case "project_list" -> authUI.projectList();
            case "create_org" -> orgUI.createOrg();
            case "update_org" -> orgUI.updateOrg();
            case "block_org" -> orgUI.blockOrg();
            case "unblock_org" -> orgUI.unblockOrg();
            case "delete_org" -> orgUI.deleteOrg();
            case "create_user" -> authUI.createUser();
            case "update_user" ->authUI.updateUser();
            case "create_project"->projectUI.createProject();
            //case  "create_project_column" -> commentUI.createProjectColumn();
           // case "task_create" -> taskUI.createTask();
         //   case "create_comment" -> commentUI.createComment();
            case "logout" -> SecurityHolder.killSession();
            case "exit"->{return;}
            default -> {
                System.out.println("Wrong choice");
            }
        }
        main(args);
    }
}

package uz.container;

import uz.property.ApplicationProperties;
import uz.property.DatabaseProperties;
import uz.repository.auth.AuthUserRepositoryImpl;
import uz.repository.column.ColumnRepository;
import uz.repository.organization.OrgRepository;
import uz.repository.project.ProjectRepository;
import uz.services.auth.AuthUserService;
import uz.services.column.ColumnService;
import uz.services.org.OrgService;
import uz.services.project.ProjectService;
import uz.ui.AuthUI;
import uz.ui.ColumnUI;
import uz.ui.OrgUI;
import uz.ui.ProjectUI;
import uz.utils.BaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * @author : Oyatjon  -> @data : 23:58
 */

public class UNIContainer {
    private final static ApplicationProperties APPLICATION_PROPERTIES;
    private final static DatabaseProperties DATABASE_PROPERTIES;
    private static Connection CONNECTION;
    private final static AuthUserRepositoryImpl AUTH_USER_REPOSITORY;
    private final static AuthUserService AUTH_USER_SERVICE;
    private final static AuthUI AUTH_UI;
    private final  static ProjectRepository PROJECT_REPOSITORY;
    private final static ProjectService PROJECT_SERVICE;
    private final static ProjectUI PROJECT_UI;
    private final static OrgRepository ORG_REPOSITORY;
    private final static OrgService ORG_SERVICE;
    private final static OrgUI ORG_UI;


    private final static ColumnRepository COLUMN_REPOSITORY;
    private final static ColumnService COLUMN_SERVICE;
    private  final  static ColumnUI COLUMN_UI;



    private final static BaseUtils BASE_UTILS;

    static {
        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();
        BASE_UTILS = new BaseUtils();
        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        AUTH_USER_REPOSITORY = new AuthUserRepositoryImpl();
        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY);
        AUTH_UI = new AuthUI(AUTH_USER_SERVICE);
        PROJECT_REPOSITORY = new ProjectRepository();
        PROJECT_SERVICE =new ProjectService(PROJECT_REPOSITORY);
        PROJECT_UI = new ProjectUI(PROJECT_SERVICE);
        ORG_REPOSITORY = new OrgRepository();
        ORG_SERVICE = new OrgService(ORG_REPOSITORY);
        ORG_UI = new OrgUI(ORG_SERVICE);

        COLUMN_REPOSITORY =new ColumnRepository();
        COLUMN_SERVICE = new ColumnService(COLUMN_REPOSITORY);
        COLUMN_UI = new ColumnUI(COLUMN_SERVICE);

    }
    public  static  <T>T getBean(Class<T> bean){return  getBean(bean.getSimpleName().toUpperCase(Locale.ROOT));}

    public static <T> T getBean(String bean){
        bean = bean.toUpperCase(Locale.ROOT);
        return  switch (bean){
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;
            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case  "AUTHUI" -> (T) AUTH_UI;
            case "PROJECTREPOSITORY"->(T) PROJECT_REPOSITORY;
            case "PROJECTSERVICE" -> (T) PROJECT_SERVICE;
            case  "PROJECTUI" ->(T) PROJECT_UI;
            case "ORGREPOSITORY" -> (T) ORG_REPOSITORY;
            case "ORGSERVICE" -> (T) ORG_SERVICE;
            case "ORGUI" -> (T)ORG_UI;

            case "COLUMNREPOSITORY" -> (T)COLUMN_REPOSITORY;
            case "COLUMNSERVICE" -> (T)COLUMN_SERVICE;
            case "COLUMNUI" -> (T)COLUMN_UI;

            case "BASEUTILS"-> (T) BASE_UTILS;
            default -> throw new RuntimeException("Bean Not Found");
        };
    }
}

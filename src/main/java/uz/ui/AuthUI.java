package uz.ui;

import uz.dtos.auth.AuthUserCreateDto;
import uz.dtos.auth.AuthUserUpdateDto;
import uz.exeption.ApiRuntimeException;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.auth.AuthUserService;
import uz.services.projectList.ProjectList;

import static uz.security.SecurityHolder.session;
import static uz.utils.BaseUtils.gson;

/**
 * @author : Oyatjon  -> @data : 22:42
 */

public class AuthUI extends BaseUI<AuthUserService> {
    public AuthUI(AuthUserService service) {
        super(service);
    }

    public void login() {
        try {
            String username = Input.getStr("Username : ");
            String password = Input.getStr("Password : ");
            ResponseEntity<Data<Boolean>> response = service.login(username, password);
            Print.println(Color.GREEN, session.getFirstName() + " " + session.getLanguage());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }

    public void createUser() {
        try {

            AuthUserCreateDto dto = AuthUserCreateDto.childBuilder()
                    .username(Input.getStr("username(required)" + " >> "))
                    .password(Input.getStr("password(required)" + " >> "))
                    .phone(Input.getStr("phone(required)" + " >> "))
                    .email(Input.getStr("email(required)" + " >> "))
                    .firstName(Input.getStr("firstName(optional)" + " >> "))
                    .lastName(Input.getStr("lastName(optional)" + " >> "))
                    .language(Input.getStr("language(optional)" + " >> "))
                    .organizationId(Long.parseLong(Input.getStr("organizationId(required)" + " >> ") == "" ? String.valueOf(session.getOrganization().getId()) : Input.getStr("organizationId(required)" + " >> ")))
                    .build();
            ResponseEntity<Data<Long>> response = service.create(dto);
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }

    public void updateUser() {
        try {
            AuthUserUpdateDto dto = AuthUserUpdateDto.userUpdateBuilder()
                    .id(Long.parseLong(Input.getStr("id (optional)" + " >> ")))
                    .username(Input.getStr("username (optional)" + " >> "))
                    .password(Input.getStr("password (optional)" + " >> "))
                    .email(Input.getStr("email (optional)" + " >> "))
                    .phone(Input.getStr("phone(optional)" + " >> "))
                    .first_name(Input.getStr("first_name(optional)" + " >> "))
                    .last_name(Input.getStr("last_name(optional)" + " >> "))
                    .language(Input.getStr("language(optional)" + " >> "))
                    .build();
            ResponseEntity<Data<Long>> response = service.updateUser(dto);
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }


    public void projectList() {
        try {
            Long projectId = Long.valueOf((Input.getNum("Project_Id : ")));
            ResponseEntity<Data<ProjectList>> response = service.projectList(projectId, session.getId());
            String json = gson.toJson(response.getBody().getData());
            Print.println(Color.GREEN, json);
        } catch (ApiRuntimeException e) {

        }
    }
}

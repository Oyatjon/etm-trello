package uz.ui;

import uz.dtos.project.ProjectCreateDto;
import uz.exeption.ApiRuntimeException;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.project.ProjectService;

import static uz.security.SecurityHolder.session;

/**
 * @author : Oyatjon  -> @data : 02:52
 */


public class ProjectUI extends BaseUI<ProjectService> {
    public ProjectUI(ProjectService service) {
        super(service);
    }

    public void createProject() {
        try {
            ProjectCreateDto dto = ProjectCreateDto.projectBuilder()
                    .name(Input.getStr("name(required)" + " >> "))
                    .tz(Input.getStr("tz(optional)" + " >> "))
                    .background(Input.getStr("Background(optional)" + ">>"))
                    .description(Input.getStr("Description(optional)" + " >> "))
                    .organization_id(Long.parseLong(Input.getStr("organizationId(required)" + " >> ")))
                    //.organization_id(Long.parseLong(Input.getStr("organizationId(required)" + " >> ")=="" ? String.valueOf(session.getOrganization().getId()) : Input.getStr("organizationId(required)" + " >> ")))
                    .build();
            ResponseEntity<Data<Long>> response = service.create(dto);
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }


}

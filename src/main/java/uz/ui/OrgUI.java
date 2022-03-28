package uz.ui;

import uz.dtos.organization.OrgCreateDto;
import uz.dtos.organization.OrgUpdateDto;
import uz.exeption.ApiRuntimeException;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.org.OrgService;

/**
 * @author : Oyatjon  -> @data : 01:40
 */

public class OrgUI extends BaseUI<OrgService> {
    public OrgUI(OrgService service) {
        super(service);
    }


    public void createOrg() {
        try {
            OrgCreateDto dto = OrgCreateDto.orgBuild()
                    .name(Input.getStr("Name(required)" + " >> "))
                    .website(Input.getStr("website(required)" + " >> "))
                    .email(Input.getStr("email(required)" + " >> "))
                    .logo(Input.getStr("logo(optional)" + " >> "))
                    .build();
            ResponseEntity<Data<Long>> response = service.create(dto);
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }


    public void updateOrg() {
        try {
            OrgUpdateDto dto = OrgUpdateDto.orgUpdateBuilder()
                    .id(Long.parseLong(Input.getStr("id(optional)" + " >> ")))
                    .name(Input.getStr("name(optional)" + " >> "))
                    .website(Input.getStr("website(optional)" + " >> "))
                    .email(Input.getStr("email(optional)" + " >> "))
                    .logo(Input.getStr("logo(optional)" + " >> "))
                    .location(Input.getStr("location(optional)" + " >> "))
                    .build();
            ResponseEntity<Data<Boolean>> response = service.updateOrg(dto);
            Print.println(Color.GREEN, response.getBody().getData());

        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }

    public void blockOrg() {
        try {
            ResponseEntity<Data<?>> response = service.blockOrg(Input.getNum("org Id : "));
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }

    public void unblockOrg() {
        try {
            ResponseEntity<Data<?>> response = service.unBlockOrg(Input.getNum("Org Id : "));
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }

    public void deleteOrg() {
        try {
            ResponseEntity<Data<Boolean>> response = service.deleteOrg(Input.getNum("org Id : "));
            Print.println(Color.GREEN, response.getBody().getData());
        } catch (ApiRuntimeException e) {
            Print.println(Color.RED, e.getMessage());
        }
    }
}

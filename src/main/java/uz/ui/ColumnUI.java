package uz.ui;

import uz.dtos.column.ColumnCreateDto;
import uz.exeption.ApiRuntimeException;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;
import uz.response.Data;
import uz.response.ResponseEntity;
import uz.services.column.ColumnService;

/**
 * @author : Oyatjon  -> @data : 05:59
 */

public class ColumnUI extends BaseUI <ColumnService>{

    public ColumnUI(ColumnService service) {
        super(service);
    }


    public void createProjectColumn() {
        try {
            ColumnCreateDto dto =ColumnCreateDto.columnBuild()
                    .project_id(Long.parseLong(Input.getStr("project_id(required)")))
                    .name(Input.getStr("Name (required) >> "))
                    .order(Long.parseLong(Input.getStr("order(required) >> ")))
                    .emoji(Input.getStr("emoji (optional >> "))
                    .build();
            ResponseEntity<Data<Long>> response =service.create(dto);
            Print.println(Color.GREEN,response.getBody().getData());
        }catch (ApiRuntimeException e){
            Print.println(Color.RED,e.getMessage());
        }
    }
}

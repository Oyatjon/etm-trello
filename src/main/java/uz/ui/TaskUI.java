package uz.ui;

import uz.dtos.task.TaskCreateDto;
import uz.jl.utils.Input;
import uz.services.tasks.TaskService;


/**
 * @author : Oyatjon  -> @data : 12:01
 */

public class TaskUI extends BaseUI<TaskService>{
    public TaskUI(TaskService service) {
        super(service);
    }


    public void createTask() {
      /*  TaskCreateDto dto = TaskCreateDto.taskBuild()
        .name(Input.getStr("name (required)"))
        .description(Input.getStr("description(optional)"))
        .project_column_id(Long.parseLong(Input.getStr("project_column_id(required)")))
        .deadline(Input)
        .order()
        .level()
        .priority()*/

    }
}

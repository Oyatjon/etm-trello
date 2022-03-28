package uz.dtos.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;
import uz.ui.BaseUI;

/**
 * @author : Oyatjon  -> @data : 12:12
 */
@Getter
@Setter
@NoArgsConstructor
public class TaskCreateDto implements GenericBaseDto {
    private String name;
    private String description;
    private Long project_column_id;
    private String deadline;
    private Long order;
    private Long level;
    private Long priority;

    @Builder(builderMethodName = "taskBuild")
    public TaskCreateDto(String name, String description, Long project_column_id, String deadline, Long order, Long level, Long priority) {
        this.name = name;
        this.description = description;
        this.project_column_id = project_column_id;
        this.deadline = deadline;
        this.order = order;
        this.level = level;
        this.priority = priority;
    }
}

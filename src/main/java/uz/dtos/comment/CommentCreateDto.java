package uz.dtos.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;

/**
 * @author : Oyatjon  -> @data : 03:23
 */
@Getter
@Setter
@NoArgsConstructor
public class CommentCreateDto implements GenericBaseDto {
   private String   message;
    private  Long  type    ;
    private  Long  task_id ;
@Builder(builderMethodName = "commentBuild")
    public CommentCreateDto(String message, Long type, Long task_id) {
        this.message = message;
        this.type = type;
        this.task_id = task_id;
    }
}

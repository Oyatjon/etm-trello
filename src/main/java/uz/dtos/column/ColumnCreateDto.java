package uz.dtos.column;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;

/**
 * @author : Oyatjon  -> @data : 06:06
 */
@Getter
@Setter
@NoArgsConstructor
public class ColumnCreateDto implements GenericBaseDto {
    private String name    ;

    private Long project_id;

    private String emoji   ;
    private Long order;

@Builder(builderMethodName =  "columnBuild")
    public ColumnCreateDto(String name, Long project_id, String emoji, Long order) {
        this.name = name;
        this.project_id = project_id;
        this.emoji = emoji;
        this.order = order;
    }
}

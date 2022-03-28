package uz.dtos.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;
import uz.security.SecurityHolder;

/**
 * @author : Oyatjon  -> @data : 02:53
 */
@Getter
@Setter
@NoArgsConstructor
public class ProjectCreateDto implements GenericBaseDto {
  private String  name  ;
  private String  tz ;
  private String  description  ;
   private String background;
   private Long organization_id ;

   @Builder(builderMethodName = "projectBuilder")
    public ProjectCreateDto(String name, String tz, String description, String background, Long organization_id) {
        this.name = name.length() ==0 ? null : name;
        this.tz = tz.length() ==0 ? null : tz;
        this.description = description.length() ==0 ? null : description;
        this.background = background.length() ==0 ? null : background;
        this.organization_id = organization_id;
      // this.organization_id = organization_id == null ? SecurityHolder.session.getOrganization().getId() : organization_id;

   }
}

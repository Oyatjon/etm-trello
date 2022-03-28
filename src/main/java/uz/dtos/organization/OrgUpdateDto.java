package uz.dtos.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;

/**
 * @author : Oyatjon  -> @data : 22:35
 */
@Getter
@Setter
@NoArgsConstructor
public class OrgUpdateDto implements GenericBaseDto {
    private Long id;
    private String name;
    private String website;
    private String email;
    private String logo;
    private String location;
@Builder (builderMethodName = "orgUpdateBuilder")
    public OrgUpdateDto(Long id, String name, String website, String email, String logo, String location) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.email = email;
        this.logo = logo;
        this.location = location;
    }
}

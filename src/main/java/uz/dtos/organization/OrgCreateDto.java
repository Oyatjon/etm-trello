package uz.dtos.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;
import uz.security.SecurityHolder;

/**
 * @author : Oyatjon  -> @data : 01:45
 */
@Getter
@Setter
@NoArgsConstructor
public class OrgCreateDto implements GenericBaseDto {
    private String name;
    private String website;
    private String email;
    private String logo;


    @Builder(builderMethodName = "orgBuild")
    public OrgCreateDto(String name, String website, String email, String logo, String created_by) {
        this.name = name;
        this.website = website;
        this.email = email;
        this.logo = logo;

    }
}

package uz.dtos.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;
import uz.security.SecurityHolder;

/**
 * @author : Oyatjon  -> @data : 00:42
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthUserCreateDto implements GenericBaseDto {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String firstName;
    private String lastName;
    private Long organizationId;
    private String language;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserCreateDto(String username, String password, String phone, String email, String firstName, String lastName, Long organizationId, String language) {
        this.username = username.length() == 0 ? null : username;
        this.password = password.length() == 0 ? null : password;
        this.phone = phone.length() == 0 ? null : phone;
        this.email = email.length() == 0 ? null : email;
        this.firstName = firstName.length() == 0 ? null : firstName;
        this.lastName = lastName.length() == 0 ? null : lastName;
        this.organizationId = organizationId == null ? SecurityHolder.session.getOrganization().getId() : organizationId;
        this.language = language.length() == 0 ? null : language;
    }
}

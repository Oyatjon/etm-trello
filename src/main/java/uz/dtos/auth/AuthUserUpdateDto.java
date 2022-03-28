package uz.dtos.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.dtos.GenericBaseDto;

/**
 * @author : Oyatjon  -> @data : 20:18
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthUserUpdateDto implements GenericBaseDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String first_name;
    private String last_name;
    private String language;
 @Builder(builderMethodName = "userUpdateBuilder")
    public AuthUserUpdateDto(Long id, String username, String password, String email, String phone, String first_name, String last_name, String language) {
        this.id = id ;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.first_name = first_name;
        this.last_name = last_name;
        this.language = language;
    }
}

package ad.ya.contacts.auth;

import ad.ya.contacts.generic.BaseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class AuthResponse {
    private UserDto user;
    private String token;

    @Data
    @Accessors(chain = true)
    public static class UserDto extends BaseDto {
        private String pseudo;
        private String email;
        private String role;
    }
}

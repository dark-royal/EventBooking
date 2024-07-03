package africa.semicolon.eventbookingapp.dtos.requests;

import africa.semicolon.eventbookingapp.data.models.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {

    private String email;
    private String name;
    private String password;
    private Role role;

}

package africa.semicolon.eventbookingapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterOrganizerResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private boolean registerStatus;
    private String message;
}

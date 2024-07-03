package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.data.models.Role;
import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.eventbookingapp.data.models.Role.EVENT_ORGANIZER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void testThatOrganizerCanRegister(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("praiseoyewole560@gmail.com");
        registerUserRequest.setName("praise");
        registerUserRequest.setRole(EVENT_ORGANIZER);
        registerUserRequest.setPassword("mypassword");

        RegisterUserResponse response = userService.register(registerUserRequest);
        assertThat(response.getMessage()).contains("user registered successfully");
        assertNotNull(response);
    }
}

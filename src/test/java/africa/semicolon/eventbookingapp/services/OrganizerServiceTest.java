package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.dtos.requests.AddTicketRequest;
import africa.semicolon.eventbookingapp.dtos.requests.CreateEventRequest;
import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.AddTicketResponse;
import africa.semicolon.eventbookingapp.dtos.responses.CreateEventResponse;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterOrganizerResponse;
import africa.semicolon.eventbookingapp.exceptions.OrganizerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static africa.semicolon.eventbookingapp.data.models.Role.EVENT_ORGANIZER;
import static africa.semicolon.eventbookingapp.data.models.TicketCategory.VIP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class OrganizerServiceTest {
    @Autowired
    private OrganizerService organizerService;
    @Test
    public void testThatOrganizerCanRegister(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("praiseoyewole5600@gmail.com");
        registerUserRequest.setName("dayo");
        registerUserRequest.setRole(EVENT_ORGANIZER);
        registerUserRequest.setPassword("mypassword");

        RegisterOrganizerResponse response = organizerService.register(registerUserRequest);
        assertThat(response.getMessage()).contains("organizer registered successfully");
        assertNotNull(response);
    }

    @Test
    public void createEvent(){
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setName("Wedding ceremony");
        createEventRequest.setDescription("Aramide & Orisha");
        createEventRequest.setLocation("victoria island");
        createEventRequest.setOrganizerId(1L);
        CreateEventResponse response = organizerService.createEvent(createEventRequest);
        response.setTitle(createEventRequest.getName());
        response.setDescription(createEventRequest.getDescription());
        response.setLocation(createEventRequest.getLocation());
        response.setOrganizerId(createEventRequest.getOrganizerId());
        assertThat(response.getMessage()).contains("Event created successfully");
        assertNotNull(response);
    }

    @Test
    public void testThatWrongOrganizerIdIsPasses_ThrowOrganizerNotFound(){
        CreateEventRequest createEventRequest = new CreateEventRequest();
        createEventRequest.setName("Wedding ceremony");
        createEventRequest.setDescription("Aramide & Orisha");
        createEventRequest.setLocation("victoria island");
        createEventRequest.setOrganizerId(3L);
        assertThrows(OrganizerNotFoundException.class,()->organizerService.createEvent(createEventRequest));
    }

    @Test
    public void addTicketToEvent(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("praiseoyewole560@gmail.com");
        registerUserRequest.setName("dayo");
        registerUserRequest.setRole(EVENT_ORGANIZER);
        registerUserRequest.setPassword("mypassword");

        organizerService.register(registerUserRequest);

        AddTicketRequest addTicketRequest = new AddTicketRequest();
        addTicketRequest.setTitle("wedding");
        addTicketRequest.setVenueName("falz hall");
        addTicketRequest.setDescription("golden ticket");
        addTicketRequest.setOrganizerId(1L);
        addTicketRequest.setPrice(BigDecimal.valueOf(20000));
        addTicketRequest.setCategory(VIP);
        AddTicketResponse addTicketResponse = organizerService.addTicketToEvent(addTicketRequest);
        assertThat(addTicketResponse).isNotNull();
        assertThat(addTicketResponse.getMessage()).contains("Ticket added to event successfully");

    }
}

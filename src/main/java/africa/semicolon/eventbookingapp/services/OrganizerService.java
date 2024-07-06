package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.data.models.Event;
import africa.semicolon.eventbookingapp.data.models.Organizer;
import africa.semicolon.eventbookingapp.dtos.requests.AddTicketRequest;
import africa.semicolon.eventbookingapp.dtos.requests.CreateEventRequest;
import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.AddTicketResponse;
import africa.semicolon.eventbookingapp.dtos.responses.CreateEventResponse;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterOrganizerResponse;

public interface OrganizerService {

    RegisterOrganizerResponse register(RegisterUserRequest request);

    CreateEventResponse createEvent(CreateEventRequest createEventRequest);

    Organizer findOrganizerById(Long id);


    AddTicketResponse addTicketToEvent(AddTicketRequest addTicketRequest);
}

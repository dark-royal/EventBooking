package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);

//    CreateEventResponse createEvent(CreateEventRequest createEventRequest);
}

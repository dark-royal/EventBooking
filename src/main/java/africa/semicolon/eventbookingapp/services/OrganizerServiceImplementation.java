package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.data.models.Event;
import africa.semicolon.eventbookingapp.data.models.Organizer;
import africa.semicolon.eventbookingapp.data.models.Ticket;
import africa.semicolon.eventbookingapp.data.repositories.EventRepository;
import africa.semicolon.eventbookingapp.data.repositories.OrganizerRepository;
import africa.semicolon.eventbookingapp.data.repositories.TicketRepository;
import africa.semicolon.eventbookingapp.dtos.requests.AddTicketRequest;
import africa.semicolon.eventbookingapp.dtos.requests.CreateEventRequest;
import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.AddTicketResponse;
import africa.semicolon.eventbookingapp.dtos.responses.CreateEventResponse;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterOrganizerResponse;
import africa.semicolon.eventbookingapp.exceptions.EventNotFoundException;
import africa.semicolon.eventbookingapp.exceptions.OrganizerExistException;
import africa.semicolon.eventbookingapp.exceptions.OrganizerNotCreateEventException;
import africa.semicolon.eventbookingapp.exceptions.OrganizerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.eventbookingapp.data.models.Role.EVENT_ORGANIZER;

@Service
public class OrganizerServiceImplementation implements OrganizerService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EventRepository eventRepository;
    @Override
    public RegisterOrganizerResponse register(RegisterUserRequest request) {
        validateOrganizerRegistration(request.getEmail());
        Organizer organizer = modelMapper.map(request, Organizer.class);
        organizer.setPassword(encoder.encode(request.getPassword()));
        organizer = organizerRepository.save(organizer);
        var response = modelMapper.map(organizer, RegisterOrganizerResponse.class);
        response.setMessage("organizer registered successfully");
        return response;
    }

    @Override
    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
            try {
                Organizer organizer = findOrganizerById(createEventRequest.getOrganizerId());
                Event event = modelMapper.map(createEventRequest, Event.class);
                event.setOrganizerId(organizer.getId());
                event = eventRepository.save(event);
                CreateEventResponse response = modelMapper.map(event, CreateEventResponse.class);

                response.setMessage("Event created successfully");
                return response;
            } catch (Exception e) {
                throw new OrganizerNotFoundException(e.getMessage());
            }

        }

    @Override
    public Organizer findOrganizerById(Long id) {
        return organizerRepository.findById(id).orElseThrow(()-> new OrganizerNotFoundException("Organizer not found"));
    }


    @Override
    public AddTicketResponse addTicketToEvent(AddTicketRequest addTicketRequest) {
        Event event = eventRepository.findById(addTicketRequest.getEventId()).orElseThrow(()-> new EventNotFoundException("event not found"));
        Ticket ticket = modelMapper.map(addTicketRequest, Ticket.class);
        ticket.setId(event.getId());
        ticket = ticketRepository.save(ticket);
        AddTicketResponse addTicketResponse = modelMapper.map(ticket, AddTicketResponse.class);
        addTicketResponse.setMessage("ticket added to event successfully");
        return addTicketResponse;

    }


// public AddCommentResponse comment(AddCommentRequest addCommentRequest, Long mediaId) {
//        try {
//            User user = userService.getById(addCommentRequest.getUserId());
//            Media media = mediaService.getMediaBy(mediaId);
//            Comment comment = modelMapper.map(addCommentRequest,Comment.class);
//            comment.setMedia(media);
//            comment = commentRepository.save(comment);
//            UserResponse response= modelMapper.map(user,UserResponse.class);
//            AddCommentResponse addCommentResponse = modelMapper.map(comment,AddCommentResponse.class);
//            addCommentResponse.setUserResponse(response);



    private void validateOrganizerRegistration(String email){
        Optional<Organizer> organizer = organizerRepository.findOrganizerByEmail(email);
        if (organizer.isPresent()) throw new OrganizerExistException(String.format("%s already exist", email));
    }


    }


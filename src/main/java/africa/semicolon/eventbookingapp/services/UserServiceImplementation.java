//package africa.semicolon.eventbookingapp.services;
//
//import africa.semicolon.eventbookingapp.data.models.Event;
//import africa.semicolon.eventbookingapp.data.models.Organizer;
//import africa.semicolon.eventbookingapp.data.models.Ticket;
//import africa.semicolon.eventbookingapp.data.models.User;
//import africa.semicolon.eventbookingapp.data.repositories.EventRepository;
//import africa.semicolon.eventbookingapp.data.repositories.TicketRepository;
//import africa.semicolon.eventbookingapp.data.repositories.UserRepository;
//import africa.semicolon.eventbookingapp.dtos.requests.AddTicketRequest;
//import africa.semicolon.eventbookingapp.dtos.requests.CreateEventRequest;
//import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
//import africa.semicolon.eventbookingapp.dtos.responses.AddTicketResponse;
//import africa.semicolon.eventbookingapp.dtos.responses.CreateEventResponse;
//import africa.semicolon.eventbookingapp.dtos.responses.RegisterOrganizerResponse;
//import africa.semicolon.eventbookingapp.exceptions.*;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//import static africa.semicolon.eventbookingapp.data.models.Role.EVENT_ORGANIZER;
//
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class UserServiceImplementation implements UserService {
//
//    private ModelMapper modelMapper;
//    private UserRepository userRepository;
//    private TicketRepository ticketRepository;
//    private PasswordEncoder encoder;
//
//    private EventRepository eventRepository;
//
//
//    @Override
//    public RegisterOrganizerResponse register(RegisterUserRequest request) {
//        User user = modelMapper.map(request, User.class);
//        user.setPassword(encoder.encode(request.getPassword()));
//        user.setRole(request.getRole());
//
//        log.info("User: {}", user);
//
//        User savedUser = userRepository.save(user);
//        log.info("User: {}", savedUser);
//
//        var response = modelMapper.map(savedUser, RegisterOrganizerResponse.class);
//        response.setMessage("organizer registered successfully");
//        return response;
//    }
//
//    @Override
//    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
//        try {
//            User user = findOrganizerById(createEventRequest.getOrganizerId());
//            validateEvent(createEventRequest.getOrganizerId());
//            Event event = modelMapper.map(createEventRequest, Event.class);
//
//            event = eventRepository.save(event);
//            CreateEventResponse response = modelMapper.map(event, CreateEventResponse.class);
//            response.setMessage("Event created successfully");
//            return response;
//        } catch (Exception e) {
//            throw new OrganizerNotFoundException(e.getMessage());
//        }
//
//
//    }
//
//    @Override
//    public User findOrganizerById(Long id) {
//        return userRepository.findById(id).orElseThrow(()-> new OrganizerNotFoundException("organizer not found"));
//    }
//    @Override
//    public Event findEventById(Long id){
//        return eventRepository.findById(id).orElseThrow(()->new EventNotFoundException("Event Not Found"));
//    }
//
//
//
//    @Override
//    public AddTicketResponse addTicketToEvent(AddTicketRequest addTicketRequest) {
//        //System.out.println(userRepository.count());
//            User user = userRepository.findById(addTicketRequest.getOrganizerId()).orElseThrow(()->new OrganizerNotFoundException("organizer not found"));
//            Event event = findEventById(addTicketRequest.getEventId());
//            validateAddTicket(addTicketRequest.getOrganizerId());
//            Ticket ticket = modelMapper.map(addTicketRequest, Ticket.class);
//            ticket.setId(event.getId());
//            ticket.setUser(user);
//            ticket = ticketRepository.save(ticket);
//            AddTicketResponse addTicketResponse = modelMapper.map(ticket, AddTicketResponse.class);
//            addTicketResponse.setMessage("ticket added to event successfully");
//            return addTicketResponse;
//
//
//
//
//    }
//
//    private void validateEvent(Long id){
//        User user = userRepository.findById(id).orElseThrow(()->new OrganizerNotFoundException("rtyuio"));
//        if(user.getRole() != EVENT_ORGANIZER)throw new OrganizerNotCreateEventException("Event have to be created by the organizer");
//
//
//        }
//
//
//    private void validateAddTicket(Long id){
//        User user = userRepository.findById(id).orElseThrow(()->new OrganizerNotFoundException("organizer not found"));
//        if(user.getRole() != EVENT_ORGANIZER)throw new AddTicketException("Ticket have to be added by and organizer");
//
//
//    }
//
//    private void validateOrganizerRegistration(String email){
//        Optional<Organizer> organizer = userRepository.findOrganizerByEmail(email);
//        if (organizer.isPresent()) throw new OrganizerExistException(String.format("%s already exist", email));
//    }
//    }
//    //            UserResponse response= modelMapper.map(user,UserResponse.class);
//    //            AddCommentResponse addCommentResponse = modelMapper.map(comment,AddCommentResponse.class);
//    //            addCommentResponse.setUserResponse(response);
//    //
//    //            return addCommentResponse;
//    //        } catch (UserNotFoundException e) {
//    //            throw new RuntimeException(e);
//    //        }
//
///
//

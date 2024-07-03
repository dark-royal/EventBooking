package africa.semicolon.eventbookingapp.services;

import africa.semicolon.eventbookingapp.data.models.Role;
import africa.semicolon.eventbookingapp.data.models.User;
import africa.semicolon.eventbookingapp.data.repositories.UserRepository;
import africa.semicolon.eventbookingapp.dtos.requests.RegisterUserRequest;
import africa.semicolon.eventbookingapp.dtos.responses.RegisterUserResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static africa.semicolon.eventbookingapp.data.models.Role.EVENT_ORGANIZER;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        User user = modelMapper.map(request,User.class);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(EVENT_ORGANIZER);
        user = userRepository.save(user);
        var response = modelMapper.map(user, RegisterUserResponse.class);
        response.setMessage("organizer registered successfully");
        return null;
    }
}
//  @Override
//    public CreateUserResponse register(CreateUserRequest request) {
//        User user = modelMapper.map(request, User.class);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        user.setAuthorities(new HashSet<>());
//        var authorities = user.getAuthorities();
//        authorities.add(Authority.USER);
//        user = userRepository.save(user);
//        var response = modelMapper.map(user, CreateUserResponse.class);
//        response.setMessage("user registered successfully");
//        return response;
//    }
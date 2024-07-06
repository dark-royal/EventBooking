package africa.semicolon.eventbookingapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class CreateEventRequest {

    private String name;
    private String description;
    private String location;
    private LocalDateTime eventDateAndTime;
    private Long organizerId;
}

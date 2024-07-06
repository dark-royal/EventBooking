package africa.semicolon.eventbookingapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class CreateEventResponse {
    private String title;
    private String description;
    private LocalDateTime eventDateAndTime;
    private Long organizerId;
    private String location;
    private String message;
}

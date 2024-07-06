package africa.semicolon.eventbookingapp.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AddTicketResponse {
    private String title;
    private String description;
    private LocalDateTime ticketDateAndTime;
    private  String venueName;
    private String message;
    private Long organizerId;
}

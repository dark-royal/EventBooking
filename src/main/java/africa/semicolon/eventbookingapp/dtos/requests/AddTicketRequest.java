package africa.semicolon.eventbookingapp.dtos.requests;

import africa.semicolon.eventbookingapp.data.models.TicketCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
public class AddTicketRequest {
    private String title;
    private String description;
    private Long organizerId;
    private Long eventId;
    private String venueName;
    private TicketCategory category;
    private BigDecimal price;
    private LocalDateTime eventDateAndTime;
}

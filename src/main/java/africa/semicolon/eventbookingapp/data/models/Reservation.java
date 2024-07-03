package africa.semicolon.eventbookingapp.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
public class Reservation {

    @Id

    private Long id;
    private Long attendeeId;
    private Long ticketId;
    private LocalDateTime reservationDateAndTime;
    private Boolean reservationStatus;

    @PrePersist
    private void setReservationDateAndTime(){
        reservationDateAndTime = now();
    }
}

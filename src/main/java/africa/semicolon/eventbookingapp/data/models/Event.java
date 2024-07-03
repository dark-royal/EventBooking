package africa.semicolon.eventbookingapp.data.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
public class Event {
    private Long id;
    private String name;
    private String description;
    @JsonDeserialize(using= LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Setter(AccessLevel.NONE)
    private LocalDateTime eventDateAndTime;

    private String location;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizerId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User attendees;
    @ManyToOne(fetch = FetchType.EAGER)
    private Ticket tickets;


    @PrePersist
    private void setEventDateAndTime(){
        eventDateAndTime = now();
    }
}






package africa.semicolon.eventbookingapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Entity
@Setter
@Getter
@Table(name = "organizers")
public class Organizer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Event> eventList;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Attendees> attendeesList;


}

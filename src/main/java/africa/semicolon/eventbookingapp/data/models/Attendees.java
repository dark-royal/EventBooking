package africa.semicolon.eventbookingapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table
public class Attendees{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    private List<Reservation> reservations;
}

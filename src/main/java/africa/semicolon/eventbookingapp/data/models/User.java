package africa.semicolon.eventbookingapp.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Setter
@Getter
@Table(name = "users")
public class User {

    private String name;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(value = STRING)
    private Role role;
    @Id
    private Long id;




}

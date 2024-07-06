package africa.semicolon.eventbookingapp.data.repositories;

import africa.semicolon.eventbookingapp.data.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer,Long> {

    Optional<Organizer> findOrganizerByEmail(String email);
}

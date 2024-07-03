package africa.semicolon.eventbookingapp.data.repositories;

import africa.semicolon.eventbookingapp.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

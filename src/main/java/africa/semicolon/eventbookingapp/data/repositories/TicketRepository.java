package africa.semicolon.eventbookingapp.data.repositories;

import africa.semicolon.eventbookingapp.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}

package africa.semicolon.eventbookingapp.data.repositories;

import africa.semicolon.eventbookingapp.data.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}

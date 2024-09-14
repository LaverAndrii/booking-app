package nulp.practice.bookingapp.repository.accommodation;

import nulp.practice.bookingapp.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}

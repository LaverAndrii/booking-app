package nulp.practice.bookingapp.repository.booking;

import java.util.List;
import nulp.practice.bookingapp.model.Booking;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByUserId(Long id);

    List<Booking> findAll(Specification<Booking> spec);
}

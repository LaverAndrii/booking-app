package nulp.practice.bookingapp.repository.user;

import java.util.Optional;
import nulp.practice.bookingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

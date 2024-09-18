package nulp.practice.bookingapp.repository.role;

import java.util.Optional;
import nulp.practice.bookingapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Role.RoleName roleName);
}

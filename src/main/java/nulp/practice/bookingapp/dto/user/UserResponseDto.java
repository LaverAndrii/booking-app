package nulp.practice.bookingapp.dto.user;

import lombok.Data;
import nulp.practice.bookingapp.model.Role;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role.RoleName role;
}

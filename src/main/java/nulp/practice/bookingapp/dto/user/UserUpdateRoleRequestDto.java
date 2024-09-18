package nulp.practice.bookingapp.dto.user;

import jakarta.validation.constraints.NotNull;
import nulp.practice.bookingapp.model.Role;

public record UserUpdateRoleRequestDto(@NotNull Role.RoleName role) {
}

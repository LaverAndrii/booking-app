package nulp.practice.bookingapp.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(
        @NotBlank(message = "Email should be valid")
        @Size(max = 20)
        @Email
        String email,
        @NotBlank(message = "Password should be valid")
        @Size(min = 4, max = 20)
        String password) {
}

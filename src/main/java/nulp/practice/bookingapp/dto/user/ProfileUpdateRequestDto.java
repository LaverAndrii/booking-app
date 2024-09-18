package nulp.practice.bookingapp.dto.user;

import jakarta.validation.constraints.NotBlank;

public record ProfileUpdateRequestDto(
        @NotBlank(message = "may not be blank") String firstName,
        @NotBlank(message = "may not be blank") String lastName) {
}

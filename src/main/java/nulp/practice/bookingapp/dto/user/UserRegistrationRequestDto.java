package nulp.practice.bookingapp.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import nulp.practice.bookingapp.validation.Email;
import nulp.practice.bookingapp.validation.FieldMatch;

@FieldMatch(first = "password", second = "repeatPassword")
@Data
public class UserRegistrationRequestDto {
    @Email
    @NotBlank
    @Size(max = 20)
    private String email;
    @NotBlank
    @Size(min = 4, max = 20)
    private String password;
    @NotBlank
    @Size(min = 4, max = 20)
    private String repeatPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}

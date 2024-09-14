package nulp.practice.bookingapp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.user.UserLoginRequestDto;
import nulp.practice.bookingapp.dto.user.UserLoginResponseDto;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.security.AuthenticationService;
import nulp.practice.bookingapp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register") //Allows users to register a new account.
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        return userService.register(requestDto);
    }

    @PostMapping("/login") //Grants JWT tokens to authenticated users.
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

}

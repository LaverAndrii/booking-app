package nulp.practice.bookingapp.service;

import nulp.practice.bookingapp.dto.user.ProfileUpdateRequestDto;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto getProfile(String email);

    void updateRole();

    UserResponseDto updateProfile(String userEmail, ProfileUpdateRequestDto requestDto);

    UserResponseDto register(UserRegistrationRequestDto requestDto);
}

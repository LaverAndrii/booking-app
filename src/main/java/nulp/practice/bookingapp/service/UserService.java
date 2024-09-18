package nulp.practice.bookingapp.service;

import nulp.practice.bookingapp.dto.user.ProfileUpdateRequestDto;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.dto.user.UserUpdateRoleRequestDto;

public interface UserService {
    UserResponseDto getProfile(String email);

    UserResponseDto updateRole(Long id, UserUpdateRoleRequestDto userUpdateRoleRequestDto);

    UserResponseDto updateProfile(String userEmail, ProfileUpdateRequestDto requestDto);

    UserResponseDto register(UserRegistrationRequestDto requestDto);
}

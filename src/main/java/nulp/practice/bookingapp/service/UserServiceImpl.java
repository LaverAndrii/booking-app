package nulp.practice.bookingapp.service;

import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.user.ProfileUpdateRequestDto;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.mapper.UserMapper;
import nulp.practice.bookingapp.model.User;
import nulp.practice.bookingapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto getProfile(String email) {
        return userMapper.toDto(userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Can't find accommodation by email " + email))
        );
    }

    @Override
    public void updateRole() {

    }

    @Override
    public UserResponseDto updateProfile(String email, ProfileUpdateRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Can't find accommodation by email " + email)
        );
        user.setFirstName(requestDto.firstName());
        user.setLastName(requestDto.lastName());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RuntimeException("The user with this email is already exist "
                    + requestDto.getEmail()); //RegistrationException
        }

        User user = userMapper.toModel(requestDto);
        user.setRole(User.Role.CUSTOMER);
        return userMapper.toDto(userRepository.save(user));
    }
}

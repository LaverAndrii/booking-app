package nulp.practice.bookingapp.service;

import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.user.ProfileUpdateRequestDto;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.dto.user.UserUpdateRoleRequestDto;
import nulp.practice.bookingapp.mapper.UserMapper;
import nulp.practice.bookingapp.model.Role;
import nulp.practice.bookingapp.model.User;
import nulp.practice.bookingapp.repository.role.RoleRepository;
import nulp.practice.bookingapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto getProfile(String email) {
        return userMapper.toDto(userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Can't find user by email " + email))
        );
    }

    @Override
    public UserResponseDto updateRole(Long id, UserUpdateRoleRequestDto userUpdateRoleRequestDto) {
        Role role = roleRepository.findByName(userUpdateRoleRequestDto.role())
                .orElseThrow(() -> new RuntimeException(
                        "There is no such role: " + userUpdateRoleRequestDto.role()));
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can't find user by id " + id));
        user.setRole(role);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponseDto updateProfile(String email, ProfileUpdateRequestDto requestDto) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Can't find user by email " + email)
        );
        user.setFirstName(requestDto.firstName());
        user.setLastName(requestDto.lastName());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RuntimeException("The user with this email is already exist "
                    + requestDto.getEmail()); //RegistrationException
        }

        User user = userMapper.toModel(requestDto);
        user.setRole(getRoleUser());
        return userMapper.toDto(userRepository.save(user));
    }

    private Role getRoleUser() {
        return roleRepository.findByName(Role.RoleName.CUSTOMER)
                .orElseThrow(() -> new RuntimeException("User role not found"));
    }
}

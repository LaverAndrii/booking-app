package nulp.practice.bookingapp.mapper;

import nulp.practice.bookingapp.config.MapperConfig;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, uses = PasswordEncoderMapper.class)
public interface UserMapper {
    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User toModel(UserRegistrationRequestDto requestDto);

    @Mapping(target = "role", ignore = true)
    UserResponseDto toDto(User user);

    @AfterMapping
    default void setRole(@MappingTarget UserResponseDto userResponseDto, User user) {
        userResponseDto.setRole(user.getRole().getName());
    }
}

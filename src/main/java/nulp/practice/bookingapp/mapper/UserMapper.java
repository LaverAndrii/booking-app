package nulp.practice.bookingapp.mapper;

import nulp.practice.bookingapp.config.MapperConfig;
import nulp.practice.bookingapp.dto.user.UserRegistrationRequestDto;
import nulp.practice.bookingapp.dto.user.UserResponseDto;
import nulp.practice.bookingapp.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = PasswordEncoderMapper.class)
public interface UserMapper {
    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User toModel(UserRegistrationRequestDto requestDto);

    UserResponseDto toDto(User user);
}

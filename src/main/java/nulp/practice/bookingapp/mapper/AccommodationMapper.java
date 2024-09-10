package nulp.practice.bookingapp.mapper;

import nulp.practice.bookingapp.config.MapperConfig;
import nulp.practice.bookingapp.dto.accommodation.AccommodationDto;
import nulp.practice.bookingapp.dto.accommodation.AddAccommodationDto;
import nulp.practice.bookingapp.model.Accommodation;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface AccommodationMapper {
    Accommodation toModel(AddAccommodationDto addAccommDto);

    AccommodationDto toDto(Accommodation accommodation);
}

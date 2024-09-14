package nulp.practice.bookingapp.mapper;

import nulp.practice.bookingapp.config.MapperConfig;
import nulp.practice.bookingapp.dto.booking.BookAccommodationDto;
import nulp.practice.bookingapp.dto.booking.BookingDto;
import nulp.practice.bookingapp.model.Booking;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookingMapper {
    BookingDto toDto(Booking booking);

    Booking toModel(BookAccommodationDto bookAccommodationDto);
}

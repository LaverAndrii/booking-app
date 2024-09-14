package nulp.practice.bookingapp.service;

import java.util.List;
import nulp.practice.bookingapp.dto.booking.BookAccommodationDto;
import nulp.practice.bookingapp.dto.booking.BookingDto;
import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import nulp.practice.bookingapp.dto.booking.UpdateBookingDto;

public interface BookingService {
    BookingDto create(String email, BookAccommodationDto bookAccommodationDto);

    List<BookingDto> getBookingsByEmail(String email);

    BookingDto getBookingById(Long id);

    BookingDto cancel(Long id);

    List<BookingDto> getBookingsByParams(BookingSearchParametersDto searchParamsDto);

    BookingDto update(Long id, UpdateBookingDto updateBookingDto);
}

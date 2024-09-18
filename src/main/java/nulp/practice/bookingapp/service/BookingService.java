package nulp.practice.bookingapp.service;

import java.util.List;
import nulp.practice.bookingapp.dto.booking.BookAccommodationDto;
import nulp.practice.bookingapp.dto.booking.BookingDto;
import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import nulp.practice.bookingapp.dto.booking.UpdateBookingDto;

public interface BookingService {
    BookingDto create(String email, BookAccommodationDto bookAccommodationDto);

    List<BookingDto> getBookingsByEmail(String email);

    BookingDto getBookingById(Long id, String email);

    BookingDto cancel(Long id, String email);

    List<BookingDto> getBookingsByParams(BookingSearchParametersDto searchParamsDto);

    BookingDto update(Long id, UpdateBookingDto updateBookingDto, String email);
}

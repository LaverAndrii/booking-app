package nulp.practice.bookingapp.dto.booking;

import nulp.practice.bookingapp.model.Booking;

public record BookingSearchParametersDto(Long userId, Booking.Status status) {
}

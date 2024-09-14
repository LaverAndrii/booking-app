package nulp.practice.bookingapp.dto.booking;

import java.time.LocalDate;

public record UpdateBookingDto(LocalDate checkInDate, LocalDate checkOutDate) {
}

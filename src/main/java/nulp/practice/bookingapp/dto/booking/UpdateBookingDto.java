package nulp.practice.bookingapp.dto.booking;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record UpdateBookingDto(@NotNull @FutureOrPresent LocalDate checkInDate,
                               @NotNull @Future LocalDate checkOutDate) {
}

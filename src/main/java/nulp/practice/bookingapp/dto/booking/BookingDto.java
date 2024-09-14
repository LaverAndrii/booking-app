package nulp.practice.bookingapp.dto.booking;

import java.time.LocalDate;
import lombok.Data;
import nulp.practice.bookingapp.model.Booking;

@Data
public class BookingDto {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long accommodationId;
    private Long userId;
    private Booking.Status status;
}

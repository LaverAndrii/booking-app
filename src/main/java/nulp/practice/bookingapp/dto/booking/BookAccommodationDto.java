package nulp.practice.bookingapp.dto.booking;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BookAccommodationDto {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Long accommodationId;
}

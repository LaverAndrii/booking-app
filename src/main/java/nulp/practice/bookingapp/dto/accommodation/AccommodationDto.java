package nulp.practice.bookingapp.dto.accommodation;

import java.math.BigDecimal;
import lombok.Data;
import nulp.practice.bookingapp.model.Accommodation;

@Data
public class AccommodationDto {
    private Long id;
    private Accommodation.Type type;
    private String location; // type Address ?
    private String size;
    private String[] amenities;
    private BigDecimal dailyRate;
    private Integer availability;
}

package nulp.practice.bookingapp.dto;

import java.math.BigDecimal;
import lombok.Data;
import nulp.practice.bookingapp.model.Accommodation;

@Data
public class AddAccommodationDto {
    private Accommodation.AccommodationType type;
    private String location; // type Address ?
    private String size;
    private String[] amenities;
    private BigDecimal dailyRate;
    private Integer availability;
}

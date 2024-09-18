package nulp.practice.bookingapp.dto.accommodation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;
import nulp.practice.bookingapp.model.Accommodation;

@Data
public class AddAccommodationDto {
    @NotNull
    private Accommodation.Type type;
    @NotBlank(message = "may not be blank")
    private String location; // type Address ?
    @NotBlank(message = "may not be blank")
    private String size;
    @NotNull
    private String[] amenities;
    @NotNull
    @Min(0)
    private BigDecimal dailyRate;
    @NotNull
    @Min(0)
    private Integer availability;
}

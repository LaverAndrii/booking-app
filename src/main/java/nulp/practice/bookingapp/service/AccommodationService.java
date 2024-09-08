package nulp.practice.bookingapp.service;

import java.util.List;
import nulp.practice.bookingapp.dto.AccommodationDto;
import nulp.practice.bookingapp.dto.AddAccommodationDto;

public interface AccommodationService {
    AccommodationDto add(AddAccommodationDto addAccommDto);

    List<AccommodationDto> getAll();

    AccommodationDto getById(Long id);

    AccommodationDto updateById(Long id, AddAccommodationDto addAccommDto);

    void deleteById(Long id);
}

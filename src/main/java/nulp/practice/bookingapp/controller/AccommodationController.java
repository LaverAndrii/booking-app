package nulp.practice.bookingapp.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.accommodation.AccommodationDto;
import nulp.practice.bookingapp.dto.accommodation.AddAccommodationDto;
import nulp.practice.bookingapp.service.AccommodationService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accommodations")
public class AccommodationController { //Managing accommodation inventory (CRUD for Accommodations)
    private final AccommodationService accommodationService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public AccommodationDto add(@RequestBody @Valid AddAccommodationDto addAccommDto) {
        return accommodationService.add(addAccommDto);
    } // Permits the addition of new accommodations.

    @GetMapping //Provides a list of available accommodations.
    public List<AccommodationDto> getAll() {
        return accommodationService.getAll();
    }

    @GetMapping("/{id}") // Retrieves detailed information about a specific accommodation.
    public AccommodationDto getById(@PathVariable Long id) {
        return accommodationService.getById(id);
    }

    @PutMapping("/{id}") //Allows updates to accommodation details, including inventory management.
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public AccommodationDto update(@PathVariable Long id,
                                   @RequestBody @Valid AddAccommodationDto addAccommDto) {
        return accommodationService.updateById(id, addAccommDto);
    }

    @DeleteMapping("/{id}") //Enables the removal of accommodations.
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public void delete(@PathVariable Long id) {
        accommodationService.deleteById(id);
    }

}

package nulp.practice.bookingapp.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.booking.BookAccommodationDto;
import nulp.practice.bookingapp.dto.booking.BookingDto;
import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import nulp.practice.bookingapp.dto.booking.UpdateBookingDto;
import nulp.practice.bookingapp.model.User;
import nulp.practice.bookingapp.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/bookings")
public class BookingController { //Managing users' bookings
    private final BookingService bookingService;

    @PostMapping //Permits the creation of new accommodation bookings.
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public BookingDto create(@RequestBody @Valid BookAccommodationDto bookAccommodationDto,
                             Authentication authentication) {
        return bookingService.create(getUserEmail(authentication), bookAccommodationDto);
    }

    //Retrieves bookings based on user ID and their status. (Available for managers)
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<BookingDto> getByParams(BookingSearchParametersDto searchParamsDto) {
        return bookingService.getBookingsByParams(searchParamsDto);
    }
    // GET: /bookings/?user_id=...&status=... -

    @GetMapping("/my") //Retrieves user bookings
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public List<BookingDto> getMyBookings(Authentication authentication) {
        return bookingService.getBookingsByEmail(getUserEmail(authentication));
    }

    @GetMapping("/{id}") //Provides information about a specific booking.
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public BookingDto getBookingById(@PathVariable Long id, Authentication authentication) {
        return bookingService.getBookingById(id, getUserEmail(authentication));
    }

    @PutMapping("/{id}") //Allows users to update their booking details.
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public BookingDto update(@PathVariable Long id,
                             @RequestBody @Valid UpdateBookingDto updateBookingDto,
                             Authentication authentication) {
        return bookingService.update(id, updateBookingDto, getUserEmail(authentication));
    }

    @DeleteMapping("/{id}") //Enables the cancellation of bookings.
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public BookingDto cancel(@PathVariable Long id, Authentication authentication) {
        return bookingService.cancel(id, getUserEmail(authentication));
    }

    private String getUserEmail(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getEmail();
    }
}

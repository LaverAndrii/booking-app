package nulp.practice.bookingapp.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.booking.BookAccommodationDto;
import nulp.practice.bookingapp.dto.booking.BookingDto;
import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import nulp.practice.bookingapp.dto.booking.UpdateBookingDto;
import nulp.practice.bookingapp.mapper.BookingMapper;
import nulp.practice.bookingapp.model.Booking;
import nulp.practice.bookingapp.repository.booking.BookingRepository;
import nulp.practice.bookingapp.repository.booking.BookingSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final BookingMapper bookingMapper;
    private final BookingSpecificationBuilder bookingSpecificationBuilder;

    @Override
    @Transactional
    public BookingDto create(String email, BookAccommodationDto bookAccommodationDto) {
        Long userId = getUserIdByEmail(email);
        Booking booking = bookingMapper.toModel(bookAccommodationDto);
        booking.setUserId(userId);
        booking.setStatus(Booking.Status.PENDING);
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDto> getBookingsByEmail(String email) {
        Long id = getUserIdByEmail(email);
        return bookingRepository.findAllByUserId(id).stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    @Override
    public BookingDto getBookingById(Long id, String email) {
        Booking booking = findById(id);
        if (!hasUserMadeBooking(booking, email)) {
            throw new RuntimeException("You can't get this booking");
        }
        return bookingMapper.toDto(booking);
    }

    @Override
    @Transactional
    public BookingDto cancel(Long id, String email) {
        Booking booking = findById(id);
        if (!hasUserMadeBooking(booking, email)) {
            throw new RuntimeException("You can't cancel this booking.");
        }
        if (booking.getStatus().equals(Booking.Status.CANCELLED)) {
            throw new RuntimeException("This booking has already been cancelled");
        }
        booking.setStatus(Booking.Status.CANCELLED);
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDto> getBookingsByParams(BookingSearchParametersDto searchParamsDto) {
        Specification<Booking> bookingSpecification = bookingSpecificationBuilder
                .build(searchParamsDto);
        return bookingRepository.findAll(bookingSpecification).stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public BookingDto update(Long id, UpdateBookingDto updateBookingDto, String email) {
        Booking booking = findById(id);
        if (!hasUserMadeBooking(booking, email)) {
            throw new RuntimeException("You can't update this booking.");
        }
        booking.setCheckInDate(updateBookingDto.checkInDate());
        booking.setCheckOutDate(updateBookingDto.checkOutDate());
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    private Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can`t find booking by id: " + id));
    }

    private Long getUserIdByEmail(String email) {
        return userService.getProfile(email).getId();
    }

    private boolean hasUserMadeBooking(Booking booking, String email) {
        Long userId = getUserIdByEmail(email);
        return booking.getUserId().equals(userId);
    }
}

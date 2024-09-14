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

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final BookingMapper bookingMapper;
    private final BookingSpecificationBuilder bookingSpecificationBuilder;

    @Override
    public BookingDto create(String email, BookAccommodationDto bookAccommodationDto) {
        Long userId = userService.getProfile(email).getId();
        Booking booking = bookingMapper.toModel(bookAccommodationDto);
        booking.setUserId(userId);
        booking.setStatus(Booking.Status.PENDING);
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDto> getBookingsByEmail(String email) {
        Long id = userService.getProfile(email).getId();
        return bookingRepository.findAllByUserId(id).stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    @Override
    public BookingDto getBookingById(Long id) {
        return bookingMapper.toDto(findById(id));
    }

    @Override
    public BookingDto cancel(Long id) {
        Booking booking = findById(id);
        booking.setStatus(Booking.Status.CANCELED);
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
    public BookingDto update(Long id, UpdateBookingDto updateBookingDto) {
        Booking booking = findById(id);
        booking.setCheckInDate(updateBookingDto.checkInDate());
        booking.setCheckOutDate(updateBookingDto.checkOutDate());
        return bookingMapper.toDto(bookingRepository.save(booking));
    }

    private Booking findById(Long id) {
        return bookingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Can`t find booking by id: " + id));
    }
}

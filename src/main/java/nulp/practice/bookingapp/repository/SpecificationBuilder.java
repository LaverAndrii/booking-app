package nulp.practice.bookingapp.repository;

import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookingSearchParametersDto searchParams);
}

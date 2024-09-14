package nulp.practice.bookingapp.repository.booking;

import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.dto.booking.BookingSearchParametersDto;
import nulp.practice.bookingapp.model.Booking;
import nulp.practice.bookingapp.repository.SpecificationBuilder;
import nulp.practice.bookingapp.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingSpecificationBuilder implements SpecificationBuilder<Booking> {
    private static final String USER_ID = "userId";
    private static final String STATUS = "status";
    private final SpecificationProviderManager<Booking> specificationProviderManager;

    @Override
    public Specification<Booking> build(BookingSearchParametersDto searchParams) {
        Specification<Booking> spec = Specification.where(null);
        if (searchParams.userId() != null) {
            spec = spec.and(specificationProviderManager.getSpecificationProvider(USER_ID)
                    .getSpecification(searchParams.userId()));
        }
        if (searchParams.status() != null) {
            spec = spec.and(specificationProviderManager.getSpecificationProvider(STATUS)
                    .getSpecification(searchParams.status()));
        }
        return spec;
    }
}

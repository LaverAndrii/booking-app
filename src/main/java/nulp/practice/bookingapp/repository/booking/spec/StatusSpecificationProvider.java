package nulp.practice.bookingapp.repository.booking.spec;

import nulp.practice.bookingapp.model.Booking;
import nulp.practice.bookingapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class StatusSpecificationProvider implements SpecificationProvider<Booking> {
    private static final String STATUS = "status";

    @Override
    public String getKey() {
        return STATUS;
    }

    @Override
    public Specification<Booking> getSpecification(Object param) {
        Booking.Status status = (Booking.Status) param;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(STATUS), status);
    }
}

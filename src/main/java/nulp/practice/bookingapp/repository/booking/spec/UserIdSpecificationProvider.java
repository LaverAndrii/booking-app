package nulp.practice.bookingapp.repository.booking.spec;

import nulp.practice.bookingapp.model.Booking;
import nulp.practice.bookingapp.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UserIdSpecificationProvider implements SpecificationProvider<Booking> {
    private static final String USER_ID = "userId";

    @Override
    public String getKey() {
        return USER_ID;
    }

    @Override
    public Specification<Booking> getSpecification(Object param) {
        Long id = (Long) param;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(USER_ID), id);
    }
}

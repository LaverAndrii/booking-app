package nulp.practice.bookingapp.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    String getKey();

    Specification<T> getSpecification(Object param);
}

package nulp.practice.bookingapp.repository.booking;

import java.util.List;
import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.model.Booking;
import nulp.practice.bookingapp.repository.SpecificationProvider;
import nulp.practice.bookingapp.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingSpecificationProviderManager implements SpecificationProviderManager<Booking> {
    private final List<SpecificationProvider<Booking>> bookingSpecificationProviders;

    @Override
    public SpecificationProvider<Booking> getSpecificationProvider(String key) {
        return bookingSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Can`t find correct specification provider for key: " + key));
    }
}

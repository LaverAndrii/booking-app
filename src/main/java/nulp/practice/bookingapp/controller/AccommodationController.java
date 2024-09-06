package nulp.practice.bookingapp.controller;

import nulp.practice.bookingapp.model.Accommodation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccommodationController {

    @GetMapping
    public Accommodation getAccommodation() {
        return null;
    }
}

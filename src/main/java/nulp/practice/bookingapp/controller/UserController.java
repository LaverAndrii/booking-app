package nulp.practice.bookingapp.controller;

import lombok.RequiredArgsConstructor;
import nulp.practice.bookingapp.model.User;
import nulp.practice.bookingapp.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users") //Managing authentication and user registration
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/{id}/role") //Enables users to update their roles, providing role-based access.
    public void updateRole(@PathVariable Long id) {
        userService.updateRole();
    }

    @GetMapping("/me") //Retrieves the profile information for the currently logged-in user.
    public User getMe(Authentication authentication) {
        return userService.getProfile(getUserEmail(authentication));
    }

    @PutMapping ("/me")//Allows users to update their profile information.
    public void updateProfile(Authentication authentication, @RequestBody User user) {
        userService.updateProfile(getUserEmail(authentication), user);
    }

    private String getUserEmail(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return user.getEmail();
    }
}

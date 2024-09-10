package nulp.practice.bookingapp.service;

import nulp.practice.bookingapp.model.User;

public interface UserService {
    User getProfile(String email);

    void updateRole();

    void updateProfile(String userEmail, User user);
}

package jmp.cloud.service;

import jmp.cloud.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public interface Service {

    default double getAverageUsersAge() {
        List<User> users = getAllUsers();

        return users.stream()
            .mapToDouble(user -> ChronoUnit.YEARS.between(user.birthDate(), LocalDate.now()))
            .average()
            .orElse(0.0); // if there are no users
    }

    /**
     * Return true if the user is over 18 years old
     * */
    static boolean isPayableUser(User user) {
        if (user == null || user.birthDate() == null) {
            throw new IllegalArgumentException("User or birth date cannot be null");
        }
        long age = ChronoUnit.YEARS.between(user.birthDate(), LocalDate.now());
        return age > 18;
    }

    /**
     * A method to return an unmodifiable list of users (implemented in ServiceImpl)
     * */
    default List<User> getAllUsers() {
        return getUsers().stream()
            .collect(Collectors.toUnmodifiableList()); // collect into an unmodifiable liist
    }

    List<User> getUsers();
}

package com.shareat.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


//Data Access Object
@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    public static int userCount = 0;

    static {
        users.add(new User(++userCount, "Carlo", "cahhil",
                LocalDate.now().minusYears(24), "Copenhagen"));
        users.add(new User(++userCount, "Andrea", "enneadi",
                LocalDate.now().minusYears(30), "Hamburg"));


    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User saveUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }


    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public List<User> findALl() {
        return users;
    }
}
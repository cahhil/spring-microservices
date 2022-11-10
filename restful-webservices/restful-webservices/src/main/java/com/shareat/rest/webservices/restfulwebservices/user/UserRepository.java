package com.shareat.rest.webservices.restfulwebservices.user;

import com.shareat.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

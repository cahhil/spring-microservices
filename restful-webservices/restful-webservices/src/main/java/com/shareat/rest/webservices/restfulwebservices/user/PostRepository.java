package com.shareat.rest.webservices.restfulwebservices.user;

import com.shareat.rest.webservices.restfulwebservices.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}

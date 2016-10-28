package org.learning.springboot.repositories;

import org.learning.springboot.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ajinkyav on 10/27/2016.
 */
public interface UserRepository extends  JpaRepository<User, Long> {
    public User findById(long id);
}

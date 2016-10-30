package org.learning.springboot.repositories;

import org.learning.springboot.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author - Ajinkya
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}

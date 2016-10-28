package org.learning.springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Checked exception indicating user is not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
    public UserNotFoundException(long id) {
        super("User with Id: " + id + " is not available");
    }
}

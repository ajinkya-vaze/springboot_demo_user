package org.learning.springboot.service;

/**
 * Checked exception indicating user is not found
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(long id) {
        super("User with Id: " + id + " is not available");
    }
}

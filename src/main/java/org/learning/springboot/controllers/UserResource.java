package org.learning.springboot.controllers;

import org.learning.springboot.schema.User;
import org.learning.springboot.service.UserNotFoundException;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @Author Ajinkya
 */
public class UserResource extends ResourceSupport {
    private final User user;

    public UserResource(User user) {
        this.user = user;
        try {
            this.add(linkTo(methodOn(UserController.class).getUser(this.user.getId())).withSelfRel());
        } catch (UserNotFoundException e) {
        }
    }

    public User getUser() {
        return user;
    }
}

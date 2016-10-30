package org.learning.springboot.controllers;

import org.learning.springboot.schema.User;
import org.learning.springboot.service.UserNotFoundException;
import org.learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Ajinkya
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public Resources<UserResource> getUsers() {
        List<UserResource> userResources = userService.getUsers().stream().map(UserResource::new).collect(Collectors.toList());
        return new Resources<>(userResources);
    }

    @RequestMapping("/user/{id}")
    public UserResource getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return new UserResource(user);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{id}", consumes = "application/json")
    public UserResource updateUser(@RequestBody User user, @PathVariable long id) throws UserNotFoundException {
        return new UserResource(userService.updateUser(user));
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/create", consumes = "application/json")
    public void adduser(@RequestBody User newUser) throws Exception {
        userService.createUser(newUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/user/{id}")
    public String deleteUser(@PathVariable long id) throws UserNotFoundException {
        return userService.deleteUser(id);
    }
}
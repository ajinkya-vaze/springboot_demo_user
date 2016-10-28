package org.learning.springboot.controllers;

import org.learning.springboot.schema.User;
import org.learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by ajinkyav on 10/25/2016.
 */
@RestController
public class UserServiceController {
    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{id}", consumes = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable long id) throws Exception {
        return userService.updateUser(user);
    }

    @RequestMapping(method= RequestMethod.POST, path = "/user/create", consumes = "application/json")
    public void adduser(@RequestBody User newUser) throws Exception {
        userService.createUser(newUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/user/{id}")
    public String deleteUser(@PathVariable long id) throws Exception {
        return userService.deleteUser(id);
    }
}

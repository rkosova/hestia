package com.hestia.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API LAYER
 */

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
         return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}

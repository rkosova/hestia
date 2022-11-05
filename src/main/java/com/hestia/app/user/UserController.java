package com.hestia.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public void registerUser(@RequestBody User user)throws Exception {
        userService.addUser(user);
    }
    @PostMapping("/login")
    public RedirectView login(@ModelAttribute User user){
        String option = userService.login(user);
        return new RedirectView(option);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }
}

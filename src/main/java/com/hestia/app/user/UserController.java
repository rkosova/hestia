package com.hestia.app.user;

import com.hestia.app.mail.EmailDetails;
import com.hestia.app.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
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

    @PostMapping("/register")
    public RedirectView registerUser(@ModelAttribute User user)throws Exception {
        String option = userService.addUser(user);
        return new RedirectView(option);
    }

    @PostMapping("/login")
    public RedirectView login(@ModelAttribute User user, HttpSession session){
        String option = userService.login(user, session);
        return new RedirectView(option);
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session) {
        String option = userService.logout(session);
        return new RedirectView(option);
    }
}

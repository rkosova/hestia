package com.hestia.app.user;

import com.hestia.app.hash.Bcrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * SERVICE LAYER
 */

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Bcrypt bcrypt = new Bcrypt();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public String addUser(User user)throws Exception {
        String password = user.getPassword();

        user.setPassword(bcrypt.encoder().encode(password));

        if(user.getEmail() == null || user.getPassword() == null){
            return "/register";
        }
        userRepository.save(user);
        return "/login";
    }
    public String login(User user, HttpSession session){
        Optional<User> authorized = userRepository.findAllByEmail(user.getEmail());
        String password = authorized.get().getPassword();
        boolean isPasswordMatch = bcrypt.encoder().matches(user.getPassword(), password);
        if(!authorized.isEmpty() && isPasswordMatch){
            session.setAttribute("user",user.getEmail());
            return "/dashboard";
        }
        return "/login";
    }
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalStateException("User with id " + userId + "does not exist");
        } else {
            userRepository.deleteById(userId);
        }
    }
}

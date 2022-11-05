package com.hestia.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * SERVICE LAYER
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user)throws Exception {

        if(user.getEmail() == null || user.getPassword() == null){
            throw new Exception("Email or Password not provided");
        }
        userRepository.save(user);
    }
    public String login(User user, HttpSession session){
        Optional<User> authorized = userRepository.findAllByEmailAndPassword(user.getEmail(), user.getPassword());
        if(!authorized.isEmpty()){
            session.setAttribute("user",user.getEmail());
            session.setAttribute("id",user.getId());
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

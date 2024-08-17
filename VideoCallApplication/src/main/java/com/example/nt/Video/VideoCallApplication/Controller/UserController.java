package com.example.nt.Video.VideoCallApplication.Controller;

import com.example.nt.Video.VideoCallApplication.Service.UserService;
import com.example.nt.Video.VideoCallApplication.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

@PostMapping("/register")
    public void  register(User user){
        userService.register(user);
    }
    @PostMapping("/login")
    public User login(User user){

       return userService.login(user);
    }
@PostMapping("/logout")
    public void logout(String email){
        userService.logout(email);

    }
    @GetMapping("/details")
    public List<User> findAll(){
        return userService.findAll();
    }
}

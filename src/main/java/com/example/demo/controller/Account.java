package com.example.demo.controller;

import com.example.demo.security.User;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequiredArgsConstructor
public class Account {

    @Autowired
    UserServiceImpl userService;

    @GetMapping (value = "/isLoggedIn")
    public User is(@CurrentSecurityContext(expression="authentication?.name")
                           String username) {
            return new User(username, "pass");
    }
    @GetMapping (value = "products/isLoggedIn")
    public User isProducts(@CurrentSecurityContext(expression="authentication?.name")
                   String username) {
        return new User(username, "pass");
    }

    @PostMapping("/register")
    public void creteUser(@RequestBody User user){
        System.out.println("e bine");
        userService.createUser(user);
    }

    @GetMapping ("/info")
    public User getInfo(@CurrentSecurityContext(expression="authentication?.name")
                        String username)
    {
        System.out.println("e bine");
        return new User(username, "pass");
    }

    @PostMapping ("/update")
    public  void updateUSer(@RequestBody String newUserName,@CurrentSecurityContext(expression="authentication?.name") String oldUsername){
        userService.updateUserName(newUserName,oldUsername);
    }
}

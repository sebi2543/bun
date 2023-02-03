package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    UserRepository userRepository;
    public void  createUser(User user){
        userRepository.save(user);
    }

    public  void updateUserName(String newUserName,String oldUserName){
        System.out.println("USERNAMUL VBECHI ERA"+oldUserName);
        User user=userRepository.findByUserName(oldUserName).get();
        user.setUserName(newUserName);
        userRepository.save(user);
    }
}

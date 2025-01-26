package com.leandrodev.ms.service;

import com.leandrodev.ms.models.UserModel;
import com.leandrodev.ms.producers.UserProducer;
import com.leandrodev.ms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserProducer userProducer;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publisMessageEmail(userModel);
        return userModel;
    }

}

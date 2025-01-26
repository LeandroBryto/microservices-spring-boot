package com.leandrodev.ms.controller;

import com.leandrodev.ms.dtos.UserRecordDto;
import com.leandrodev.ms.models.UserModel;
import com.leandrodev.ms.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
 class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto , userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}

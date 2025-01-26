package com.leandrodev.ms.controller;

import com.leandrodev.ms.dtos.UserRecordDto;
import com.leandrodev.ms.models.UserModel;
import com.leandrodev.ms.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "User ", tags = "User")
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "Create a new user", notes = "This endpoint creates a new user with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User successfully created"),
            @ApiResponse(code = 400, message = "Invalid input data"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto) {
        logger.info("Iniciando requisição para criar usuário com e-mail: {}", userRecordDto.email());

        var userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDto , userModel);

        try {
            logger.info("Salvando usuário: {}", userRecordDto.email());
            UserModel savedUser = userService.save(userModel);
            logger.info("Usuário com e-mail {} criado com sucesso!", userRecordDto.email());
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            logger.error("Erro ao salvar o usuário com e-mail {}: {}", userRecordDto.email(), e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

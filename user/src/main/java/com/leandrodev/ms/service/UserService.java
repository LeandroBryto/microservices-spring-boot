package com.leandrodev.ms.service;


import com.leandrodev.ms.models.UserModel;
import com.leandrodev.ms.producers.UserProducer;
import com.leandrodev.ms.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserProducer userProducer;
    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel){
        logger.info("Iniciando o processo de salvar o usuário: {}", userModel.getName());

        userModel = userRepository.save(userModel);
        logger.info("Usuário salvo com sucesso. ID: {}", userModel.getUserId());

        try {
            userProducer.publisMessageEmail(userModel);
            logger.info("Mensagem de email enviada para o usuário: {}", userModel.getEmail());
        } catch (Exception e) {
            logger.error("Erro ao enviar email para o usuário: {}", userModel.getEmail(), e);
        }

        return userModel;
    }

}

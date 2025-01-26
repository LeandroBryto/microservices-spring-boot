package com.leandrodev.ms.producers;

import com.leandrodev.ms.dtos.EmailDto;
import com.leandrodev.ms.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

   @Value(value = "${http://broker.queue.email.name}")
    private String routingKey;

    public void publisMessageEmail(UserModel userModel){
        var emailDto = new EmailDto();
        emailDto.setUserId(userModel.getUserId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(userModel.getName()+ ", seja bem vindo");

        rabbitTemplate.convertAndSend("",routingKey,emailDto);
    }
}

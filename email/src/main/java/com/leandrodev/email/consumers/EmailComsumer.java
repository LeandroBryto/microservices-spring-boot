package com.leandrodev.email.consumers;


import com.leandrodev.email.dtos.EmailRecordDto;
import com.leandrodev.email.models.EmailModel;
import com.leandrodev.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailComsumer {
    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto){
    var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        emailService.sendEmail(emailModel);
    }
}

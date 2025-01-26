package com.leandrodev.email.services;

import com.leandrodev.email.enums.StatusEmail;
import com.leandrodev.email.models.EmailModel;
import com.leandrodev.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Component
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    final EmailRepository emailRepository;
    final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        logger.info("Iniciando o envio do e-mail para: {}", emailModel.getEmailTo());

        try {
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            logger.info("E-mail enviado com sucesso para: {}", emailModel.getEmailTo());
        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
            logger.error("Erro ao enviar e-mail para: {}. Erro: {}", emailModel.getEmailTo(), e.getMessage(), e);
        } finally {
            EmailModel savedEmail = emailRepository.save(emailModel);
            logger.info("E-mail salvo no banco de dados com status: {}", emailModel.getStatusEmail());
            return savedEmail;
        }
    }
}

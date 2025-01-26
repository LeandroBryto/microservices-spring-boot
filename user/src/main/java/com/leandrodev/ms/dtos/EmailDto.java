package com.leandrodev.ms.dtos;

import java.util.UUID;

public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailTo(String email) {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

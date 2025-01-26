package com.leandrodev.email.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID userId,
                             String emailTo,
                             String subject,
                             String test) {
}

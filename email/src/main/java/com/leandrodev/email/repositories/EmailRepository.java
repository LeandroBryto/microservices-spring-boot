package com.leandrodev.email.repositories;

import com.leandrodev.email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel , UUID> {
}

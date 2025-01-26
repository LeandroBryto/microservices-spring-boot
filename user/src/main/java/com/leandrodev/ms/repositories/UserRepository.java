package com.leandrodev.ms.repositories;

import com.leandrodev.ms.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel , UUID> {
}

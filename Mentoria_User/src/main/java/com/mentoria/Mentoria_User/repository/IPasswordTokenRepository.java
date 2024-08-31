package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.entities.PasswordToken;
import com.mentoria.Mentoria_User.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPasswordTokenRepository extends JpaRepository<PasswordToken, Long> {

    Optional<PasswordToken> findByToken(String token);

}
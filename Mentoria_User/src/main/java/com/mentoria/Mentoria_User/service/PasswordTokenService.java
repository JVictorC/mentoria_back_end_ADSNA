package com.mentoria.Mentoria_User.service;


import com.mentoria.Mentoria_User.domain.entities.PasswordToken;
import com.mentoria.Mentoria_User.domain.entities.User;
import com.mentoria.Mentoria_User.repository.IPasswordTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.mentoria.Mentoria_User.util.Utils.builderPasswordToken;
import static com.mentoria.Mentoria_User.util.Utils.isExpired;

@Service
public class PasswordTokenService {

    @Autowired
    private IPasswordTokenRepository repository; // Repositório para armazenar tokens

    public String generateToken(User user) {
        String token = UUID.randomUUID().toString();

        repository.save(
                builderPasswordToken(token, user));
        return token;
    }

    public User validateToken(String token) {
        PasswordToken passwordToken = repository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido ou expirado"));

        if (isExpired(passwordToken)) {
            throw new RuntimeException("Token expirado");
        }

        return passwordToken.getUser();
    }


}

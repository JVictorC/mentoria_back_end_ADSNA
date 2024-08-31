package com.mentoria.Mentoria_User.service;

import com.mentoria.Mentoria_User.domain.dto.PasswordResetDTO;
import com.mentoria.Mentoria_User.domain.dto.PasswordUpdateDTO;
import com.mentoria.Mentoria_User.domain.dto.UpdateProfileDTO;
import com.mentoria.Mentoria_User.domain.dto.UserDTO;
import com.mentoria.Mentoria_User.domain.entities.User;
import com.mentoria.Mentoria_User.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.mentoria.Mentoria_User.util.Utils.buildUserToUserDTO;
import static com.mentoria.Mentoria_User.util.Utils.builderUserDTOToUser;

@Slf4j
@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordTokenService passwordTokenService;

    public UserDTO findByUserRA(String userRA) {
        return  buildUserToUserDTO(repository.findByUserRA(userRA));
    }

    public UserDTO insert(UserDTO user) {
        return  buildUserToUserDTO(
                repository.save(builderUserDTOToUser(user)));
    }

    public void updateProfile(Long id, UpdateProfileDTO profile) {
        repository.updateProfile(id, profile.getName(), profile.getEmail());
    }

    public void statusProfile(Long id) {
        repository.deactivationProfile(id);
    }

    public void updatePassword(Long userId, PasswordUpdateDTO passwordUpdateDTO) {
        try{
            User user = repository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            if (!passwordEncoder.matches(passwordUpdateDTO.getOldPassword(), user.getUserPassword())) {
                throw new RuntimeException("Senha atual incorreta");
            }

            user.setUserPassword(passwordEncoder.encode(passwordUpdateDTO.getNewPassword()));
            repository.save(user);

        }catch (RuntimeException e){
            log.info("Error update password", e);
        }

    }

    public void resetPassword(PasswordResetDTO passwordResetDTO) {

        try{
            User user = passwordTokenService.validateToken(passwordResetDTO.getToken());

            if (requestPasswordReset(user.getUserEmail())) {

                user.setUserPassword(passwordEncoder.encode(passwordResetDTO.getNewPassword()));
                repository.save(user);
            }
        }catch (Exception e){
            log.info("Error reset passWord", e);
        }
    }

    public boolean requestPasswordReset(String email) {
        try{
            User user = repository.findByUserEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            String token = passwordTokenService.generateToken(user);

            // Verificar lib para enviar e-mail com o token para trocar senha

            return true;
        }catch (Exception e){
            return false;
        }
    }
}

package com.mentoria.Mentoria_User.service;

import com.mentoria.Mentoria_User.domain.dto.UserDTO;
import com.mentoria.Mentoria_User.domain.entities.User;
import com.mentoria.Mentoria_User.repository.IUserRepository;
import com.mentoria.Mentoria_User.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mentoria.Mentoria_User.util.Utils.buildUserToUserDTO;
import static com.mentoria.Mentoria_User.util.Utils.builderUserDTOToUser;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    public UserDTO findByUsername(String username) {
        return  buildUserToUserDTO(repository.findByName(username));
    }

    public UserDTO insert(UserDTO user) {
        return  buildUserToUserDTO(
                repository.save(builderUserDTOToUser(user)));
    }

    public UserDTO updateProfile(Long id, String name, String email) {
        User user = repository.updateProfile(id, name, email);
        return buildUserToUserDTO(user);
    }

    public UserDTO deactivateProfile(Long id) {
        User user = repository.deactivationProfile(id);
        return buildUserToUserDTO(user);
    }

    public UserDTO updatePassword(Long id, String password) {
        User user = repository.updatePassword(id, password);
        return buildUserToUserDTO(user);
    }

}

package com.mentoria.Mentoria_User.util;

import com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO;
import com.mentoria.Mentoria_User.domain.dto.UserDTO;
import com.mentoria.Mentoria_User.domain.entities.*;

import java.time.LocalDateTime;

public class Utils {

    public static User builderUserDTOToUser(UserDTO userDTO) {
        return User.builder()
                .userName(userDTO.getUserName())
                .userEmail(userDTO.getUserEmail())
                .userRA(userDTO.getUserRA())
                .userPassword(userDTO.getUserPassword())
                .userStatus(userDTO.getUserStatus())
                .build();
    }

    public static UserDTO buildUserToUserDTO(User user) {
        return UserDTO.builder()
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userRA(user.getUserRA())
                .userStatus(user.getUserStatus())
                .build();
    }

    public static SolicitationRequest buildSolicitationRequestDTOToSolicitationRequest(SolicitationRequestDTO solicitationRequest) {
        return SolicitationRequest.builder()
                .requestTitle(solicitationRequest.getRequestTitle())
                .requestSegment(solicitationRequest.getRequestSegment())
                .requestStatus(solicitationRequest.getRequestStatus())
                .build();
    }

    public static SolicitationRequestDTO buildSolicitationRequestToSolicitationRequestDTO(SolicitationRequest solicitationRequest) {
        return SolicitationRequestDTO.builder()
                .requestTitle(solicitationRequest.getRequestTitle())
                .requestSegment(solicitationRequest.getRequestSegment())
                .requestStatus(solicitationRequest.getRequestStatus())
                .build();
    }

    public static PasswordToken builderPasswordToken(String token, User user) {
        return PasswordToken.builder()
                .token(token)
                .user(user)
                .build();
    }

    public static boolean isExpired(PasswordToken token) {
        return LocalDateTime.now().isAfter(token.getExpirationDate());
    }

}

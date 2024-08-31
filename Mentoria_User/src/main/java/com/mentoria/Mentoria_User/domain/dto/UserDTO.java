package com.mentoria.Mentoria_User.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {


    private Long user_id;
    private String userName;
    private String userEmail;
    private String userRA;
    private String userPassword;
    private Integer userStatus;
}

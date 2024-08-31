package com.mentoria.Mentoria_User.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_ra")
    private String userRA;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_status")
    private Integer userStatus;

    @OneToMany(mappedBy = "user")
    private List<SolicitationRequest> requests;

    @OneToMany(mappedBy = "user")
    private List<SolicitationResponse> responses;

}

package com.mentoria.Mentoria_User.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_request")
public class SolicitationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;


    @Column(name = "request_title")
    private String requestTitle;

    @Column(name = "request_segment")
    private String requestSegment;

    @Column(name = "request_status")
    private Integer requestStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.mentoria.Mentoria_User.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_response")
public class SolicitationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "response_id")
    private Long responseId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "response_status")
    private Integer responseStatus;

    @Column(name = "response_segment")
    private String responseSegment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

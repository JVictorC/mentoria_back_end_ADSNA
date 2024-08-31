package com.mentoria.Mentoria_User.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationResponseDTO {

    private Long responseId;
    private Long userId;
    private Long requestId;
    private Integer responseStatus;
    private String responseSegment;
}

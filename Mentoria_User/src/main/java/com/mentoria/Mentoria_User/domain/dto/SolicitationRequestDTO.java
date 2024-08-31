package com.mentoria.Mentoria_User.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationRequestDTO {

    private Long userId;

    private String requestTitle;

    private String requestSegment;

    private Integer requestStatus;
}

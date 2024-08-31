package com.mentoria.Mentoria_User.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseRequestDTO {

    List<SolicitationRequestDTO> requests;
}

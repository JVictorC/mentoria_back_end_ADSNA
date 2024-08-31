package com.mentoria.Mentoria_User.service;

import com.mentoria.Mentoria_User.domain.dto.ResponseDTO;
import com.mentoria.Mentoria_User.domain.dto.SolicitationResponseDTO;
import com.mentoria.Mentoria_User.repository.ISolicitationResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitationResponseService {

    @Autowired private ISolicitationResponseRepository solicitationResponseRepository;

    public ResponseDTO findRequestBySegment(String segment){

        ResponseDTO response = new ResponseDTO();
        List<SolicitationResponseDTO> dto = solicitationResponseRepository.findByRequestBySegment(segment);

        if (!dto.isEmpty()) {
            response.setResponses(dto);
        }
        return response;
    }

    public ResponseDTO findRequestByRa(String ra){

        ResponseDTO response = new ResponseDTO();
        List<SolicitationResponseDTO> dto = solicitationResponseRepository.findRequestByRa(ra);

        if (!dto.isEmpty()) {
            response.setResponses(dto);
        }
        return response;
    }

}

package com.mentoria.Mentoria_User.service;

import com.mentoria.Mentoria_User.domain.dto.ResponseRequestDTO;
import com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO;
import com.mentoria.Mentoria_User.domain.entities.SolicitationRequest;
import com.mentoria.Mentoria_User.repository.ISolicitationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.mentoria.Mentoria_User.util.Utils.buildSolicitationRequestDTOToSolicitationRequest;
import static com.mentoria.Mentoria_User.util.Utils.buildSolicitationRequestToSolicitationRequestDTO;

@Service
public class SolicitationRequestService {

    @Autowired private ISolicitationRequestRepository solicitationRequestRepository;

    public ResponseRequestDTO findRequestBySegment(String segment){

        ResponseRequestDTO response = new ResponseRequestDTO();
        List<SolicitationRequestDTO> dto = solicitationRequestRepository.findByRequestBySegment(segment);

        if (!dto.isEmpty()) {
            response.setRequests(dto);
        }
        return response;
    }

    public ResponseRequestDTO findRequestByRa(String ra){

        ResponseRequestDTO response = new ResponseRequestDTO();
        List<SolicitationRequestDTO> dto = solicitationRequestRepository.findRequestByRa(ra);

        if (!dto.isEmpty()) {
            response.setRequests(dto);
        }
        return response;
    }

    public ResponseRequestDTO createSolicitationRequest(SolicitationRequestDTO solicitationRequestDTO) {

        ResponseRequestDTO response = new ResponseRequestDTO();
        List<SolicitationRequestDTO> dto = new ArrayList<>();

        SolicitationRequest request = buildSolicitationRequestDTOToSolicitationRequest(solicitationRequestDTO);
        SolicitationRequest solicitation = solicitationRequestRepository.save(request);

        dto.add(buildSolicitationRequestToSolicitationRequestDTO(solicitation));

        response.setRequests(dto);
        return response;
    }

    public void updadeStatusRequest(Long id, Integer status){
        solicitationRequestRepository.updateRequestStatus(id, status);
    }

    public void deleteSolicitationRequest(Long id){
        solicitationRequestRepository.deleteById(id);
    }

}

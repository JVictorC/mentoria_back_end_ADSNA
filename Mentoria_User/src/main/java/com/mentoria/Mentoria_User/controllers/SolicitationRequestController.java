package com.mentoria.Mentoria_User.controllers;

import com.mentoria.Mentoria_User.domain.dto.ResponseRequestDTO;
import com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO;
import com.mentoria.Mentoria_User.service.SolicitationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class SolicitationRequestController {

    @Autowired private SolicitationRequestService solicitationRequestService;

    @GetMapping("/findBySegment")
    public ResponseEntity<ResponseRequestDTO> findBySegment(@Param("segment") String segment) {
        return ResponseEntity.ok().body(solicitationRequestService.findRequestBySegment(segment));
    }

    @GetMapping("/findByRa")
    public ResponseEntity<ResponseRequestDTO> findByRa(@Param("ra") String ra) {
        return ResponseEntity.ok().body(solicitationRequestService.findRequestByRa(ra));
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRequestDTO> create(@RequestBody SolicitationRequestDTO solicitationRequestDTO) {
        return ResponseEntity.ok().body(solicitationRequestService.createSolicitationRequest(solicitationRequestDTO));
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity updateStatus(@PathVariable Long id, @RequestBody Integer status) {
        solicitationRequestService.updadeStatusRequest(id, status);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        solicitationRequestService.deleteSolicitationRequest(id);
        return ResponseEntity.noContent().build();
    }
}

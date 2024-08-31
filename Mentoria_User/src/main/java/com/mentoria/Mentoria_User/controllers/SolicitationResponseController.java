package com.mentoria.Mentoria_User.controllers;

import com.mentoria.Mentoria_User.domain.dto.ResponseDTO;
import com.mentoria.Mentoria_User.service.SolicitationResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/response")
public class SolicitationResponseController {

    @Autowired private SolicitationResponseService solicitationResponseService;

    @GetMapping("/findBySegment")
    public ResponseEntity<ResponseDTO> findBySegment(@Param("segment") String segment) {
        return ResponseEntity.ok().body(solicitationResponseService.findRequestBySegment(segment));
    }

    @GetMapping("/findByRa")
    public ResponseEntity<ResponseDTO> findByRa(@Param("ra") String ra) {
        return ResponseEntity.ok().body(solicitationResponseService.findRequestByRa(ra));
    }
}

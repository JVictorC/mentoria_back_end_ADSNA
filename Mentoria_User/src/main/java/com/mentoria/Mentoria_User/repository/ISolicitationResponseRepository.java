package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.dto.SolicitationResponseDTO;
import com.mentoria.Mentoria_User.domain.entities.SolicitationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISolicitationResponseRepository extends JpaRepository<SolicitationResponse, Long> {

    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO (s.user.userId, s.requestTitle,"
            + " s.requestSegment, s.requestStatus)"
            + " from SolicitationRequest s where s.requestSegment like %:segment%")
    List<SolicitationResponseDTO> findByRequestBySegment(@Param("segment") String segment);

    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO(s.user.userId, s.requestTitle,"
            + " s.requestSegment, s.requestStatus)"
            + " from SolicitationRequest s"
            + " where s.user.userRA = :ra")
    List<SolicitationResponseDTO> findRequestByRa(@Param("ra") String ra);



}

package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.dto.SolicitationResponseDTO;
import com.mentoria.Mentoria_User.domain.entities.SolicitationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISolicitationResponseRepository extends JpaRepository<SolicitationResponse, Long> {

    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationResponseDTO ("
            + " s.requestId ,s.user.userId, s.requestId, s.responseStatus, s.responseSegment)"
            + " from SolicitationResponse s"
            + " where s.responseSegment like %:segment%")
    List<SolicitationResponseDTO> findByRequestBySegment(@Param("segment") String segment);

    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationResponseDTO("
            + " s.requestId ,s.user.userId, s.requestId, s.responseStatus, s.responseSegment)"
            + " from SolicitationResponse s"
            + " where s.user.userRA = :ra")
    List<SolicitationResponseDTO> findRequestByRa(@Param("ra") String ra);

}

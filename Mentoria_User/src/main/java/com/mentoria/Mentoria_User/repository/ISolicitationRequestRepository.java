package com.mentoria.Mentoria_User.repository;

import com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO;
import com.mentoria.Mentoria_User.domain.entities.SolicitationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISolicitationRequestRepository extends JpaRepository<SolicitationRequest, Long> {

    @Modifying
    @Query("update SolicitationRequest s set s.requestStatus = :status where s.requestId = :id")
    void updateRequestStatus(@Param("id") Long id, @Param("status") Integer status);


    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO (s.user.userId, s.requestTitle,"
            + " s.requestSegment, s.requestStatus)"
            + " from SolicitationRequest s where s.requestSegment like %:segment%")
    List<SolicitationRequestDTO> findByRequestBySegment(@Param("segment") String segment);

    @Query("select new com.mentoria.Mentoria_User.domain.dto.SolicitationRequestDTO(s.user.userId, s.requestTitle,"
            + " s.requestSegment, s.requestStatus)"
            + " from SolicitationRequest s"
            + " where s.user.userRA = :ra")
    List<SolicitationRequestDTO> findRequestByRa(@Param("ra") String ra);
}

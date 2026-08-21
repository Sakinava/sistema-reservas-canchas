package com.mycompany.avance1.repository;

import com.mycompany.avance1.model.AuditoriaReserva;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaReservaRepository
        extends JpaRepository<AuditoriaReserva, Long> {

    @Query("SELECT a FROM AuditoriaReserva a WHERE a.reserva.id = :reservaId")
    List<AuditoriaReserva> buscarHistorialPorReserva(
            @Param("reservaId") Long reservaId);
}
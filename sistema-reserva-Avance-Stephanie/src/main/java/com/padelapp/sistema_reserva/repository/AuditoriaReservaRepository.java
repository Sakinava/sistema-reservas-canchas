package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.AuditoriaReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriaReservaRepository extends JpaRepository<AuditoriaReserva, Long> {

    @Query("SELECT a FROM AuditoriaReserva a WHERE a.reservaId = :reservaId")
    List<AuditoriaReserva> buscarHistorialPorReserva(@Param("reservaId") Long reservaId);
}
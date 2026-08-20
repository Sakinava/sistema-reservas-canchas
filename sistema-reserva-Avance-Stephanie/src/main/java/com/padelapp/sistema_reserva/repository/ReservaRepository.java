package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long usuarioId);

    List<Reserva> findByFecha(LocalDate fecha);

    @Query("SELECT r FROM Reserva r WHERE r.cancha.id = :canchaId AND r.fecha = :fecha")
    List<Reserva> buscarReservasPorCanchaYFecha(@Param("canchaId") Long canchaId, @Param("fecha") LocalDate fecha);
}
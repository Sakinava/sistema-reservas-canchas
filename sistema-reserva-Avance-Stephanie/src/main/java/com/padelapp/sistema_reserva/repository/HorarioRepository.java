package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByHoraInicioAfter(LocalTime horaInicio);

    @Query("SELECT h FROM Horario h WHERE h.horaInicio >= :horaInicio")
    List<Horario> buscarHorariosDesde(@Param("horaInicio") LocalTime horaInicio);
}
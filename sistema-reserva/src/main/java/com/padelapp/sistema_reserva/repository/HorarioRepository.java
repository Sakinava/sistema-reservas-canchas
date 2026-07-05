package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
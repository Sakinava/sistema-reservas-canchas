package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.AuditoriaReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaReservaRepository extends JpaRepository<AuditoriaReserva, Long> {
}
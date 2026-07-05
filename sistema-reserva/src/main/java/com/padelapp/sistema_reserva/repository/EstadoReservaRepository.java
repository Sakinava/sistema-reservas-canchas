package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Long> {
}
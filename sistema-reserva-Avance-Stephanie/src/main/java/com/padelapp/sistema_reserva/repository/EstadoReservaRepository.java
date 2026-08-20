package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.EstadoReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Long> {

    Optional<EstadoReserva> findByNombre(String nombre);

    @Query("SELECT e FROM EstadoReserva e WHERE e.nombre = :nombre")
    Optional<EstadoReserva> buscarEstadoPorNombrePersonalizado(@Param("nombre") String nombre);
}
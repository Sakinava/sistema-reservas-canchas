package com.mycompany.avance1.repository;

import com.mycompany.avance1.model.EstadoReserva;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservaRepository
        extends JpaRepository<EstadoReserva, Long> {

    Optional<EstadoReserva> findByNombre(String nombre);

    @Query("SELECT e FROM EstadoReserva e WHERE e.nombre = :nombre")
    Optional<EstadoReserva> buscarEstadoPorNombrePersonalizado(
            @Param("nombre") String nombre);
}
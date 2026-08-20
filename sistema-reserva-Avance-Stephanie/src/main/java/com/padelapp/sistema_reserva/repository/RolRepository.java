package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByNombre(String nombre);

    @Query("SELECT r FROM Rol r WHERE r.nombre = :nombre")
    Optional<Rol> buscarRolPorNombrePersonalizado(@Param("nombre") String nombre);
}
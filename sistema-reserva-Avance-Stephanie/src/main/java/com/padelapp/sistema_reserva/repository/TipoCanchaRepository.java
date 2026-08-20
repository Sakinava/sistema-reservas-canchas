package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.TipoCancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCanchaRepository extends JpaRepository<TipoCancha, Long> {

    Optional<TipoCancha> findByNombre(String nombre);

    @Query("SELECT t FROM TipoCancha t WHERE t.nombre = :nombre")
    Optional<TipoCancha> buscarTipoPorNombrePersonalizado(@Param("nombre") String nombre);
}
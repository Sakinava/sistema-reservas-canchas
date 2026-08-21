package com.mycompany.avance1.repository;

import com.mycompany.avance1.model.TipoCancha;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCanchaRepository
        extends JpaRepository<TipoCancha, Long> {

    Optional<TipoCancha> findByNombre(String nombre);

    @Query("SELECT t FROM TipoCancha t WHERE t.nombre = :nombre")
    Optional<TipoCancha> buscarTipoPorNombrePersonalizado(
            @Param("nombre") String nombre);
}
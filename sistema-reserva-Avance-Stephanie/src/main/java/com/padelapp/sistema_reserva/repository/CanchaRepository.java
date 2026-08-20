package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {

    List<Cancha> findByTipoCanchaId(Long tipoCanchaId);

    @Query("SELECT c FROM Cancha c WHERE c.activa = true")
    List<Cancha> buscarCanchasActivas();
}
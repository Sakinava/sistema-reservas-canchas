package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.TipoCancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCanchaRepository extends JpaRepository<TipoCancha, Long> {
} 
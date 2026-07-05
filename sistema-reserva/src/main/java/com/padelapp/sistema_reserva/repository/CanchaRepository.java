package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Long> {
}

package com.padelapp.sistema_reserva.repository;

import com.padelapp.sistema_reserva.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Optional<Usuario> buscarPorCorreoPersonalizado(@Param("correo") String correo);
}
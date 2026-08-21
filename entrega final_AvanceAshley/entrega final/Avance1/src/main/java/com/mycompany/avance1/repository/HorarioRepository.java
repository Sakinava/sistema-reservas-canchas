package com.mycompany.avance1.repository;

import com.mycompany.avance1.model.Horario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository
        extends JpaRepository<Horario, Long> {

    List<Horario> findByHoraInicioAfter(String horaInicio);

    @Query("SELECT h FROM Horario h WHERE h.horaInicio >= :horaInicio")
    List<Horario> buscarHorariosDesde(
            @Param("horaInicio") String horaInicio);
}
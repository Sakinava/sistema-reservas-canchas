package com.mycompany.avance1.service;

import com.mycompany.avance1.model.Horario;
import java.util.List;

public interface HorarioService {

    List<Horario> getHorarios();

    Horario getHorario(Long id);

    void save(Horario horario);

    void delete(Horario horario);
}
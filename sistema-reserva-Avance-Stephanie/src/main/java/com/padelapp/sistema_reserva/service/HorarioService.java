package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.Horario;
import com.padelapp.sistema_reserva.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public List<Horario> listar() {
        return horarioRepository.findAll();
    }

    public Horario editar(Long id, Horario detalles) {
        Horario horario = horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horario no encontrado"));
        horario.setHoraInicio(detalles.getHoraInicio());
        horario.setHoraFin(detalles.getHoraFin());
        return horarioRepository.save(horario);
    }

    public void eliminar(Long id) {
        horarioRepository.deleteById(id);
    }
}
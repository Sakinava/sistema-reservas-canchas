package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.Reserva;
import com.padelapp.sistema_reserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    public Reserva editar(Long id, Reserva detalles) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setFecha(detalles.getFecha());
        reserva.setUsuario(detalles.getUsuario());
        reserva.setCancha(detalles.getCancha());
        reserva.setHorario(detalles.getHorario());
        reserva.setEstado(detalles.getEstado());
        return reservaRepository.save(reserva);
    }

    public void eliminar(Long id) {
        reservaRepository.deleteById(id);
    }
}
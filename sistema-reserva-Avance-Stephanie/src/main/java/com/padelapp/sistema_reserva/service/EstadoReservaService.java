package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.EstadoReserva;
import com.padelapp.sistema_reserva.repository.EstadoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoReservaService {

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    public EstadoReserva guardar(EstadoReserva estadoReserva) {
        return estadoReservaRepository.save(estadoReserva);
    }

    public List<EstadoReserva> listar() {
        return estadoReservaRepository.findAll();
    }

    public EstadoReserva editar(Long id, EstadoReserva detalles) {
        EstadoReserva estadoReserva = estadoReservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado de reserva no encontrado"));
        estadoReserva.setNombre(detalles.getNombre());
        return estadoReservaRepository.save(estadoReserva);
    }

    public void eliminar(Long id) {
        estadoReservaRepository.deleteById(id);
    }
}
package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.Cancha;
import com.padelapp.sistema_reserva.repository.CanchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CanchaService {

    @Autowired
    private CanchaRepository canchaRepository;

    public Cancha guardar(Cancha cancha) {
        return canchaRepository.save(cancha);
    }

    public List<Cancha> listar() {
        return canchaRepository.findAll();
    }

    public Cancha editar(Long id, Cancha detalles) {
        Cancha cancha = canchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada"));
        cancha.setNombre(detalles.getNombre());
        return canchaRepository.save(cancha);
    }

    public void eliminar(Long id) {
        canchaRepository.deleteById(id);
    }
}
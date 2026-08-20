package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.TipoCancha;
import com.padelapp.sistema_reserva.repository.TipoCanchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoCanchaService {

    @Autowired
    private TipoCanchaRepository tipoCanchaRepository;

    public TipoCancha guardar(TipoCancha tipoCancha) {
        return tipoCanchaRepository.save(tipoCancha);
    }

    public List<TipoCancha> listar() {
        return tipoCanchaRepository.findAll();
    }

    public TipoCancha editar(Long id, TipoCancha detalles) {
        TipoCancha tipoCancha = tipoCanchaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de cancha no encontrado"));
        tipoCancha.setNombre(detalles.getNombre());
        return tipoCanchaRepository.save(tipoCancha);
    }

    public void eliminar(Long id) {
        tipoCanchaRepository.deleteById(id);
    }
}
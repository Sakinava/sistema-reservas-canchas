package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.Rol;
import com.padelapp.sistema_reserva.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    public Rol editar(Long id, Rol detalles) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rol.setNombre(detalles.getNombre());
        return rolRepository.save(rol);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}
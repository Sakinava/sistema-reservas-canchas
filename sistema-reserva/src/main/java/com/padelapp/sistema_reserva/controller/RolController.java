package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.Rol;
import com.padelapp.sistema_reserva.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public Rol crear(@Valid @RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.listar();
    }

    @PutMapping("/{id}")
    public Rol editar(@PathVariable Long id, @Valid @RequestBody Rol rol) {
        return rolService.editar(id, rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}
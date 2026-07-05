package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.Cancha;
import com.padelapp.sistema_reserva.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/canchas")
public class CanchaController {

    @Autowired
    private CanchaService canchaService;

    @PostMapping
    public Cancha crear(@Valid @RequestBody Cancha cancha) {
        return canchaService.guardar(cancha);
    }

    @GetMapping
    public List<Cancha> listar() {
        return canchaService.listar();
    }

    @PutMapping("/{id}")
    public Cancha editar(@PathVariable Long id, @Valid @RequestBody Cancha cancha) {
        return canchaService.editar(id, cancha);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        canchaService.eliminar(id);
    }
}
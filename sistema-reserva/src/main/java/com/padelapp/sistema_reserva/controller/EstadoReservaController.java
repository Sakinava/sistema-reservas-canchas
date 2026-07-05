package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.EstadoReserva;
import com.padelapp.sistema_reserva.service.EstadoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/estados-reserva")
public class EstadoReservaController {

    @Autowired
    private EstadoReservaService estadoReservaService;

    @PostMapping
    public EstadoReserva crear(@Valid @RequestBody EstadoReserva estadoReserva) {
        return estadoReservaService.guardar(estadoReserva);
    }

    @GetMapping
    public List<EstadoReserva> listar() {
        return estadoReservaService.listar();
    }

    @PutMapping("/{id}")
    public EstadoReserva editar(@PathVariable Long id, @Valid @RequestBody EstadoReserva estadoReserva) {
        return estadoReservaService.editar(id, estadoReserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estadoReservaService.eliminar(id);
    }
}
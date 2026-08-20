package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.Reserva;
import com.padelapp.sistema_reserva.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public Reserva crear(@Valid @RequestBody Reserva reserva) {
        return reservaService.guardar(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listar();
    }

    @PutMapping("/{id}")
    public Reserva editar(@PathVariable Long id,@Valid @RequestBody Reserva reserva) {
        return reservaService.editar(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reservaService.eliminar(id);
    }
}
package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.Horario;
import com.padelapp.sistema_reserva.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping
    public Horario crear(@Valid @RequestBody Horario horario) {
        return horarioService.guardar(horario);
    }

    @GetMapping
    public List<Horario> listar() {
        return horarioService.listar();
    }

    @PutMapping("/{id}")
    public Horario editar(@PathVariable Long id, @Valid @RequestBody Horario horario) {
        return horarioService.editar(id, horario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        horarioService.eliminar(id);
    }
}
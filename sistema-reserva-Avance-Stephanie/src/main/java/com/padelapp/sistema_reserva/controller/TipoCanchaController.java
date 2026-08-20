package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.TipoCancha;
import com.padelapp.sistema_reserva.service.TipoCanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipos-cancha")
public class TipoCanchaController {

    @Autowired
    private TipoCanchaService tipoCanchaService;

    @PostMapping
    public TipoCancha crear(@Valid @RequestBody TipoCancha tipoCancha) {
        return tipoCanchaService.guardar(tipoCancha);
    }

    @GetMapping
    public List<TipoCancha> listar() {
        return tipoCanchaService.listar();
    }

    @PutMapping("/{id}")
    public TipoCancha editar(@PathVariable Long id,@Valid @RequestBody TipoCancha tipoCancha) {
        return tipoCanchaService.editar(id, tipoCancha);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tipoCanchaService.eliminar(id);
    }
}
package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.AuditoriaReserva;
import com.padelapp.sistema_reserva.service.AuditoriaReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaReservaController {

    @Autowired
    private AuditoriaReservaService auditoriaReservaService;

    @PostMapping
    public AuditoriaReserva crearAuditoria(@Valid @RequestBody AuditoriaReserva auditoria) {
        return auditoriaReservaService.guardarAuditoria(auditoria);
    }

    @GetMapping
    public List<AuditoriaReserva> listarAuditorias() {
        return auditoriaReservaService.listarAuditorias();
    }

    @DeleteMapping("/{id}")
    public void eliminarAuditoria(@PathVariable Long id) {
        auditoriaReservaService.eliminarAuditoria(id);
    }
}
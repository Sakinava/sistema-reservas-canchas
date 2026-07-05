package com.padelapp.sistema_reserva.service;

import com.padelapp.sistema_reserva.model.AuditoriaReserva;
import com.padelapp.sistema_reserva.repository.AuditoriaReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuditoriaReservaService {

    @Autowired
    private AuditoriaReservaRepository auditoriaReservaRepository;

    public AuditoriaReserva guardarAuditoria(AuditoriaReserva auditoria) {
        return auditoriaReservaRepository.save(auditoria);
    }

    public List<AuditoriaReserva> listarAuditorias() {
        return auditoriaReservaRepository.findAll();
    }

    public void eliminarAuditoria(Long id) {
        auditoriaReservaRepository.deleteById(id);
    }
}
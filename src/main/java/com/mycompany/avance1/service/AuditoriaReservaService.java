package com.mycompany.avance1.service;

import com.mycompany.avance1.model.AuditoriaReserva;
import java.util.List;

public interface AuditoriaReservaService {

    List<AuditoriaReserva> getAuditorias();

    AuditoriaReserva getAuditoria(Long id);

    void save(AuditoriaReserva auditoriaReserva);

    void delete(AuditoriaReserva auditoriaReserva);
}
package com.mycompany.avance1.service;

import com.mycompany.avance1.model.EstadoReserva;
import java.util.List;

public interface EstadoReservaService {

    List<EstadoReserva> getEstadosReserva();

    EstadoReserva getEstadoReserva(Long id);

    void save(EstadoReserva estadoReserva);

    void delete(EstadoReserva estadoReserva);
}
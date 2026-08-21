/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.AuditoriaReserva;
import com.mycompany.avance1.model.Reserva;
import com.mycompany.avance1.repository.ReservaRepository;
import com.mycompany.avance1.service.AuditoriaReservaService;
import com.mycompany.avance1.service.ReservaService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AuditoriaReservaService auditoriaReservaService;

    @Override
    public List<Reserva> getReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void delete(Reserva reserva) {
        reservaRepository.delete(reserva);
    }

    @Override
    public Reserva guardar(Reserva reserva) {

        long numero = System.currentTimeMillis() % 10000;

        reserva.setCodigo("#RES-" + numero);
        reserva.setEstado("Confirmada");

        String horaInicio = reserva.getHora();

        if (horaInicio != null && horaInicio.contains(":")) {

            String[] partes = horaInicio.split(":");
            int hora = Integer.parseInt(partes[0]);
            String minutos = partes[1];

            int horaFinal = hora + 1;

            if (horaFinal == 24) {
                horaFinal = 0;
            }

            String horaFin;

            if (horaFinal < 10) {
                horaFin = "0" + horaFinal + ":" + minutos;
            } else {
                horaFin = horaFinal + ":" + minutos;
            }

            reserva.setHora(horaInicio + " - " + horaFin);
        }

        Reserva reservaGuardada = reservaRepository.save(reserva);

        AuditoriaReserva auditoria = new AuditoriaReserva();
        auditoria.setAccion("RESERVA CREADA");
        auditoria.setFechaCambio(LocalDateTime.now());
        auditoria.setReserva(reservaGuardada);

        auditoriaReservaService.save(auditoria);

        return reservaGuardada;
    }

    @Override
    public List<Reserva> listarPorUsuario(String usuario) {
        return reservaRepository.findByUsuarioOrderByIdDesc(usuario);
    }

    @Override
    public void cambiarEstado(Long id) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva != null) {

            if ("Confirmada".equals(reserva.getEstado())) {
                reserva.setEstado("Cancelada");

            } else if ("Cancelada".equals(reserva.getEstado())) {
                reserva.setEstado("Completada");

            } else {
                reserva.setEstado("Confirmada");
            }

            Reserva reservaActualizada =
                    reservaRepository.save(reserva);

            AuditoriaReserva auditoria =
                    new AuditoriaReserva();

            auditoria.setAccion(
                    "ESTADO CAMBIADO A "
                    + reservaActualizada.getEstado().toUpperCase());

            auditoria.setFechaCambio(LocalDateTime.now());
            auditoria.setReserva(reservaActualizada);

            auditoriaReservaService.save(auditoria);
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.Reserva;
import com.mycompany.avance1.repository.ReservaRepository;
import com.mycompany.avance1.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

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
}

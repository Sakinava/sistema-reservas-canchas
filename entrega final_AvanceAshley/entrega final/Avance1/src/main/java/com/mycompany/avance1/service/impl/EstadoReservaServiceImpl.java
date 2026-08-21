/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.EstadoReserva;
import com.mycompany.avance1.repository.EstadoReservaRepository;
import com.mycompany.avance1.service.EstadoReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoReservaServiceImpl implements EstadoReservaService {

    @Autowired
    private EstadoReservaRepository estadoReservaRepository;

    @Override
    public List<EstadoReserva> getEstadosReserva() {
        return estadoReservaRepository.findAll();
    }

    @Override
    public EstadoReserva getEstadoReserva(Long id) {
        return estadoReservaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EstadoReserva estadoReserva) {
        estadoReservaRepository.save(estadoReserva);
    }

    @Override
    public void delete(EstadoReserva estadoReserva) {
        estadoReservaRepository.delete(estadoReserva);
    }
}
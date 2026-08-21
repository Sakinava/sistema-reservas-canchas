/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.AuditoriaReserva;
import com.mycompany.avance1.repository.AuditoriaReservaRepository;
import com.mycompany.avance1.service.AuditoriaReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaReservaServiceImpl
        implements AuditoriaReservaService {

    @Autowired
    private AuditoriaReservaRepository auditoriaReservaRepository;

    @Override
    public List<AuditoriaReserva> getAuditorias() {
        return auditoriaReservaRepository.findAll();
    }

    @Override
    public AuditoriaReserva getAuditoria(Long id) {
        return auditoriaReservaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AuditoriaReserva auditoriaReserva) {
        auditoriaReservaRepository.save(auditoriaReserva);
    }

    @Override
    public void delete(AuditoriaReserva auditoriaReserva) {
        auditoriaReservaRepository.delete(auditoriaReserva);
    }
}

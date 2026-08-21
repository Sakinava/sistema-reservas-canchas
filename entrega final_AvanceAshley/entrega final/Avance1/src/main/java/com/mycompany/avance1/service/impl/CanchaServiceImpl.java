/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.Cancha;
import com.mycompany.avance1.repository.CanchaRepository;
import com.mycompany.avance1.service.CanchaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanchaServiceImpl implements CanchaService {

    @Autowired
    private CanchaRepository canchaRepository;

    @Override
    public List<Cancha> getCanchas() {
        return canchaRepository.findAll();
    }

    @Override
    public List<Cancha> getCanchasDisponibles() {
        return canchaRepository.findByDisponibleTrue();
    }

    @Override
    public Cancha getCancha(Long id) {
        return canchaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Cancha cancha) {
        canchaRepository.save(cancha);
    }

    @Override
    public void delete(Cancha cancha) {
        canchaRepository.delete(cancha);
    }

    @Override
    public void cambiarDisponibilidad(Long id) {

        Cancha cancha = canchaRepository.findById(id).orElse(null);

        if (cancha != null) {
            cancha.setDisponible(!cancha.isDisponible());
            canchaRepository.save(cancha);
        }
    }
}
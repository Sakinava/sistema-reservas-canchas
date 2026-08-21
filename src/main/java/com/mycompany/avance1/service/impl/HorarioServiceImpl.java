/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.Horario;
import com.mycompany.avance1.repository.HorarioRepository;
import com.mycompany.avance1.service.HorarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> getHorarios() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario getHorario(Long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public void delete(Horario horario) {
        horarioRepository.delete(horario);
    }
}
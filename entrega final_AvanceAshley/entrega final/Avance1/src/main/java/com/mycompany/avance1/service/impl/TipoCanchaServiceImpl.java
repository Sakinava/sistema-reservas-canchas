/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service.impl;

import com.mycompany.avance1.model.TipoCancha;
import com.mycompany.avance1.repository.TipoCanchaRepository;
import com.mycompany.avance1.service.TipoCanchaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCanchaServiceImpl implements TipoCanchaService {

    @Autowired
    private TipoCanchaRepository tipoCanchaRepository;

    @Override
    public List<TipoCancha> getTiposCancha() {
        return tipoCanchaRepository.findAll();
    }

    @Override
    public TipoCancha getTipoCancha(Long id) {
        return tipoCanchaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TipoCancha tipoCancha) {
        tipoCanchaRepository.save(tipoCancha);
    }

    @Override
    public void delete(TipoCancha tipoCancha) {
        tipoCanchaRepository.delete(tipoCancha);
    }
}
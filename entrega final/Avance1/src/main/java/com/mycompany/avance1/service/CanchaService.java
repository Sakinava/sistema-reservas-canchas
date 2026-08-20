/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service;

import com.mycompany.avance1.Cancha;
import java.util.List;
/**
 *
 * @author Usuario
 */

public interface CanchaService {

    public List<Cancha> getCanchas();

    public Cancha getCancha(Long id);

    public void save(Cancha cancha);

    public void delete(Cancha cancha);
}

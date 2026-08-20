/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service;

import com.mycompany.avance1.Reserva;
import java.util.List;

public interface ReservaService {

    public List<Reserva> getReservas();

    public Reserva getReserva(Long id);

    public void save(Reserva reserva);

    public void delete(Reserva reserva);
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service;

import com.mycompany.avance1.model.Reserva;
import java.util.List;

public interface ReservaService {

    List<Reserva> getReservas();

    Reserva getReserva(Long id);

    void save(Reserva reserva);

    void delete(Reserva reserva);

    Reserva guardar(Reserva reserva);

    List<Reserva> listarPorUsuario(String usuario);

    void cambiarEstado(Long id);
}
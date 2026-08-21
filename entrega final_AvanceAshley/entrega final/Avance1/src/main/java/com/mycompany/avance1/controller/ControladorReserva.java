/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.controller;

import com.mycompany.avance1.model.Reserva;
import com.mycompany.avance1.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorReserva {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/reserva")
    public String mostrarFormulario(
            @RequestParam(required = false) String cancha,
            Model model,
            HttpSession session) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        Reserva reserva = new Reserva();

        if (cancha != null) {
            reserva.setCanchaNombre(cancha);
        }

        model.addAttribute("reserva", reserva);
        model.addAttribute("cancha", cancha);

        return "reserva";
    }

    @PostMapping("/reservas/guardar")
    public String guardarReserva(
            @ModelAttribute("reserva") Reserva reserva,
            HttpSession session,
            Model model) {

        String usuario =
                (String) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        reserva.setUsuario(usuario);

        Reserva guardada =
                reservaService.guardar(reserva);

        model.addAttribute("reserva", guardada);

        return "confirmacionReserva";
    }

    @GetMapping("/misReservas")
    public String mostrarMisReservas(
            HttpSession session,
            Model model) {

        String usuario =
                (String) session.getAttribute("usuario");

        if (usuario == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "misReservas",
                reservaService.listarPorUsuario(usuario));

        return "misReservas";
    }
}
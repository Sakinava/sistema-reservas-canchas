/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.controller;

import com.mycompany.avance1.service.CanchaService;
import com.mycompany.avance1.service.ReservaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorVistas {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private CanchaService canchaService;

    @GetMapping("/")
    public String inicio() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/menu")
    public String menu(HttpSession session) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        return "menu";
    }

    @GetMapping("/canchasDisponibles")
    public String canchasDisponibles(
            HttpSession session,
            Model model) {

        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "canchas",
                canchaService.getCanchas());

        return "canchasDisponibles";
    }

    @GetMapping("/confirmacionReserva")
    public String confirmacionReserva() {
        return "confirmacionReserva";
    }

    @GetMapping("/panelAdministrativo")
    public String panelAdministrativo(
            HttpSession session,
            Model model) {

        String rol = (String) session.getAttribute("rol");

        if (rol == null || !rol.equals("ADMIN")) {
            return "redirect:/menu";
        }

        model.addAttribute(
                "reservas",
                reservaService.getReservas());

        model.addAttribute(
                "canchas",
                canchaService.getCanchas());

        return "panelAdministrativo";
    }

    @PostMapping("/admin/canchas/disponibilidad/{id}")
    public String cambiarDisponibilidad(
            @PathVariable Long id,
            HttpSession session) {

        String rol = (String) session.getAttribute("rol");

        if (rol == null || !rol.equals("ADMIN")) {
            return "redirect:/menu";
        }

        canchaService.cambiarDisponibilidad(id);

        return "redirect:/panelAdministrativo";
    }

    @PostMapping("/admin/reservas/estado/{id}")
    public String cambiarEstadoReserva(
            @PathVariable Long id,
            HttpSession session) {

        String rol = (String) session.getAttribute("rol");

        if (rol == null || !rol.equals("ADMIN")) {
            return "redirect:/menu";
        }

        reservaService.cambiarEstado(id);

        return "redirect:/panelAdministrativo";
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }

}

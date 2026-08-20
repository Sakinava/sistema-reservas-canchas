/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorVistas {

    @GetMapping("/")
    public String inicio() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/canchasDisponibles")
    public String canchasDisponibles() {
        return "canchasDisponibles";
    }

    @GetMapping("/formularioReserva")
    public String formularioReserva() {
        return "formularioReserva";
    }

    @GetMapping("/misReservas")
    public String misReservas() {
        return "misReservas";
    }

    @GetMapping("/confirmacionReserva")
    public String confirmacionReserva() {
        return "confirmacionReserva";
    }

    @GetMapping("/panelAdministrativo")
public String panelAdministrativo(HttpSession session) {

    System.out.println("ROL GUARDADO = " + session.getAttribute("rol"));

    String rol = (String) session.getAttribute("rol");

    if (rol == null || !rol.equals("ADMIN")) {
        return "redirect:/menu";
    }

    return "panelAdministrativo";
}
    
    
}

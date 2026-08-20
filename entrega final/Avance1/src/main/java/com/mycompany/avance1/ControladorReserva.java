/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1;

import com.mycompany.avance1.Cancha;
import com.mycompany.avance1.Reserva;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ashle
 */
@Controller
public class ControladorReserva {
    
     // RUTA 1
    @GetMapping("/canchas")
    public String listarCanchas(Model model) {
        List<Cancha> lista = new ArrayList<>();
        lista.add(new Cancha(1L, "Cancha 1 - Techada", 4, "Sintético verde", true));
        lista.add(new Cancha(2L, "Cancha 2 - Al aire libre", 4, "Cemento azul", false));
        lista.add(new Cancha(3L, "Cancha 3 - Premium", 4, "Alfombra profesional", true));

        model.addAttribute("listaSimulada", lista); // 'listaSimulada' coincide con el th:each de tu HTML
        return "canchas";
    }

    // RUTA 2
    @GetMapping("/reservas/nueva")
    public String nuevoFormulario(Model model) {
        model.addAttribute("reservaSimulada", new Reserva());
        model.addAttribute("cancha", new Cancha(1L, "Cancha 1 - Techada", 4, "Sintético verde", true));
        return "nueva-reserva";
    }

    // RUTA 3
    @PostMapping("/reservas/guardar")
    public String guardar(@ModelAttribute("reservaSimulada") Reserva reserva) {
        // Aquí capturas lo que el usuario escribió
        System.out.println("Fecha elegida: " + reserva.getFecha());
        return "exito"; // Abre exito.html directamente
    }

    // RUTA 4
    @GetMapping("/reservas/mis-reservas")
    public String misReservas(Model model) {
        List<Reserva> misRes = new ArrayList<>();
        misRes.add(new Reserva(1L, "#RES-0038", "juan123", "Cancha 1 - Techada", "12/06/2026", "18:00 - 19:00", 2, "Confirmada"));
        misRes.add(new Reserva(2L, "#RES-0031", "juan123", "Cancha 3 - Premium", "08/06/2025", "17:00 - 18:00", 2, "Cancelada"));

        model.addAttribute("listaReservasSimuladas", misRes);
        return "mis-reservas";
    }

    // RUTA 5
    @GetMapping("/admin")
    public String panelAdmin(Model model) {
        List<Reserva> todas = new ArrayList<>();
        todas.add(new Reserva(1L, "#RES-0042", "juan123", "Cancha 1 - Techada", "18/06/2026", "18:00 - 19:00", 4, "Confirmada"));
        todas.add(new Reserva(2L, "#RES-0043", "pedro88", "Cancha 2 - Al aire libre", "19/06/2026", "19:00 - 20:00", 4, "Cancelada"));

        model.addAttribute("tablaGlobalSimulada", todas);

        List<Cancha> canchasAdmin = new ArrayList<>();
        canchasAdmin.add(new Cancha(1L, "Cancha 1 - Techada", 4, "Sintético verde", true));
        model.addAttribute("canchasAdminSimuladas", canchasAdmin);

        return "admin";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.controller;

import com.mycompany.avance1.Usuario;
import com.mycompany.avance1.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
public String login(
        @RequestParam String username,
        @RequestParam String password,
        HttpSession session) {

    System.out.println("Username recibido: " + username);
    System.out.println("Password recibido: " + password);

    Usuario usuario = usuarioService.getUsuarioPorUsername(username);

    System.out.println("Usuario encontrado: " + usuario);

    if (usuario != null &&
            usuario.getPassword().equals(password)) {

        session.setAttribute("usuario", usuario.getUsername());
        session.setAttribute("rol", usuario.getRol());

        System.out.println("ROL GUARDADO: " + usuario.getRol());

        return "redirect:/menu";
    }

    return "redirect:/login";
}
}


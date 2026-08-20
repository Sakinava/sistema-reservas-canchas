package com.padelapp.sistema_reserva.controller;

import com.padelapp.sistema_reserva.model.Usuario;
import com.padelapp.sistema_reserva.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
 
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario crear( @Valid @RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PutMapping("/{id}")
    public Usuario editar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.editar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
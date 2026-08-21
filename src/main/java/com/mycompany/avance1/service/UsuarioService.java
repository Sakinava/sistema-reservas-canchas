/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service;

import com.mycompany.avance1.Usuario;
import java.util.List;

public interface UsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(Long id);

    public Usuario getUsuarioPorUsername(String username);

    public void save(Usuario usuario);

    public void delete(Usuario usuario);
}

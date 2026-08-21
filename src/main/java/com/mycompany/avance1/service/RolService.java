/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.avance1.service;

import com.mycompany.avance1.Rol;
import java.util.List;

public interface RolService {

    public List<Rol> getRoles();

    public Rol getRol(Long id);

    public void save(Rol rol);

    public void delete(Rol rol);
}

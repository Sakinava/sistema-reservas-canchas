package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
@NotBlank
@Entity
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    @OneToMany(mappedBy = "rol")
    private java.util.List<Usuario> usuarios;
}
package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "rol")
@Data
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre del rol es obligatorio")
    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}
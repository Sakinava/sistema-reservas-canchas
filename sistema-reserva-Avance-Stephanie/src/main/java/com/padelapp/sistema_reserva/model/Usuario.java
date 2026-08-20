package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;
    
    @Email(message = "Debe ser un email válido")
    @NotBlank(message = "El email es obligatorio")
    @Column(nullable = false, unique = true)
    private String email;
    
    @NotBlank(message = "La contraseña es obligatoria")
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
    
    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;
}
package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import jakarta.validation.constraints.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "El ID es obligatorio")
    private Long id;
    private String nombre;
    private String email;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
    
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;
}
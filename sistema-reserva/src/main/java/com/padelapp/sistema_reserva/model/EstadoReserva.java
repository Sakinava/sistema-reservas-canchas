package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;

@Entity
@Data
@NotBlank
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @OneToMany(mappedBy = "estado")
    private java.util.List<Reserva> reservas;
}
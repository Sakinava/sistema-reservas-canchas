package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "estado_reserva")
@Data
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "estado")
    private List<Reserva> reservas;
}
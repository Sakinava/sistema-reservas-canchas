package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
@Entity
@Data
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "El ID es obligatorio")
    private Long id;

    private String nombre;
    
    @ManyToOne
    private TipoCancha tipoCancha;
}
package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
@Entity
@Data
public class TipoCancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    private String Nombre;
}
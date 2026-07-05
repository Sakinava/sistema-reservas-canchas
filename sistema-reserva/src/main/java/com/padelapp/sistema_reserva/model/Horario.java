package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
@Entity
@Data
public class Horario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "La hora de inicio es obligatoria")
    private String horaInicio;
    @NotBlank(message = "La hora de finalización es obligatoria")
    private String horaFin;
    
@OneToMany(mappedBy = "horario")
private java.util.List<Reserva> reservas;
}
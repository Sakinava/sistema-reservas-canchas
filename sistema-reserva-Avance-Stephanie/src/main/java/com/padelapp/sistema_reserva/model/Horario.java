package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "horario")
@Data
public class Horario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La hora de inicio es obligatoria")
    @Column(nullable = false)
    private String horaInicio;

    @NotBlank(message = "La hora de finalización es obligatoria")
    @Column(nullable = false)
    private String horaFin;
    
    @OneToMany(mappedBy = "horario")
    private List<Reserva> reservas;
}
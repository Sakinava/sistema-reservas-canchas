package com.mycompany.avance1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
}
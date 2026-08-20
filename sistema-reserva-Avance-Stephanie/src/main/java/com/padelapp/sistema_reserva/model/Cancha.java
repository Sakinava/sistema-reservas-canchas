package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "cancha")
@Data
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la cancha es obligatorio")
    @Column(nullable = false)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "tipo_cancha_id", nullable = false)
    private TipoCancha tipoCancha;
}
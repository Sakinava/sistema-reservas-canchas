package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import jakarta.validation.constraints.*;
@Entity
@Data
public class Reserva {
    @NotBlank(message = "El ID es obligatorio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate fecha;
    
    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Cancha cancha;
    
    @ManyToOne
    private Horario horario;
    
    @ManyToOne
    private EstadoReserva estado;
}
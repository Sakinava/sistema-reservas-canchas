package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;  
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Data
public class AuditoriaReserva { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "El ID es obligatorio")
    private Long id;
 
    private String accion;
    private LocalDateTime fechaCambio;
    
    @ManyToOne
    private Reserva reserva;
}
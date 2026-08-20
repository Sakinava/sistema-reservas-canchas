package com.padelapp.sistema_reserva.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "reserva")
@Data
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La fecha es obligatoria")
    @Column(nullable = false)
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "cancha_id", nullable = false)
    private Cancha cancha;
    
    @ManyToOne
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;
    
    @ManyToOne
    @JoinColumn(name = "estado_reserva_id", nullable = false)
    private EstadoReserva estado;
}
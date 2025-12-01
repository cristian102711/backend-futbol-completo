package com.example.mspartidos;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Long rivalId; // ID del rival contra quien jugamos
    private int golesFavor;
    private int golesContra;

    // Resultado calculado o guardado (Ganado, Perdido, Empatado)
    private String resultado;
}
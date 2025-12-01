package com.example.msjugadores;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int edad;
    private int dorsal;      // Número de camiseta
    private String posicion; // Ej: Delantero, Portero

    // VITAL: Para saber en qué equipo juega (Relación Lógica)
    private Long equipoId;
}
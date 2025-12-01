package com.example.msequipos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String entrenador;
    private String escudoUrl; // Para guardar la imagen del equipo
}
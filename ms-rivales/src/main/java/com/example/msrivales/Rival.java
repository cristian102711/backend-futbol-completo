package com.example.msrivales;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    // Puedes agregar más campos si quieres, pero con esto basta para probar
}
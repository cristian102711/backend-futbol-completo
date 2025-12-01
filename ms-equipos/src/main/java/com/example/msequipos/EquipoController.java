package com.example.msequipos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repositorio
interface EquipoRepository extends JpaRepository<Equipo, Long> {}

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoRepository repositorio;

    @GetMapping
    public List<Equipo> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Equipo guardar(@RequestBody Equipo equipo) {
        return repositorio.save(equipo);
    }

    // Método extra: Buscar por ID (útil para detalles)
    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Long id) {
        return repositorio.findById(id).orElse(null);
    }
}
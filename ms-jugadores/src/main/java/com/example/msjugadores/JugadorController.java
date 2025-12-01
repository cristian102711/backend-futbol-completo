package com.example.msjugadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.stream.Collectors;

// Repositorio
interface JugadorRepository extends JpaRepository<Jugador, Long> {}

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository repositorio;

    // Listar todos
    @GetMapping
    public List<Jugador> listar() {
        return repositorio.findAll();
    }

    // Guardar uno nuevo
    @PostMapping
    public Jugador guardar(@RequestBody Jugador jugador) {
        return repositorio.save(jugador);
    }

    // Buscar por ID de Equipo (¡Para la App!)
    // Ejemplo de uso: GET http://localhost:8083/jugadores/equipo/1
    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> listarPorEquipo(@PathVariable Long equipoId) {
        return repositorio.findAll().stream()
                .filter(j -> j.getEquipoId() != null && j.getEquipoId().equals(equipoId))
                .collect(Collectors.toList());
    }
}
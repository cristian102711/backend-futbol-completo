package com.example.mspartidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

interface PartidoRepository extends JpaRepository<Partido, Long> {}

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoRepository repositorio;

    @GetMapping
    public List<Partido> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Partido guardar(@RequestBody Partido partido) {
        // Lógica simple para calcular resultado automático
        if (partido.getGolesFavor() > partido.getGolesContra()) {
            partido.setResultado("GANADO");
        } else if (partido.getGolesFavor() < partido.getGolesContra()) {
            partido.setResultado("PERDIDO");
        } else {
            partido.setResultado("EMPATADO");
        }
        return repositorio.save(partido);
    }
}
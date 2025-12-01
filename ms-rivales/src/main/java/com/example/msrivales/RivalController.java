package com.example.msrivales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repositorio express
interface RivalRepository extends JpaRepository<Rival, Long> {}

@RestController
@RequestMapping("/rivales")
public class RivalController {

    @Autowired
    private RivalRepository repositorio;

    @GetMapping
    public List<Rival> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Rival guardar(@RequestBody Rival rival) {
        return repositorio.save(rival);
    }
}
package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/canciones")
public class CancionController {

    private List<Cancion> canciones = new ArrayList<>(List.of(
            new Cancion(1L, "Aún así te quiero", "teo LB"),
            new Cancion(2L, "Con una sola me basta", "teo LB")
    ));

    @GetMapping
    public List<Cancion> listar() {
        return canciones;
    }

    @PostMapping
    public Cancion crear(@RequestBody Cancion nueva) {
        canciones.add(nueva);
        return nueva;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        canciones.removeIf(c -> c.id.equals(id));
        return "Borrada";
    }
}
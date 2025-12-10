package com.obligatorio2dda.obligatorio2dda.controller;

import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;
import com.obligatorio2dda.obligatorio2dda.service.ContenidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public ResponseEntity<ArrayList<ContenidoEntity>> getContenidos() {
        return ResponseEntity.ok(contenidoService.getContenidos());
    }

    @PostMapping
    public ResponseEntity<ContenidoEntity> postContenido(@Valid @RequestBody ContenidoEntity contenido) {
        return ResponseEntity.ok(contenidoService.postContenido(contenido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoEntity> getContenido(@PathVariable int id) {
        ContenidoEntity contenido = contenidoService.getContenido(id);
        if (contenido != null) {
            return ResponseEntity.ok(contenido);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContenidoEntity> putContenido(@PathVariable int id, @Valid @RequestBody ContenidoEntity contenido) {
        ContenidoEntity updated = contenidoService.putContenido(id, contenido);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContenido(@PathVariable int id) {
        if (contenidoService.deleteContenido(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/reproducciones/minimas/{n}")
    public ArrayList<ContenidoEntity> getContenidosConMasDeN(@PathVariable int n) {
        return contenidoService.getContenidosConMasDeNReproducciones(n);
    }

    @GetMapping("/reproducidos")
    public ArrayList<ContenidoEntity> obtenerContenidosReproducidos(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
    return contenidoService.obtenerContenidosReproducidosEnFecha(fecha);
    }


}
package com.obligatorio2dda.obligatorio2dda.controller;

import com.obligatorio2dda.obligatorio2dda.dto.ReproduccionDTO;
import com.obligatorio2dda.obligatorio2dda.entity.ReproduccionEntity;
import com.obligatorio2dda.obligatorio2dda.service.ReproduccionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/reproducciones")
public class ReproduccionController {

    @Autowired
    private ReproduccionService reproduccionService;

    @PostMapping
    public ResponseEntity<ReproduccionEntity> postReproduccion(@Valid @RequestBody ReproduccionDTO dto) {
        return ResponseEntity.ok(reproduccionService.postReproduccion(dto));
    }



    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<ArrayList<ReproduccionEntity>> getReproduccionesByUsuario(@PathVariable int idUsuario) {
        return ResponseEntity.ok(reproduccionService.getReproduccionesByUsuario(idUsuario));
    }

    @GetMapping("/contenidos/{id}/promedio-calificaciones")
    public ResponseEntity<?> obtenerPromedioCalificaciones(@PathVariable int id) {
        Double promedio = reproduccionService.obtenerPromedioCalificacion(id);
        return ResponseEntity.ok(promedio != null ? promedio : 0);
    }

}
package com.obligatorio2dda.obligatorio2dda.controller;

import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEntity;
import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEstandarEntity;
import com.obligatorio2dda.obligatorio2dda.entity.UsuarioPremiumEntity;
import com.obligatorio2dda.obligatorio2dda.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/estandar")
    public ResponseEntity<UsuarioEntity> postUsuarioEstandar(@Valid @RequestBody UsuarioEstandarEntity usuario) {
        return ResponseEntity.ok(usuarioService.postUsuario(usuario));
    }

    @PostMapping("/premium")
    public ResponseEntity<UsuarioEntity> postUsuarioPremium(@Valid @RequestBody UsuarioPremiumEntity usuario) {
        return ResponseEntity.ok(usuarioService.postUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<ArrayList<UsuarioEntity>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> getUsuario(@PathVariable int id) {
        UsuarioEntity usuario = usuarioService.getUsuario(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEntity> putUsuario(@PathVariable int id, @Valid @RequestBody UsuarioEntity usuario) {
        UsuarioEntity updated = usuarioService.putUsuario(id, usuario);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
        if (usuarioService.deleteUsuario(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/filtrar")
    public ArrayList<UsuarioEntity> filtrarUsuarios(
        @RequestParam(required = false) String tipo,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        return usuarioService.filtrarUsuarios(tipo, desde, hasta);
    }

}
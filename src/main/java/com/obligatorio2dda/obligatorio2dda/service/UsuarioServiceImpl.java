package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEntity;
import com.obligatorio2dda.obligatorio2dda.entity.UsuarioPremiumEntity;
import com.obligatorio2dda.obligatorio2dda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ArrayList<UsuarioEntity> getUsuarios() {
        return new ArrayList<>(usuarioRepository.findAll());
    }

    @Override
    public UsuarioEntity postUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity getUsuario(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioEntity putUsuario(int id, UsuarioEntity usuario) {
        UsuarioEntity existing = usuarioRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setNombreCompleto(usuario.getNombreCompleto());
            existing.setEmail(usuario.getEmail());
            existing.setFechaRegistro(usuario.getFechaRegistro());
            if (existing instanceof UsuarioPremiumEntity && usuario instanceof UsuarioPremiumEntity) {
                ((UsuarioPremiumEntity) existing).setFechaInicioPremium(((UsuarioPremiumEntity) usuario).getFechaInicioPremium());
            }
            return usuarioRepository.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteUsuario(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<UsuarioEntity> filtrarUsuarios(String tipo, LocalDate desde, LocalDate hasta) {
        return usuarioRepository.filtrarUsuarios(tipo, desde, hasta);
    }
}
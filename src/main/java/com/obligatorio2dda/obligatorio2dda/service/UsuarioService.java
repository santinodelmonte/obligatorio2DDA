package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public interface UsuarioService {
    public ArrayList<UsuarioEntity> getUsuarios();
    public UsuarioEntity postUsuario(UsuarioEntity usuario);
    public UsuarioEntity getUsuario(int id);
    public UsuarioEntity putUsuario(int id, UsuarioEntity usuario);
    public boolean deleteUsuario(int id);
    public ArrayList<UsuarioEntity> filtrarUsuarios(String tipo, LocalDate desde, LocalDate hasta);

}
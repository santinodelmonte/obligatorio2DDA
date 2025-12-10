package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.dto.ReproduccionDTO;
import com.obligatorio2dda.obligatorio2dda.entity.ReproduccionEntity;
import java.util.ArrayList;

public interface ReproduccionService {
    public ArrayList<ReproduccionEntity> getReproducciones();
    public ReproduccionEntity postReproduccion(ReproduccionDTO dto);
    public ReproduccionEntity getReproduccion(int id);
    public ArrayList<ReproduccionEntity> getReproduccionesByUsuario(int usuarioId);
    public Double obtenerPromedioCalificacion(int contenidoId);
    
}
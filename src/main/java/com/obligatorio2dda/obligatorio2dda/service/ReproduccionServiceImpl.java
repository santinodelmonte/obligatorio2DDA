package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.dto.ReproduccionDTO;
import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;
import com.obligatorio2dda.obligatorio2dda.entity.ReproduccionEntity;
import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEntity;
import com.obligatorio2dda.obligatorio2dda.entity.UsuarioPremiumEntity;
import com.obligatorio2dda.obligatorio2dda.repository.ContenidoRepository;
import com.obligatorio2dda.obligatorio2dda.repository.ReproduccionRepository;
import com.obligatorio2dda.obligatorio2dda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ReproduccionServiceImpl implements ReproduccionService {

    @Autowired
    private ReproduccionRepository reproduccionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Override
    public ArrayList<ReproduccionEntity> getReproducciones() {
        return (ArrayList<ReproduccionEntity>) reproduccionRepository.findAll();
    }

    @Override
    public ReproduccionEntity postReproduccion(ReproduccionDTO dto) {
    UsuarioEntity usuario = usuarioRepository.findById(dto.usuarioId).orElse(null);
    ContenidoEntity contenido = contenidoRepository.findById(dto.contenidoId).orElse(null);

    if (usuario == null || contenido == null) {
        throw new IllegalArgumentException("Usuario o contenido no encontrado");
    }

    if (contenido.isExclusivoPremium() && !(usuario instanceof UsuarioPremiumEntity)) {
        throw new IllegalArgumentException("Usuario estándar no puede reproducir contenido exclusivo premium");
    }
    ReproduccionEntity reproduccion = new ReproduccionEntity();
    reproduccion.setUsuario(usuario);
    reproduccion.setContenido(contenido);
    reproduccion.setFechaHora(dto.fechaHora);
    reproduccion.setDuracionReproducidaMinutos(dto.duracionReproducidaMinutos);
    reproduccion.setCalificacion(dto.calificacion);
    return reproduccionRepository.save(reproduccion);
}


    @Override
    public ReproduccionEntity getReproduccion(int id) {
        return reproduccionRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<ReproduccionEntity> getReproduccionesByUsuario(int usuarioId) {
        return (ArrayList<ReproduccionEntity>) reproduccionRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public Double obtenerPromedioCalificacion(int contenidoId) {
        return reproduccionRepository.obtenerPromedioCalificacion(contenidoId);
    }

}
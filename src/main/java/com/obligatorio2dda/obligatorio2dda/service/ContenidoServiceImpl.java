package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;
import com.obligatorio2dda.obligatorio2dda.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


@Service
public class ContenidoServiceImpl implements ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Override
    public ArrayList<ContenidoEntity> getContenidos() {
        return (ArrayList<ContenidoEntity>) contenidoRepository.findAll();
    }

    @Override
    public ContenidoEntity postContenido(ContenidoEntity contenido) {
        return contenidoRepository.save(contenido);
    }

    @Override
    public ContenidoEntity getContenido(int id) {
        return contenidoRepository.findById(id).orElse(null);
    }

    @Override
    public ContenidoEntity putContenido(int id, ContenidoEntity contenido) {
        ContenidoEntity existing = contenidoRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitulo(contenido.getTitulo());
            existing.setDescripcion(contenido.getDescripcion());
            existing.setCategoria(contenido.getCategoria());
            existing.setDuracionMinutos(contenido.getDuracionMinutos());
            existing.setAnioEstreno(contenido.getAnioEstreno());
            existing.setExclusivoPremium(contenido.isExclusivoPremium());
            existing.setPrecio(contenido.getPrecio());
            return contenidoRepository.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteContenido(int id) {
        if (contenidoRepository.existsById(id)) {
            contenidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<ContenidoEntity> getContenidosConMasDeNReproducciones(int n) {
        return contenidoRepository.findContenidosConMasDeNReproducciones(n);
    }

    @Override
    public ArrayList<ContenidoEntity> obtenerContenidosReproducidosEnFecha(LocalDate fecha) {
    LocalDateTime start = fecha.atStartOfDay();
    LocalDateTime end = fecha.atTime(LocalTime.MAX);
    return contenidoRepository.obtenerContenidosReproducidosEnFecha(start, end);

    }

}
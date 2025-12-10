package com.obligatorio2dda.obligatorio2dda.service;

import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ContenidoService {
    public ArrayList<ContenidoEntity> getContenidos();
    public ContenidoEntity postContenido(ContenidoEntity contenido);
    public ContenidoEntity getContenido(int id);
    public ContenidoEntity putContenido(int id, ContenidoEntity contenido);
    public boolean deleteContenido(int id);
    public ArrayList<ContenidoEntity> getContenidosConMasDeNReproducciones(int n);
    public ArrayList<ContenidoEntity> obtenerContenidosReproducidosEnFecha(LocalDate fecha);
    

}
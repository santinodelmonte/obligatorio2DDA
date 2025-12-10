package com.obligatorio2dda.obligatorio2dda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Table(name = "reproducciones")
public class ReproduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "El usuario no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @NotNull(message = "El contenido no puede ser nulo")
    @ManyToOne
    @JoinColumn(name = "contenido_id")
    private ContenidoEntity contenido;

    @NotNull(message = "La fecha y hora no puede ser nula")
    private LocalDateTime fechaHora;

    @NotNull(message = "La duración reproducida no puede ser nula")
    @Min(value = 0, message = "La duración reproducida debe ser mayor o igual a 0")
    private int duracionReproducidaMinutos;

    @NotNull(message = "La calificación no puede ser nula")
    @Min(value = 1, message = "La calificación debe ser al menos 1")
    @Max(value = 5, message = "La calificación debe ser como máximo 5")
    private int calificacion;

    
    public ReproduccionEntity() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public ContenidoEntity getContenido() {
        return contenido;
    }

    public void setContenido(ContenidoEntity contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getDuracionReproducidaMinutos() {
        return duracionReproducidaMinutos;
    }

    public void setDuracionReproducidaMinutos(int duracionReproducidaMinutos) {
        this.duracionReproducidaMinutos = duracionReproducidaMinutos;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
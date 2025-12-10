package com.obligatorio2dda.obligatorio2dda.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "contenidos")
public class ContenidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;

    @NotNull(message = "La duración no puede ser nula")
    @Positive(message = "La duración debe ser positiva")
    private int duracionMinutos;

    @NotNull(message = "El año de estreno no puede ser nulo")
    @Min(value = 1900, message = "El año de estreno debe ser mayor a 1900")
    private int anioEstreno;

    @NotNull(message = "El campo exclusivo premium no puede ser nulo")
    private boolean exclusivoPremium;

    @NotNull
    @Min(value = 0, message = "El precio no puede ser negativo")
    private Double precio;

    
    public ContenidoEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public boolean isExclusivoPremium() {
        return exclusivoPremium;
    }

    public void setExclusivoPremium(boolean exclusivoPremium) {
        this.exclusivoPremium = exclusivoPremium;
    }

    public Double getPrecio() { return precio; }

    public void setPrecio(Double precio) {
        this.precio = precio; 
    }
}
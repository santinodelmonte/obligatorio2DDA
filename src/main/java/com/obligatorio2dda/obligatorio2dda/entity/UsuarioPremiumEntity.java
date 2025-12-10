package com.obligatorio2dda.obligatorio2dda.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("PREMIUM")
public class UsuarioPremiumEntity extends UsuarioEntity {

    @NotNull(message = "La fecha de inicio premium no puede ser nula")
    private LocalDate fechaInicioPremium;

    public UsuarioPremiumEntity() {}

    public LocalDate getFechaInicioPremium() {
        return fechaInicioPremium;
    }

    public void setFechaInicioPremium(LocalDate fechaInicioPremium) {
        this.fechaInicioPremium = fechaInicioPremium;
    }
}
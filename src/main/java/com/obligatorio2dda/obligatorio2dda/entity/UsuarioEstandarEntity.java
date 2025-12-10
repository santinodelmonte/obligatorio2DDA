package com.obligatorio2dda.obligatorio2dda.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ESTANDAR")
public class UsuarioEstandarEntity extends UsuarioEntity {

 
    public UsuarioEstandarEntity() {}
}
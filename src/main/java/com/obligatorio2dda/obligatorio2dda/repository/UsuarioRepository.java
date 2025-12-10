package com.obligatorio2dda.obligatorio2dda.repository;

import com.obligatorio2dda.obligatorio2dda.entity.UsuarioEntity;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    @Query("""
    SELECT u FROM UsuarioEntity u
    WHERE 
       (:tipo IS NULL OR 
            ( :tipo = 'ESTANDAR' AND TYPE(u) = UsuarioEstandarEntity ) OR
            ( :tipo = 'PREMIUM' AND TYPE(u) = UsuarioPremiumEntity )
       )
    AND (:desde IS NULL OR u.fechaRegistro >= :desde)
    AND (:hasta IS NULL OR u.fechaRegistro <= :hasta)
    """)
    ArrayList<UsuarioEntity> filtrarUsuarios(
        @Param("tipo") String tipo,
        @Param("desde") LocalDate desde,
        @Param("hasta") LocalDate hasta
    );

}

package com.obligatorio2dda.obligatorio2dda.repository;

import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;
import com.obligatorio2dda.obligatorio2dda.entity.ReproduccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ReproduccionRepository extends JpaRepository<ReproduccionEntity, Integer> {

    List<ReproduccionEntity> findByUsuarioId(int usuarioId);

    @Query("""
        SELECT c FROM ContenidoEntity c
        WHERE (SELECT COUNT(r)
               FROM ReproduccionEntity r
               WHERE r.contenido.id = c.id) > :minReproducciones
    """)
    List<ContenidoEntity> findContenidosConMasDeNReproducciones(
            @Param("minReproducciones") int minReproducciones);

    @Query("""
        SELECT AVG(r.calificacion)
        FROM ReproduccionEntity r
        WHERE r.contenido.id = :contenidoId
    """)
    Double obtenerPromedioCalificacion(@Param("contenidoId") int contenidoId);
}

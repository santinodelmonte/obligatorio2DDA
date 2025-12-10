package com.obligatorio2dda.obligatorio2dda.repository;

import com.obligatorio2dda.obligatorio2dda.entity.ContenidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Repository
public interface ContenidoRepository extends JpaRepository<ContenidoEntity, Integer> {
    
    @Query("""
        SELECT c FROM ContenidoEntity c
        WHERE (SELECT COUNT(r2) FROM ReproduccionEntity r2 WHERE r2.contenido = c) > :minReproducciones
    """)
    ArrayList<ContenidoEntity> findContenidosConMasDeNReproducciones(
            @Param("minReproducciones") int minReproducciones);


    @Query("""
    SELECT DISTINCT c FROM ContenidoEntity c
    JOIN ReproduccionEntity r ON r.contenido.id = c.id
    WHERE r.fechaHora BETWEEN :start AND :end
    """)
    ArrayList<ContenidoEntity> obtenerContenidosReproducidosEnFecha(
        @Param("start") LocalDateTime start,
        @Param("end") LocalDateTime end);

}
 
package com.example.koztos_backend.repository;

import com.example.koztos_backend.model.Gasto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    @Query("SELECT g FROM Gasto g WHERE " +
            "(:local IS NULL OR g.local = :local) AND " +
            "(:moneda IS NULL OR g.moneda = :moneda) AND " +
            "(:fechaInicio IS NULL OR g.fechaRegistro >= :fechaInicio) AND " +
            "(:fechaFin IS NULL OR g.fechaRegistro <= :fechaFin) AND " +
            "(:busqueda IS NULL OR g.descripcion LIKE %:busqueda% OR g.documentoNumero LIKE %:busqueda%)")
    Page<Gasto> findByFiltros(
            @Param("local") String local,
            @Param("moneda") String moneda,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin,
            @Param("busqueda") String busqueda,
            Pageable pageable);
}

package com.example.koztos_backend.service;

import com.example.koztos_backend.model.Gasto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

public interface GastoService {
    Page<Gasto> listar(String local, String moneda, LocalDate fechaInicio, LocalDate fechaFin, String busqueda, Pageable pageable);
    Gasto crear(Gasto gasto);
    Gasto actualizar(Long id, Gasto gastoDetalles);
    void eliminar(Long id);
}

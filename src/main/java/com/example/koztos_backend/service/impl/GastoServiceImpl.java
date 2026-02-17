package com.example.koztos_backend.service.impl;
import com.example.koztos_backend.exceptions.ResourceNotFoundException;
import com.example.koztos_backend.model.Gasto;
import com.example.koztos_backend.repository.GastoRepository;
import com.example.koztos_backend.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Service
@RequiredArgsConstructor
public class GastoServiceImpl implements GastoService {

    private final GastoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<Gasto> listar(String local, String moneda, LocalDate fechaInicio, LocalDate fechaFin, String busqueda, Pageable pageable) {
        return repository.findByFiltros(local, moneda, fechaInicio, fechaFin, busqueda, pageable);
    }

    @Override
    @Transactional
    public Gasto crear(Gasto gasto) {
        gasto.setFechaRegistro(LocalDate.now());
        gasto.setEstado("Activo");
        return repository.save(gasto);
    }

    @Override
    @Transactional
    public Gasto actualizar(Long id, Gasto gastoDetalles) {
        Gasto gasto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Gasto no encontrado con id: " + id));

        gasto.setLocal(gastoDetalles.getLocal());
        gasto.setFechaEmision(gastoDetalles.getFechaEmision());
        gasto.setTipoGasto(gastoDetalles.getTipoGasto());
        gasto.setPersonaAfectada(gastoDetalles.getPersonaAfectada());
        gasto.setCondicion(gastoDetalles.getCondicion());
        gasto.setGravable(gastoDetalles.getGravable());
        gasto.setDocumentoSerie(gastoDetalles.getDocumentoSerie());
        gasto.setDocumentoNumero(gastoDetalles.getDocumentoNumero());
        gasto.setMoneda(gastoDetalles.getMoneda());
        gasto.setMedioPago(gastoDetalles.getMedioPago());
        gasto.setCuenta(gastoDetalles.getCuenta());
        gasto.setDescripcion(gastoDetalles.getDescripcion());
        gasto.setSubtotal(gastoDetalles.getSubtotal());
        gasto.setImpuesto(gastoDetalles.getImpuesto());
        gasto.setTotal(gastoDetalles.getTotal());

        return repository.save(gasto);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

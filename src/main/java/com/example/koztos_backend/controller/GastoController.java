package com.example.koztos_backend.controller;

import com.example.koztos_backend.model.Gasto;
import com.example.koztos_backend.service.GastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService service;

    @GetMapping
    public ResponseEntity<Page<Gasto>> listar(
            @RequestParam(required = false) String local,
            @RequestParam(required = false) String moneda,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin,
            @RequestParam(required = false) String busqueda,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Gasto> resultado = service.listar(local, moneda, fechaInicio, fechaFin, busqueda, pageable);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Gasto> crear(@RequestBody Gasto gasto) {
        return new ResponseEntity<>(service.crear(gasto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> actualizar(@PathVariable Long id, @RequestBody Gasto gastoDetalles) {
        return ResponseEntity.ok(service.actualizar(id, gastoDetalles));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

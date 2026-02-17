package com.example.koztos_backend.controller;
import com.example.koztos_backend.model.TipoGasto;
import com.example.koztos_backend.service.TipoGastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tipo-gasto")
@RequiredArgsConstructor
public class TipoGastoController {
    private final TipoGastoService service;

    @GetMapping
    public ResponseEntity<List<TipoGasto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<TipoGasto> crear(@RequestBody TipoGasto tipoGasto) {
        return new ResponseEntity<>(service.crear(tipoGasto), HttpStatus.CREATED);
    }
}

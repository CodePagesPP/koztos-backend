package com.example.koztos_backend.service;


import com.example.koztos_backend.model.TipoGasto;

import java.util.List;

public interface TipoGastoService {
    List<TipoGasto> listarTodos();
    TipoGasto crear(TipoGasto tipoGasto);
}

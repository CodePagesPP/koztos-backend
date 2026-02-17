package com.example.koztos_backend.service.impl;
import com.example.koztos_backend.model.TipoGasto;
import com.example.koztos_backend.repository.TipoGastoRepository;
import com.example.koztos_backend.service.TipoGastoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TipoGastoServiceImpl implements TipoGastoService {

    private final TipoGastoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoGasto> listarTodos() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public TipoGasto crear(TipoGasto tipoGasto) {
        return repository.save(tipoGasto);
    }
}

package com.example.koztos_backend.repository;


import com.example.koztos_backend.model.TipoGasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoGastoRepository extends JpaRepository<TipoGasto, Long> {
}

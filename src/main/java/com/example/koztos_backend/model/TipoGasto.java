package com.example.koztos_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipos_gasto")
public class TipoGasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String grupo;
    private String tipo;
}

package com.example.koztos_backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String local;
    private LocalDate fechaEmision;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "tipo_gasto_id")
    private TipoGasto tipoGasto;

    private String personaAfectada;
    private String condicion;
    private String gravable; // SI/NO
    private String documentoSerie;
    private String documentoNumero;
    private String moneda;
    private String medioPago;
    private String cuenta;
    private String descripcion;

    private BigDecimal subtotal;
    private BigDecimal impuesto;
    private BigDecimal total;

    private String usuario;
    private String estado;
}

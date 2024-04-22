package com.juan.apprifas.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
@Entity
@Table(name = "rifas")
public class RifaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrifa;
    @NotNull
    private String nombrerifa;
    @NotNull
    private Integer numeroganador;
    @NotNull
    private Integer idusuarioganador;
    @NotNull
    private Date fechasorteo;
    private Integer boletasrestantes;
    @NotNull
    private Boolean vendertodas;
    @NotNull
    private String premio;
}

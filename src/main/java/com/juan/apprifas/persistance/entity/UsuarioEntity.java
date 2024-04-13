package com.juan.apprifas.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @NotNull
    private String usuario;
    @NotNull
    private String contrasena;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private String email;
    private Date fechanacimiento;
    @NotNull
    private Boolean activo;
}

package com.juan.apprifas.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
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

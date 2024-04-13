package com.juan.apprifas.domain.pojo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * POJO de usuario
 */
@Getter
@Setter
public class UsuarioPojo {
    /**
     * Id de la tabla usuario
     */
    private Integer idusuario;
    /**
     * Nombre de usuario
     */
    private String usuario;
    /**
     * Contrasena del usuario
     */
    private String contrasena;
    /**
     * Nombres del usuario
     */
    private String nombres;
    /**
     * Apellidos del usuario
     */
    private String apellidos;
    /**
     * Email del usuario
     */
    private String email;
    /**
     * Fecha de nacimiento del usuario
     */
    private Date fechanacimiento;
    /**
     * Estado del usuario (1/0)
     */
    private Boolean activo;
}

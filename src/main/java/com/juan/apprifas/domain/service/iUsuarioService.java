package com.juan.apprifas.domain.service;

import com.juan.apprifas.domain.pojo.UsuarioPojo;

import java.util.List;
import java.util.Optional;

public interface iUsuarioService {
    /**
     * Devuelve una lista con todos los usuarios
     * @return Lista con todos los usuarios
     */
    List<UsuarioPojo> getAll();

    /**
     * Devuelve un usuario dado el id
     * @param id Id del usuario
     * @return Optional del usuario encontrado
     */
    //Sirve para tener cuidado de los NULL puede venir un objeto o puede venir null
    Optional<UsuarioPojo> getUsuario(Integer id);

    /**
     * Guarda un nuevo usuario
     * @param usuarioPojo Usuario a guardar
     * @return usuario guardado
     */
    //JPA repository no tiene metodo update entonces se utiliza el mismo metodo
    //Se reemplaza si tiene el mismo objeto
    UsuarioPojo save(UsuarioPojo usuarioPojo);

    /**
     * Elimina un usuario dado un id
     * @param id id del usuario a eliminar
     */
    Boolean delete(Integer id);
}

package com.juan.apprifas.persistance.mapper;

import com.juan.apprifas.domain.pojo.UsuarioPojo;
import com.juan.apprifas.persistance.entity.UsuarioEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma de objetos de usuario a pojos de entidades
 */
@Mapper(componentModel = "spring")
public interface iUsuarioMapper {
    /**
     * Convierte una entidad a un pojo de marca usuario
     * @param usuarioEntity
     * @return Pojo convertido
     */
    @Mapping(source = "idusuario", target = "idusuario")
    UsuarioPojo toUsuarioPojo(UsuarioEntity usuarioEntity);
    /**
     * Convierte un POJO a una entidad de marca usuario
     * @param usuarioPojo
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    UsuarioEntity toUsuarioEntity(UsuarioPojo usuarioPojo);

    /**
     * Retorna una lista de usuarios a pojo de una
     * @param usuarioEntities
     * @return lista de usuarios pojos
     */
    List<UsuarioPojo> toUsuariosPojo(List<UsuarioEntity> usuarioEntities);
}

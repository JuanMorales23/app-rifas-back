package com.juan.apprifas.persistance.repository;

import com.juan.apprifas.domain.pojo.UsuarioPojo;
import com.juan.apprifas.domain.repository.iUsuarioRepository;
import com.juan.apprifas.persistance.entity.UsuarioEntity;
import com.juan.apprifas.persistance.mapper.iUsuarioMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de Usuario
 */
@RequiredArgsConstructor
//También se puede utilizar la etiqueta @AllArgsConstructor pero toma todos los atributos para hacerlos
//como parte del constructor, con el otro solo los final
@Repository
public class UsuarioRepositoryImpl implements iUsuarioRepository {
    //El mapper se utiliza para castear los objetos
    private final iUsuarioCrudRepository iUsuarioCrudRepository;
    private final iUsuarioMapper iUsuarioMapper;
    //No es necesario el @Autowired, se considera redundante
    /*También se puede hacer el constructor gracias a Loombok utilizando la anotación
    @RequiredArgsConstructor pero necesita que tenga atributos final para hacer el constructor
    public UsuarioRepositoryImpl(com.juan.apprifas.persistance.repository.iUsuarioCrudRepository iUsuarioCrudRepository, com.juan.apprifas.persistance.mapper.iUsuarioMapper iUsuarioMapper) {
        this.iUsuarioCrudRepository = iUsuarioCrudRepository;
        this.iUsuarioMapper = iUsuarioMapper;
    }
     */

    /**
     * Devuelve una lista con todos los usuarios
     * @return Lista con todos los usuarios
     */
    @Override
    public List<UsuarioPojo> getAll() {
        return iUsuarioMapper.toUsuariosPojo(iUsuarioCrudRepository.findAll());
    }
    /**
     * Devuelve un usuario dado el id
     * @param id Id del usuario
     * @return Optional del usuario encontrado
     */
    @Override
    public Optional<UsuarioPojo> getUsuario(Integer id) {
        //Metodo por referencia
        return iUsuarioCrudRepository.findById(id).map(iUsuarioMapper::toUsuarioPojo);
        //Lambda
        //return iUsuarioCrudRepository.findById(id).map(usuarioEntity -> iUsuarioMapper.toUsuarioPojo(usuarioEntity));
        //Sería lo mismo que hacer un método por referencia
    }

    /**
     * Guarda un nuevo usuario
     * @param usuarioPojo Usuario a guardar
     * @return usuario guardado
     */
    @Override
    public UsuarioPojo save(UsuarioPojo usuarioPojo) {
        UsuarioEntity usuarioEntity = iUsuarioMapper.toUsuarioEntity(usuarioPojo);
        return iUsuarioMapper.toUsuarioPojo(iUsuarioCrudRepository.save(usuarioEntity));
    }

    /**
     * Elimina un usuario dado un id
     * @param id id del usuario a eliminar
     */
    @Override
    public void delete(Integer id) {
        iUsuarioCrudRepository.deleteById(id);
    }
}

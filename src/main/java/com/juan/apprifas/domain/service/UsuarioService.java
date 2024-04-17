package com.juan.apprifas.domain.service;

import com.juan.apprifas.domain.pojo.UsuarioPojo;
import com.juan.apprifas.domain.repository.iUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio de usuarios
 */
@RequiredArgsConstructor
@Service
public class UsuarioService implements iUsuarioService{

    /**
     * Repositorio de usuario
     */
    private final iUsuarioRepository iUsuarioRepository;

    /**
     * Devuelve una lista de usuarios
     * @return Lista de usuariopojo
     */
    @Override
    public List<UsuarioPojo> getAll() {
        return iUsuarioRepository.getAll();
    }

    /**
     * Devuelve un usuario buscado por id
     * @param id Id del usuario
     * @return Usuario (Opcional)
     */
    @Override
    public Optional<UsuarioPojo> getUsuario(Integer id) {
        return iUsuarioRepository.getUsuario(id);
    }

    /**
     * Guarda o actualiza un usuario
     * @param usuarioPojo Usuario a guardar
     * @return usuario guardado o actualizado
     */
    @Override
    public UsuarioPojo save(UsuarioPojo usuarioPojo) {
        return iUsuarioRepository.save(usuarioPojo);
    }

    /**
     * Borra un usuario y devuelve si fue eficaz o no
     * @param id id del usuario a eliminar
     * @return Boolean
     */
    @Override
    public Boolean delete(Integer id) {
        try{
            iUsuarioRepository.delete(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}

package com.juan.apprifas.controller;

import com.juan.apprifas.domain.pojo.UsuarioPojo;
import com.juan.apprifas.domain.service.iUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador rest de usuarios
 */
@RestController
@RequestMapping(path = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    /**
     * Servicio de usuario
     */
    private final iUsuarioService iUsuarioService;

    /**
     * Busca y devuelve todos los usuarios
     * @return Lista de usuarios
     */
    @GetMapping()
    public ResponseEntity<List<UsuarioPojo>> getAll(){
        //Se debe envolver para retornar también el estado de la transaccion
        return ResponseEntity.status(HttpStatus.OK).body(iUsuarioService.getAll());
        //Otra forma de hacerlo sería
        //return new ResponseEntity<>(iUsuarioService.getAll(), HttpStatus.OK);
        //return ResponseEntity.ok(iUsuarioService.getAll()); Otra forma
    }

    /**
     * Busca un usuario dado un id
     * @param id
     * @return Usuario que ha sido encontrado o NOT FOUND
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioPojo> getUsuario(@PathVariable Integer id){
        return ResponseEntity.of(iUsuarioService.getUsuario(id)); // el OF al mira si se trajeron registros
    }

    /**
     * Guarda un usuario
     * @param usuarioPojoNew
     * @return El usuario en caso de guardarlo o NULL en caso de error
     */
    @PostMapping()
    public ResponseEntity<UsuarioPojo> save(@RequestBody UsuarioPojo usuarioPojoNew){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(iUsuarioService.save(usuarioPojoNew));
    }

    /**
     * Actualiza todos los datos de un usuario
     * @param usuarioPojoUpdate
     * @return el usuario actualizado o not found
     */
    @PutMapping()
    public ResponseEntity<UsuarioPojo> update(@RequestBody UsuarioPojo usuarioPojoUpdate){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iUsuarioService.save(usuarioPojoUpdate));
    }

    /**
     * Borra un usuario dado un id
     * @param id
     * @return true o false
     */
    @DeleteMapping()
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iUsuarioService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

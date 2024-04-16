package com.juan.apprifas.persistance.repository;

import com.juan.apprifas.persistance.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUsuarioCrudRepository extends JpaRepository<UsuarioEntity, Integer> {

}

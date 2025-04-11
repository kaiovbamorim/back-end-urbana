package br.com.urbanape.urbana_pe.modules.usuario.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;

public interface UsuariosRepository extends JpaRepository<UsuarioEntity, UUID>{
    Optional<UsuarioEntity> findByEmail(String email);
}

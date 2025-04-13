package br.com.urbanape.urbana_pe.modules.usuario.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;

public interface UsuariosRepository extends JpaRepository<UsuarioEntity, UUID>{
    
    @Query(value = "SELECT * FROM usuario WHERE email = ?", nativeQuery = true)
    Optional<UsuarioEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM usuario WHERE id = ?", nativeQuery = true)
    Optional<UsuarioEntity> findById(UUID id);
    
}

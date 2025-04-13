package br.com.urbanape.urbana_pe.modules.cartao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID>{

    @Query(value = "SELECT * FROM cartao", nativeQuery = true)
    List<CartaoEntity> findAll();

    @Query(value = "SELECT * FROM cartao WHERE id_usuario = ?", nativeQuery = true)
    List<CartaoEntity> findByIdUsuario(UUID id);

}
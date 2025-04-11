package br.com.urbanape.urbana_pe.modules.cartao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID>{}
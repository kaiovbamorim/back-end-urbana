package br.com.urbanape.urbana_pe.modules.cartao.dto;

import java.util.UUID;

import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;
import br.com.urbanape.urbana_pe.modules.cartao.enums.TipoCartao;

public class CartaoDTO {

    private UUID id;
    private String nomeUsuario;
    private String nome;
    private String numero;
    private TipoCartao tipo;
    private boolean status;

    public CartaoDTO(CartaoEntity cartaoEntity, String nomeUsuario) {
        this.id = cartaoEntity.getId();
        this.nomeUsuario = nomeUsuario;
        this.nome = cartaoEntity.getNome();
        this.numero = cartaoEntity.getNumero();
        this.tipo = cartaoEntity.getTipo();
        this.status = cartaoEntity.getStatus();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoCartao getTipo() {
        return tipo;
    }

    public void setTipo(TipoCartao tipo) {
        this.tipo = tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

package br.com.urbanape.urbana_pe.modules.usuario.dto;

import java.util.UUID;

import br.com.urbanape.urbana_pe.modules.usuario.enums.TipoUsuario;


public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String email;
    private TipoUsuario tipo;

    public UsuarioDTO(UUID id, String nome, String email, TipoUsuario tipo){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public UUID getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

}

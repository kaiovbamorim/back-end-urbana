package br.com.urbanape.urbana_pe.modules.usuario.dto;

import java.util.UUID;


public class UsuarioDTO {

    private UUID id;
    private String nome;
    private String email;
    
    public UsuarioDTO(UUID id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
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

}

package br.com.urbanape.urbana_pe.modules.usuario.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UpdateUsuarioDTO {

    private UUID id;

    @NotBlank(message = "O campo NOME deve ser preenchido!")
    private String nome;

    @Email(message = "O campo E-MAIL está digitado de forma incorreta!")
    @NotBlank(message = "O campo EMAIL deve ser preenchido!")
    private String email;
    
    @Length(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
    private String senha;

    public String getNome() {
        return nome;
    }
    
    public UpdateUsuarioDTO(UUID id, String nome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
        
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha(){
        return this.senha;
    }   

    public void setSenha(String senha) {
        this.senha = senha;
    }    

    public UUID getId(){
        return this.id;
    }
}

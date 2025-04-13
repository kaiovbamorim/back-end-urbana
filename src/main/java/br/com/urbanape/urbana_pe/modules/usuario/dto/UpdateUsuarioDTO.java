package br.com.urbanape.urbana_pe.modules.usuario.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.urbanape.urbana_pe.modules.usuario.enums.TipoUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateUsuarioDTO {

    private UUID id;

    @NotBlank(message = "O campo NOME deve ser preenchido!")
    private String nome;

    @Email(message = "O campo E-MAIL está digitado de forma incorreta!")
    @NotBlank(message = "O campo EMAIL deve ser preenchido!")
    private String email;
    
    @Length(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
    private String senha;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo TIPO deve ser preenchido!")
    private TipoUsuario tipo;

    public String getNome() {
        return nome;
    }
    
    public UpdateUsuarioDTO(UUID id, String nome, String email, TipoUsuario tipo, String senha){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
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

    public TipoUsuario getTipo() {
        return tipo;
    }
    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}

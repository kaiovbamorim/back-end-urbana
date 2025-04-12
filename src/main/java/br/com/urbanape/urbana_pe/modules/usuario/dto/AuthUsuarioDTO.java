package br.com.urbanape.urbana_pe.modules.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class AuthUsuarioDTO {

    @NotBlank(message = "O campo E-MAIL deve ser preenchido!")
    @Email(message = "O campo E-MAIL está digitado de forma incorreta!")
    private String email;

    @NotBlank(message = "O campo SENHA deve ser preenchido!")
    private String senha;


    public AuthUsuarioDTO(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

package br.com.urbanape.urbana_pe.modules.usuario.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O campo NOME deve ser preenchido!")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O campo E-MAIL deve ser preenchido!")
    @Email(message = "O campo E-MAIL está digitado de forma incorreta!")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O campo SENHA deve ser preenchido!")
    @Length(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    private List<CartaoEntity> cartao;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
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
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

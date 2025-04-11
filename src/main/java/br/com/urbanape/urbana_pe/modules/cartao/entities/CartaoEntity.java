package br.com.urbanape.urbana_pe.modules.cartao.entities;

import java.util.UUID;

import br.com.urbanape.urbana_pe.modules.cartao.enums.TipoCartao;
import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "cartao")
public class CartaoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private UsuarioEntity usuario;

    @Column(name = "id_usuario", nullable = false)
    private UUID idUsuario;

    @Column(nullable = false, unique = false)
    @NotBlank(message = "O campo NOME deve ser preenchido!")
    private String nome;

    @Column(nullable = false, unique = true)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false)
    @NotNull(message = "O campo TIPO deve ser preenchido!")
    private TipoCartao tipo;

    @Column(nullable = false, unique = false)
    private boolean status;

    public void setIdUsuario(UUID idUsuario){
        this.idUsuario = idUsuario;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    
    public String getNumero(){
        return this.numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public TipoCartao getTipo(){
        return this.tipo;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }
    
    public Boolean getStatus(){
        return this.status;
    }
}

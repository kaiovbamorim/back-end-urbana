package br.com.urbanape.urbana_pe.modules.usuario.enums;

public enum TipoUsuario {
    ADMIN ("Administrador"),
    COMUM ("Comum");

    private String nome;

    private TipoUsuario(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}

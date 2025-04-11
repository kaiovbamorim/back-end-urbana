package br.com.urbanape.urbana_pe.modules.cartao.enums;

public enum TipoCartao {
    COMUM ("Comum"),
    ESTUDANTE ("Estudante"),
    TRABALHADOR ("Trabalhador");

    private String nome;

    private TipoCartao(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }
}

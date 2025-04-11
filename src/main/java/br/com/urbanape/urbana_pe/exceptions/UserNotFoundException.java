package br.com.urbanape.urbana_pe.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
}

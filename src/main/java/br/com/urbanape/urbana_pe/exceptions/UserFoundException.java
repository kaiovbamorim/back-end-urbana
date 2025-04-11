package br.com.urbanape.urbana_pe.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
       super("Já existe um usário cadastrado com esse E-MAIL!");
    }
}

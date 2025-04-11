package br.com.urbanape.urbana_pe.exceptions;

public class ErrorMessageDTO {
    
    private String message;
    private String field;

    public ErrorMessageDTO(String message, String field){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }

    public String getField(){
        return this.field;
    }

}

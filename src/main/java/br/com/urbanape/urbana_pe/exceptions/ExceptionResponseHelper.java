package br.com.urbanape.urbana_pe.exceptions;

import java.util.ArrayList;
import java.util.List;


public class ExceptionResponseHelper {
    public static List<ErrorMessageDTO> ExceptionResponse(String message, String field){
        List<ErrorMessageDTO> dto = new ArrayList<>();
        ErrorMessageDTO erro = new ErrorMessageDTO(message, field);
        dto.add(erro);
        return dto;
    }
}

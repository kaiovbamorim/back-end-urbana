package br.com.urbanape.urbana_pe.modules.usuario.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urbanape.urbana_pe.exceptions.ExceptionResponseHelper;
import br.com.urbanape.urbana_pe.exceptions.UserNotFoundException;
import br.com.urbanape.urbana_pe.modules.usuario.dto.AuthUsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.services.AuthUsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthUsuarioController {
    
    @Autowired
    AuthUsuarioService authUsuarioService;

    @PostMapping("/usuario")
    public ResponseEntity<Object> auth(@Valid @RequestBody AuthUsuarioDTO authUsuarioDTO) {
        try {
            var result = this.authUsuarioService.checkLogin(authUsuarioDTO);
            return ResponseEntity.ok().body(result);
        } catch (UserNotFoundException e){
            var r = ExceptionResponseHelper.ExceptionResponse(e.getMessage(), "email");
            return ResponseEntity.badRequest().body(r);
        } catch (AuthenticationException e){
            var r = ExceptionResponseHelper.ExceptionResponse("Senha incorreta, verifique seus dados e tente novamente!", "senha");
            return ResponseEntity.badRequest().body(r);
        } 
         catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

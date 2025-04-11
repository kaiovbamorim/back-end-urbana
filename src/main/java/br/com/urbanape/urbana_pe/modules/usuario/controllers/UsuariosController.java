package br.com.urbanape.urbana_pe.modules.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urbanape.urbana_pe.exceptions.ExceptionResponseHelper;
import br.com.urbanape.urbana_pe.exceptions.UserFoundException;
import br.com.urbanape.urbana_pe.modules.usuario.dto.UpdateUsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;
import br.com.urbanape.urbana_pe.modules.usuario.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity){
        try {
            var result = this.usuarioService.cadastrarUsuario(usuarioEntity);
            return ResponseEntity.ok().body(result);
        } catch (UserFoundException e){
            var r = ExceptionResponseHelper.ExceptionResponse(e.getMessage(), "email");
            return ResponseEntity.badRequest().body(r);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/todos-usuarios")
    public ResponseEntity<Object> buscarUsuarios(){
        try {
            var result = this.usuarioService.buscarUsuarios();
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Object> editarUsuario(@Valid @RequestBody UpdateUsuarioDTO updateUsuarioDTO){
        try {
            var result = this.usuarioService.editarUsuario(updateUsuarioDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> deletarUsuario(@PathVariable("id") String idUsuario){
        try {
            this.usuarioService.deletarUsuario(idUsuario);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

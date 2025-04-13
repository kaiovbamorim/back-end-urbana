package br.com.urbanape.urbana_pe.modules.cartao.controllers;

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

import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;
import br.com.urbanape.urbana_pe.modules.cartao.services.CartaoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
    
    @Autowired
    private CartaoService cartaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarCartao(@Valid @RequestBody CartaoEntity cartaoEntity){
        try {
            var result = cartaoService.cadastrarCartao(cartaoEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/meus-cartoes")
    public ResponseEntity<Object> buscarMeusCartoes(HttpServletRequest request){
        try {
            var idUsuario = request.getAttribute("idUsuario");
            var result = this.cartaoService.buscarMeusCartoes(idUsuario.toString());
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/todos-cartoes")
    public ResponseEntity<Object> buscarCartoes(){
        try {
            var result = this.cartaoService.buscarCartoes();
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/alterar-status/{id}")
    public ResponseEntity<Object> alterarStatus(@PathVariable("id") String idCartao){
        try {
            var result = this.cartaoService.alterarStatus(idCartao);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> deletarCartao(@PathVariable("id") String idCartao){
        try {
            this.cartaoService.deletarCartao(idCartao);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

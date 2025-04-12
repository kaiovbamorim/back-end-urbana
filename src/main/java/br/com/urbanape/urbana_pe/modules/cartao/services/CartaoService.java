package br.com.urbanape.urbana_pe.modules.cartao.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.urbanape.urbana_pe.exceptions.UserNotFoundException;
import br.com.urbanape.urbana_pe.modules.cartao.dto.CartaoDTO;
import br.com.urbanape.urbana_pe.modules.cartao.entities.CartaoEntity;
import br.com.urbanape.urbana_pe.modules.cartao.repositories.CartaoRepository;
import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;
import br.com.urbanape.urbana_pe.modules.usuario.repositories.UsuariosRepository;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    public CartaoDTO cadastrarCartao(CartaoEntity cartaoEntity) {
        String numeroCartao = String.format("%06d", new Random().nextInt(1000000));
        cartaoEntity.setNumero(numeroCartao);
        
        UsuarioEntity usuario = this.usuariosRepository.findById(cartaoEntity.getIdUsuario())
        .orElseThrow(() -> new UserNotFoundException());
        
        CartaoEntity cartao = this.cartaoRepository.save(cartaoEntity);
        return new CartaoDTO(cartao, usuario.getNome());
    }

    public List<CartaoDTO> buscarCartoes() {
        List<CartaoDTO> cartaoDto = new ArrayList<>();
        List<CartaoEntity> cartoes = this.cartaoRepository.findAll();
        for (CartaoEntity cartao : cartoes) {
            UsuarioEntity usuario = this.usuariosRepository.findById(cartao.getIdUsuario())
                    .orElseThrow(() -> new UserNotFoundException());
            cartaoDto.add(new CartaoDTO(cartao, usuario.getNome()));
        }

        return cartaoDto;
    }

    public void deletarCartao(String idCartao) {
        UUID id = UUID.fromString(idCartao);
        this.cartaoRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        this.cartaoRepository.deleteById(id);
    }

    public CartaoEntity alterarStatus(String idCartao) {
        UUID id = UUID.fromString(idCartao);
        CartaoEntity cartao = this.cartaoRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        cartao.setStatus(!cartao.getStatus());
        return this.cartaoRepository.save(cartao);
    }
}

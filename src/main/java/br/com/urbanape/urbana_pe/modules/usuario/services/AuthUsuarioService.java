package br.com.urbanape.urbana_pe.modules.usuario.services;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.urbanape.urbana_pe.exceptions.UserNotFoundException;
import br.com.urbanape.urbana_pe.modules.usuario.dto.AuthUsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.dto.AuthUsuarioResponseDTO;
import br.com.urbanape.urbana_pe.modules.usuario.dto.UsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;
import br.com.urbanape.urbana_pe.modules.usuario.repositories.UsuariosRepository;

@Service
public class AuthUsuarioService {

    @Value("{security.token.secret}")
    private String secretHash;

    @Autowired
    UsuariosRepository usuariosRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthUsuarioResponseDTO checkLogin(AuthUsuarioDTO authUsuarioDTO) throws AuthenticationException{
        UsuarioEntity usuario = this.usuariosRepository.findByEmail(authUsuarioDTO.getEmail())
        .orElseThrow(() -> new UserNotFoundException());

        var senhaIgual = this.passwordEncoder.matches(authUsuarioDTO.getSenha(), usuario.getSenha());
        if(!senhaIgual){
            throw new AuthenticationException();
        }

        Algorithm hash = Algorithm.HMAC256(secretHash);
        var expiredAt = Instant.now().plus(Duration.ofHours(1));

        var token = JWT.create().withIssuer("urbanape")
        .withSubject(usuario.getId().toString())
        .withClaim("roles", Arrays.asList(usuario.getTipo().getNome()))
        .withExpiresAt(expiredAt)
        .sign(hash);


        UsuarioDTO usuarioDTO =  new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());
        AuthUsuarioResponseDTO auhtUsuarioResponse =  new AuthUsuarioResponseDTO(token, usuarioDTO);
        return auhtUsuarioResponse;
    }
}

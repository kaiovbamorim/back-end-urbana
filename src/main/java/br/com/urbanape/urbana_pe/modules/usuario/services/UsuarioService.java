package br.com.urbanape.urbana_pe.modules.usuario.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.urbanape.urbana_pe.exceptions.UserFoundException;
import br.com.urbanape.urbana_pe.exceptions.UserNotFoundException;
import br.com.urbanape.urbana_pe.modules.usuario.dto.UpdateUsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.dto.UsuarioDTO;
import br.com.urbanape.urbana_pe.modules.usuario.entities.UsuarioEntity;
import br.com.urbanape.urbana_pe.modules.usuario.repositories.UsuariosRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDTO cadastrarUsuario(UsuarioEntity usuarioEntity){
        this.usuariosRepository.findByEmail(usuarioEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundException();
        });

        var senha = passwordEncoder.encode(usuarioEntity.getSenha());
        usuarioEntity.setSenha(senha);

        UsuarioEntity usuario = this.usuariosRepository.save(usuarioEntity);
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());
    }
    
    public List<UsuarioDTO> buscarUsuarios(){
        List<UsuarioEntity> usuarios = this.usuariosRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioDTO(
            usuario.getId(), 
            usuario.getNome(), 
            usuario.getEmail(),
            usuario.getTipo()
            )).toList();
    }

    public UsuarioDTO editarUsuario(UpdateUsuarioDTO updateUsuarioDTO){
        final UUID id = updateUsuarioDTO.getId();
        UsuarioEntity usuario = this.usuariosRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException());

        if(updateUsuarioDTO.getNome() != null && !updateUsuarioDTO.getNome().equals(usuario.getNome())){
            usuario.setNome(updateUsuarioDTO.getNome());
        }

        if(updateUsuarioDTO.getEmail() != null && !updateUsuarioDTO.getEmail().equals(usuario.getEmail())){
            usuario.setEmail(updateUsuarioDTO.getEmail());
        }

        if(updateUsuarioDTO.getTipo() != null && !updateUsuarioDTO.getTipo().equals(usuario.getTipo())){
            usuario.setTipo(updateUsuarioDTO.getTipo());
        }

        if(updateUsuarioDTO.getSenha() != null){
            var senhaIgual = this.passwordEncoder.matches(updateUsuarioDTO.getSenha(), usuario.getSenha());
            if(!senhaIgual){
                var senha = passwordEncoder.encode(updateUsuarioDTO.getSenha());
                usuario.setSenha(senha);
            }
        }

        UsuarioEntity usuarioAtualizado = this.usuariosRepository.save(usuario);
        return new UsuarioDTO(usuarioAtualizado.getId(), usuarioAtualizado.getNome(), usuarioAtualizado.getEmail(), usuarioAtualizado.getTipo());
    }

    public void deletarUsuario(String idUsuario){
        final UUID id = UUID.fromString(idUsuario);
        this.usuariosRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        usuariosRepository.deleteById(id);
    }
}

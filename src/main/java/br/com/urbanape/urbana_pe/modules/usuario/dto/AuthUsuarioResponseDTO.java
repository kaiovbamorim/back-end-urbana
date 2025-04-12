package br.com.urbanape.urbana_pe.modules.usuario.dto;

public class AuthUsuarioResponseDTO {
    private String token;
    private UsuarioDTO usuario;

    public AuthUsuarioResponseDTO(String token, UsuarioDTO usuario){
        this.token = token;
        this.usuario = usuario;
    }

    public void setToken(String acess_token) {
        this.token = acess_token;
    }

    public String getToken() {
        return token;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

}

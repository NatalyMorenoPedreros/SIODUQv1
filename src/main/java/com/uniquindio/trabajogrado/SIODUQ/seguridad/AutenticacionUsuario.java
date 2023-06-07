package com.uniquindio.trabajogrado.SIODUQ.seguridad;

import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class AutenticacionUsuario implements OAuth2User {
    
    private OAuth2User usuario;

    public AutenticacionUsuario(OAuth2User usuario) {
        this.usuario = usuario;
    }    

    @Override
    public Map<String, Object> getAttributes() {
        return usuario.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getAuthorities();
    }

    @Override
    public String getName() {
        return usuario.getAttribute("name");
    }
    
    public String getEmail() {
        return usuario.<String>getAttribute("email");     
    }
    
    public String getRole(){
        return usuario.getAuthorities().toArray()[0].toString();
    }
}

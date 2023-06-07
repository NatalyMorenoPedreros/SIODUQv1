package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Sesion;

public interface SesionService {
    
    public void guardar(Sesion sesion);
    
    public void eliminar(Sesion sesion);
    
    public Sesion buscarPorUsername(String username);
    
    public boolean construirSesion(Persona persona, Sesion sesion, String rol);
}

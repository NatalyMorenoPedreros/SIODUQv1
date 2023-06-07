package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Rol;
import java.util.List;

public interface RolService {
    public List<Rol> listarRoles();
    
    public void guardar(Rol rol);
    
    public void eliminar(Rol rol);
    
    public Rol encontrarRol(Rol rol);
    
    public Rol encontrarRolPorNombre(String nombre);
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Estado;
import java.util.List;

public interface EstadoService {
    public List<Estado> listarEstados();
    
    public void guardar(Estado estado);
    
    public void eliminar(Estado estado);
    
    public Estado encontrarEstado(Estado estado);
    
    public Estado encontrarEstadoPorNombre(String nombre);
}

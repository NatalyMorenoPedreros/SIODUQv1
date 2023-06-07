package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Programa;
import java.util.List;

public interface ProgramaService {
    public List<Programa> listarProgramas();
    
    public void guardar(Programa programa);
    
    public void eliminar(Programa programa);
    
    public Programa encontrarPrograma(Programa programa);
}

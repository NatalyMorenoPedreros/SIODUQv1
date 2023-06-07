package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroTexto;
import java.util.List;

public interface FORMPALibroTextoService {
    public List<FORMPALibroTexto> listarFORMPALibroTextos();
    
    public void guardar(FORMPALibroTexto formulario);
    
    public void eliminar(FORMPALibroTexto formulario);
    
    public FORMPALibroTexto encontrarFORMPALibroTexto(Integer formulario);
}

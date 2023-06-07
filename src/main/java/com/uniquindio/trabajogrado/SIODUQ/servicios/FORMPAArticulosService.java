package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAArticulos;
import java.util.List;

public interface FORMPAArticulosService {
    public List<FORMPAArticulos> listarFORMPAArticulos();
    
    public void guardar(FORMPAArticulos formulario);
    
    public void eliminar(FORMPAArticulos formulario);
    
    public FORMPAArticulos encontrarFORMPAArticulos(Integer formulario);
}

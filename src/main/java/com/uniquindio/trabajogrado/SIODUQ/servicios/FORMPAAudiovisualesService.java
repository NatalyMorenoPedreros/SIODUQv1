package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAAudiovisuales;
import java.util.List;

public interface FORMPAAudiovisualesService {
    public List<FORMPAAudiovisuales> listarFORMPAAudiovisuales();
    
    public void guardar(FORMPAAudiovisuales formulario);
    
    public void eliminar(FORMPAAudiovisuales formulario);
    
    public FORMPAAudiovisuales encontrarFORMPAAudiovisuales(Integer formulario);
}

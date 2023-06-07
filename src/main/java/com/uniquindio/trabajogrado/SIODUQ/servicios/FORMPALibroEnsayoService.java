package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroEnsayo;
import java.util.List;

public interface FORMPALibroEnsayoService {
    public List<FORMPALibroEnsayo> listarFORMPALibroEnsayos();
    
    public void guardar(FORMPALibroEnsayo formulario);
    
    public void eliminar(FORMPALibroEnsayo formulario);
    
    public FORMPALibroEnsayo encontrarFORMPALibroEnsayo(Integer formulario);
}

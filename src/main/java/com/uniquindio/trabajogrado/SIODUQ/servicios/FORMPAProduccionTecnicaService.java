package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAProduccionTecnica;
import java.util.List;

public interface FORMPAProduccionTecnicaService {
    public List<FORMPAProduccionTecnica> listarFORMPAProduccionTecnicas();
    
    public void guardar(FORMPAProduccionTecnica formulario);
    
    public void eliminar(FORMPAProduccionTecnica formulario);
    
    public FORMPAProduccionTecnica encontrarFORMPAProduccionTecnica(Integer formulario);
}

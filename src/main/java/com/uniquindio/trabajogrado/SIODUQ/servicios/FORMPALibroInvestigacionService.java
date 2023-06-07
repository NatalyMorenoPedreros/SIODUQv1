package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroInvestigacion;
import java.util.List;

public interface FORMPALibroInvestigacionService {
    public List<FORMPALibroInvestigacion> listarFORMPALibroInvestigaciones();
    
    public void guardar(FORMPALibroInvestigacion formulario);
    
    public void eliminar(FORMPALibroInvestigacion formulario);
    
    public FORMPALibroInvestigacion encontrarFORMPALibroInvestigacion(Integer formulario);
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAPremio;
import java.util.List;

public interface FORMPAPremioService {
    public List<FORMPAPremio> listarFORMPAPremios();
    
    public void guardar(FORMPAPremio formulario);
    
    public void eliminar(FORMPAPremio formulario);
    
    public FORMPAPremio encontrarFORMPAPremio(Integer formulario);
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPASoftware;
import java.util.List;

public interface FORMPASoftwareService {
    public List<FORMPASoftware> listarFORMPASoftwares();
    
    public void guardar(FORMPASoftware formulario);
    
    public void eliminar(FORMPASoftware formulario);
    
    public FORMPASoftware encontrarFORMPASoftware(Integer formulario);
}

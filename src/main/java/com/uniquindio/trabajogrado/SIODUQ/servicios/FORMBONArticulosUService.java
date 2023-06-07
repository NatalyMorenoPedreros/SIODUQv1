package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONArticulosU;
import java.util.List;

public interface FORMBONArticulosUService {
    public List<FORMBONArticulosU> listarFORMBONArticulosUs();
    
    public void guardar(FORMBONArticulosU formulario);
    
    public void eliminar(FORMBONArticulosU formulario);
    
    public FORMBONArticulosU encontrarFORMBONArticulosU(Integer formulario);
}

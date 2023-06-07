package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONPonencia;
import java.util.List;

public interface FORMBONPonenciaService {
    public List<FORMBONPonencia> listarFORMBONPonencias();
    
    public void guardar(FORMBONPonencia formulario);
    
    public void eliminar(FORMBONPonencia formulario);
    
    public FORMBONPonencia encontrarFORMBONPonencia(Integer formulario);
}

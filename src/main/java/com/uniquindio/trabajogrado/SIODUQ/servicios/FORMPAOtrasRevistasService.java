package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAOtrasRevistas;
import java.util.List;

public interface FORMPAOtrasRevistasService {
    public List<FORMPAOtrasRevistas> listarFORMBONOtrasRevistas();
    
    public void guardar(FORMPAOtrasRevistas formulario);
    
    public void eliminar(FORMPAOtrasRevistas formulario);
    
    public FORMPAOtrasRevistas encontrarFORMBONOtrasRevistas(Integer formulario);
}

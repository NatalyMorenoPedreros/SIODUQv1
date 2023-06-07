package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.ValoracionFuenteExterna;
import java.util.List;

public interface ValoracionFuenteExternaService {
    public List<ValoracionFuenteExterna> listarValoracionFuenteExternas();
    
    public void guardar(ValoracionFuenteExterna valoracionFuenteExterna);
    
    public void eliminar(ValoracionFuenteExterna valoracionFuenteExterna);
    
    public ValoracionFuenteExterna encontrarValoracionFuenteExterna(ValoracionFuenteExterna valoracionFuenteExterna);
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoProduccion;
import java.util.List;

public interface TipoProduccionService {
    public List<TipoProduccion> listarTipoProducciones();
    
    public void guardar(TipoProduccion tipoProduccion);
    
    public void eliminar(TipoProduccion tipoProduccion);
    
    public TipoProduccion encontrarTipoProduccion(TipoProduccion tipoProduccion);
}

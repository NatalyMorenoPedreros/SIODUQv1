package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoObra;
import java.util.List;

public interface TipoObraService {
    public List<TipoObra> listarTipoObras();
    
    public void guardar(TipoObra tipoObra);
    
    public void eliminar(TipoObra tipoObra);
    
    public TipoObra encontrarTipoObra(TipoObra tipoObra);
}

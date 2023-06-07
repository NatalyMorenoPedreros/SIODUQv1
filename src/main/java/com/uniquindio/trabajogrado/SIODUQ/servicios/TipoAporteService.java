package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoAporte;
import java.util.List;

public interface TipoAporteService {
    public List<TipoAporte> listarTipoAportes();
    
    public void guardar(TipoAporte tipoAporte);
    
    public void eliminar(TipoAporte tipoAporte);
    
    public TipoAporte encontrarTipoAporte(TipoAporte tipoAporte);
}

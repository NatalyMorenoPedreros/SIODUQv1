package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoPatente;
import java.util.List;

public interface TipoPatenteService {
    public List<TipoPatente> listarTipoPatentes();
    
    public void guardar(TipoPatente tipoPatente);
    
    public void eliminar(TipoPatente tipoPatente);
    
    public TipoPatente encontrarTipoPatente(TipoPatente tipoPatente);
}

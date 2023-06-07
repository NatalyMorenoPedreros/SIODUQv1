package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoIdentificacion;
import java.util.List;

public interface TipoIdentificacionService {
    public List<TipoIdentificacion> listarTipoIdentificaciones();
    
    public void guardar(TipoIdentificacion tipoIdentificacion);
    
    public void eliminar(TipoIdentificacion tipoIdentificacion);
    
    public TipoIdentificacion encontrarTipoIdentificacion(TipoIdentificacion tipoIdentificacion);
}

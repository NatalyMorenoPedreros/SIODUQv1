package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoSolicitud;
import java.util.List;

public interface TipoSolicitudService {
    public List<TipoSolicitud> listarTipoSolicitudes();
    
    public void guardar(TipoSolicitud tipoSolicitud);
    
    public void eliminar(TipoSolicitud tipoSolicitud);
    
    public TipoSolicitud encontrarTipoSolicitud(TipoSolicitud tipoSolicitud);
    
    public TipoSolicitud encontrarTipoPorNombre(String nombre);
}

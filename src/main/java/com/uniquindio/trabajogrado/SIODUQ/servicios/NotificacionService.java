package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Notificacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import java.util.List;

public interface NotificacionService {
    public List<Notificacion> listarNotificaciones();
    
    public void guardar(Notificacion notificacion);
    
    public void eliminar(Notificacion notificacion);
    
    public Notificacion encontrarNotificacion(Notificacion notificacion);
    
    public List<Notificacion> listarPorSolicitud(Solicitud solicitud);
    
    public boolean construirNotificacion(Solicitud solicitud, String mensaje);
}

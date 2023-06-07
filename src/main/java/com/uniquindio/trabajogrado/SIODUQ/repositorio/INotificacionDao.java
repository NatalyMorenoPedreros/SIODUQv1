package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Notificacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificacionDao extends JpaRepository<Notificacion, Integer>{
    
    List<Notificacion> findBySolicitud(Solicitud solicitud);
}

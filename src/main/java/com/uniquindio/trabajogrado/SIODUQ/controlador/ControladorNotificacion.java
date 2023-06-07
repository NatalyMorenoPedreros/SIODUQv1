package com.uniquindio.trabajogrado.SIODUQ.controlador;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Notificacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import com.uniquindio.trabajogrado.SIODUQ.servicios.NotificacionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.SolicitudService;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import java.sql.Timestamp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorNotificacion {

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private SolicitudService solicitudService;

    @PostMapping("/crearNotificacion/{idSolicitud}")
    public String guardar(Solicitud solicitud, @Validated Notificacion notificacion, Errors errores) {

        solicitud = solicitudService.encontrarSolicitud(solicitud);
        
        if(solicitud != null){
            notificacion.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
            notificacion.setSolicitud(solicitud);

            if (notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_CREACION_PROPIA + notificacion.getMensaje())){
                return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
            } else
                return "redirect:/errores/errorCreacionNotificacion";
        } else
            return "redirect:/errores/errorObtenerInformacion";
        
    }
}

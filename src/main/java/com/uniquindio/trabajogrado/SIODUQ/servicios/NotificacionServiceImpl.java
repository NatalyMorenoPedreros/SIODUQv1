package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.INotificacionDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Notificacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private INotificacionDao notificacionDao;

    @Autowired
    private CorreoService correoService;

    @Override
    public List<Notificacion> listarNotificaciones() {
        return (List<Notificacion>) notificacionDao.findAll();
    }

    @Override
    public void guardar(Notificacion notificacion){
        notificacionDao.save(notificacion);
    }

    @Override
    public void eliminar(Notificacion notificacion) {
        notificacionDao.delete(notificacion);
    }

    @Override
    public Notificacion encontrarNotificacion(Notificacion notificacion) {
        return notificacionDao.findById(notificacion.getIdNotificacion()).orElse(null);
    }

    @Override
    public List<Notificacion> listarPorSolicitud(Solicitud solicitud) {
        return (List<Notificacion>) notificacionDao.findBySolicitud(solicitud);
    }

    @Override
    public boolean construirNotificacion(Solicitud solicitud, String mensaje) {

        Notificacion notificacion = new Notificacion();

        mensaje = mensaje + "\n"
                + "Codigo solicitud: " + solicitud.getCodigo() + "\n"
                + "Fecha creacion: " + solicitud.getFechaCreacion() + "\n"
                + "Puntaje: " + solicitud.getPuntajeTentativo() + "\n"
                + "Estado: " + solicitud.getEstado().getNombre();

        notificacion.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        notificacion.setMensaje(mensaje);
        notificacion.setSolicitud(solicitud);

        try {
            guardar(notificacion);
        } catch (Exception e) {
            log.error("Ocurre un error con la construccion de la notificacion: " + e.getMessage());
            return false;
        }
        
        try {
            enviarCorreos(solicitud.getPersona().getCorreo(), mensaje);
        } catch (MailSendException e) {
            log.error("Ocurre un error con el envio del correo electronico: " + e.getMessage());
        }
            
        return true;
    }

    public void enviarCorreos(String correoDocente, String mensaje) throws MailSendException {
        List<String> correos = new ArrayList<>();
        correos.add(Constantes.CORREO_ADMINISTRADOR);
        correos.add(correoDocente);
        correoService.sendEmail(correos, Constantes.CORREO_ASUNTO_CREACION_NUEVA, mensaje);
    }
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ISolicitudDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Formulario;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Utilidades;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private ISolicitudDao solicitudDao;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private TipoSolicitudService tipoSolicitudService;
    @Autowired
    private NotificacionService notificacionService;

    @Override
    public List<Solicitud> listarSolicitudes() {
        return (List<Solicitud>) solicitudDao.findAll();
    }

    @Override
    public void guardar(Solicitud solicitud, String mensajeCorreo) {
        solicitudDao.save(solicitud);
        notificacionService.construirNotificacion(solicitud, mensajeCorreo);
    }

    @Override
    public void eliminar(Solicitud solicitud) {
        solicitudDao.delete(solicitud);
    }

    @Override
    public Solicitud encontrarSolicitud(Solicitud solicitud) {
        return solicitudDao.findById(solicitud.getIdSolicitud()).orElse(null);
    }

    @Override
    public List<Solicitud> buscarSolicitudesPorPersona(Persona persona) {
        return solicitudDao.findByPersona(persona);
    }

    @Override
    public Solicitud buscarSolicitudPorFormulario(Formulario formulario) {
        return solicitudDao.findByFormulario(formulario);
    }

    @Override
    public Solicitud construirSolicitud(Persona persona, String estado, Formulario formulario, String puntaje, String tipoSolicitud, String mensajeCorreo) {
        Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo(Utilidades.realizarCodigo(contarSolicitudesPorPersona(persona), tipoSolicitud));
        solicitud.setEstado(estadoService.encontrarEstadoPorNombre(Constantes.NUEVA));
        solicitud.setFormulario(formulario);
        solicitud.setPersona(persona);
        solicitud.setPuntajeTentativo(puntaje);
        solicitud.setTipoSolicitud(tipoSolicitudService.encontrarTipoPorNombre(tipoSolicitud));
        solicitud.setFechaCreacion(fechaCreacion);
        guardar(solicitud, mensajeCorreo);

        return solicitud;
    }

    @Override
    public long contarSolicitudesPorPersona(Persona persona) {
        return solicitudDao.countByPersona(persona);
    }
}

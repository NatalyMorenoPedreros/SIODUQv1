package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Formulario;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import java.util.List;

public interface SolicitudService {

    public List<Solicitud> listarSolicitudes();

    public void guardar(Solicitud solicitud, String mensajeCorreo);

    public void eliminar(Solicitud solicitud);

    public Solicitud encontrarSolicitud(Solicitud solicitud);

    public List<Solicitud> buscarSolicitudesPorPersona(Persona persona);

    public Solicitud buscarSolicitudPorFormulario(Formulario formulario);

    public Solicitud construirSolicitud(Persona persona, String estado, Formulario formulario, String puntaje, String tipoSolicitud, String mensajeCorreo);

    public long contarSolicitudesPorPersona(Persona persona);
}

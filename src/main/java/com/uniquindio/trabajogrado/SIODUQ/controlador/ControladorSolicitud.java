package com.uniquindio.trabajogrado.SIODUQ.controlador;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Documento;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Estado;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Notificacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import com.uniquindio.trabajogrado.SIODUQ.servicios.DocumentoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.EstadoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.NotificacionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.SolicitudService;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ControladorSolicitud {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/observarSolicitud/{idSolicitud}")
    public String listar(Solicitud solicitud, Model model) {
        solicitud = solicitudService.encontrarSolicitud(solicitud);
        List<Notificacion> notificaciones = notificacionService.listarPorSolicitud(solicitud);
        List<Estado> estados = estadoService.listarEstados();
        Documento documento = documentoService.obtenerDocumentoPorSolicitud(solicitud);
        
        if (solicitud != null && notificaciones != null && estados != null && documento != null) {
            model.addAttribute("documento", documento);
            model.addAttribute("solicitud", solicitud);
            model.addAttribute("notificaciones", notificaciones);
            model.addAttribute("estados", estados);

            return "gestionarSolicitud";
        }
        
        return "redirect:/errores/errorObtenerInformacion";
        
    }

    @PostMapping("/guardarSolicitud")
    public String guardar(@Validated Solicitud solicitud, Errors errores) {
        if (errores.hasErrors()) {
            return "redirect:/errores/errorProceso";
        }
        solicitudService.guardar(solicitud, Constantes.CORREO_CUERPO_MODIFICACION);

        return "redirect:/";
    }

    @PostMapping("/actualizarDocumento/{idDocumento}")
    public String actualizarDocumento(Documento documento, @RequestParam("file") MultipartFile archivo, Errors errores) {
        if (errores.hasErrors()) {
            return "redirect:/errores/errorProceso";
        }
        documentoService.actualizarDocumento(archivo, documento);

        return "redirect:/";
    }
}

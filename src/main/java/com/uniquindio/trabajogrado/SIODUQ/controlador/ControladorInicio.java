package com.uniquindio.trabajogrado.SIODUQ.controlador;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Programa;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Sesion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoIdentificacion;
import com.uniquindio.trabajogrado.SIODUQ.seguridad.AutenticacionUsuario;
import com.uniquindio.trabajogrado.SIODUQ.servicios.ProgramaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.SesionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.SolicitudService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoIdentificacionService;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SesionService sesionService;

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @Autowired
    private ProgramaService programaService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user1, Authentication authentication) {
        
        Sesion sesion = null;
        String rol = "";
        
        if(user1 != null){
            System.out.println("com.uniquindio.trabajogrado.SIODUQ.controlador.ControladorInicio.inicio(): Entro user 1");
            var roles = user1.getAuthorities().toArray();
            rol = roles[0].toString();
            sesion = sesionService.buscarPorUsername(user1.getUsername());
        }else if(authentication != null){
            System.out.println("com.uniquindio.trabajogrado.SIODUQ.controlador.ControladorInicio.inicio(): Entro user 2");
            AutenticacionUsuario user = (AutenticacionUsuario) authentication.getPrincipal();
            sesion = sesionService.buscarPorUsername(user.getEmail());
            rol = user.getRole();
        }
        
        if (sesion != null) {
            switch (rol) {
                case Constantes.ROLE_ADMIN:
                    var solicitudes = solicitudService.listarSolicitudes();
                    model.addAttribute("solicitudes", solicitudes);
                    return "index";
                case Constantes.ROLE_USER:
                    var solicitudesPersona = solicitudService.buscarSolicitudesPorPersona(sesion.getPersona());
                    model.addAttribute("persona", sesion.getPersona());
                    model.addAttribute("solicitudes", solicitudesPersona);
                    return "indexUsuario";
                default:
                    throw new AssertionError();
            }
        }else
            return "/errores/errorInicioSesion";
    }
    
    @GetMapping("/cargarInformacionSesion")
    public String cargarInformacionSesion(Model model) {
        List<TipoIdentificacion> tipoIdentificaciones = tipoIdentificacionService.listarTipoIdentificaciones();
        List<Programa> programas = programaService.listarProgramas();

        model.addAttribute("tipoIdentificaciones", tipoIdentificaciones);
        model.addAttribute("programas", programas);

        return "crearSesion";
    }

    @PostMapping("/crearNuevaSesion")
    public String crearNuevaSesion(@Validated Persona persona, @Validated Sesion sesion, Errors errores) {
        return (sesionService.construirSesion(persona, sesion, Constantes.ROLE_USER)) ? "redirect:/" : "/errores/errorCreacion";
    }
}

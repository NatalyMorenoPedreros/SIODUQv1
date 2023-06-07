package com.uniquindio.trabajogrado.SIODUQ.controlador;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONArticulosU;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONDireccionTesis;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONEstudioPosdoctoral;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAOtrasRevistas;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMBONPonencia;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAArticulos;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAAudiovisuales;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroEnsayo;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroInvestigacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroTexto;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAObraArtistica;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAPatente;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAProduccionTecnica;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPASoftware;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAPremio;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Formulario;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoAporte;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoDifusion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoMaterial;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoObra;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoPatente;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoProduccion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoPublicacion;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoReconocimiento;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoRevista;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoTesis;
import com.uniquindio.trabajogrado.SIODUQ.servicios.DocumentoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMBONArticulosUService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMBONDireccionTesisService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMBONPonenciaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAArticulosService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAAudiovisualesService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPALibroEnsayoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPALibroInvestigacionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPALibroTextoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAObraArtisticaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAPatenteService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAProduccionTecnicaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPASoftwareService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FormularioService;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMBONEstudioPosdoctoralService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.PersonaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.SolicitudService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoAporteService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoDifusionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoMaterialService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoObraService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoPatenteService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoProduccionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoPublicacionService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoReconocimientoService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoRevistaService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoTesisService;
import com.uniquindio.trabajogrado.SIODUQ.utilidades.Utilidades;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAOtrasRevistasService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.FORMPAPremioService;
import com.uniquindio.trabajogrado.SIODUQ.servicios.NotificacionService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
public class ControladorFormulario {

    @Autowired
    private FormularioService formularioService;
    @Autowired
    private FORMBONArticulosUService formularioArticulosUService;
    @Autowired
    private FORMBONDireccionTesisService formularioDireccionTesisService;
    @Autowired
    private FORMBONEstudioPosdoctoralService formularioPosdoctoralService;
    @Autowired
    private FORMPAOtrasRevistasService formularioOtrasRevistasService;
    @Autowired
    private FORMBONPonenciaService formularioPonenciaService;
    @Autowired
    private FORMPAArticulosService formularioArticulosService;
    @Autowired
    private FORMPAAudiovisualesService formularioAudiovisualService;
    @Autowired
    private FORMPALibroEnsayoService formularioLibroEnsayoService;
    @Autowired
    private FORMPALibroInvestigacionService formularioLibroInvestigacionService;
    @Autowired
    private FORMPALibroTextoService formularioLibroTextoService;
    @Autowired
    private FORMPAObraArtisticaService formularioObraArtisticaService;
    @Autowired
    private FORMPAPatenteService formularioPatenteService;
    @Autowired
    private FORMPAProduccionTecnicaService formularioProduccionTecnicaService;
    @Autowired
    private FORMPASoftwareService formularioSoftwareService;
    @Autowired
    private FORMPAPremioService formularioPremioService;
    @Autowired
    private SolicitudService solicitudService;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private TipoDifusionService tipoDifusionService;
    @Autowired
    private TipoRevistaService tipoRevistaService;
    @Autowired
    private TipoTesisService tipoTesisService;
    @Autowired
    private TipoProduccionService tipoProduccionService;
    @Autowired
    private TipoPatenteService tipoPatenteService;
    @Autowired
    private TipoReconocimientoService tipoReconocimientoService;
    @Autowired
    private TipoObraService tipoObraService;
    @Autowired
    private TipoMaterialService tipoMaterialService;
    @Autowired
    private TipoAporteService tipoAporteService;
    @Autowired
    private TipoPublicacionService tipoPublicacionService;
    @Autowired
    private NotificacionService notificacionService;
    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/observarFormulario/{idFormulario}")
    public String buscarFormulario(Formulario formulario, Model model) {

        formulario = formularioService.encontrarFormulario(formulario);
        model.addAttribute("formulario", formulario);

        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        model.addAttribute("solicitud", solicitud);

        String ruta = "redirect:/errores/404";

        List<TipoDifusion> tipoDifusiones;
        List<TipoPublicacion> tipoPublicaciones;
        List<TipoRevista> tipoRevistas;
        List<TipoTesis> tiposTesis;
        List<TipoMaterial> tipoMateriales;
        List<TipoAporte> tipoAportes;
        List<TipoReconocimiento> tipoReconocimientos;
        List<TipoObra> tipoObras;
        List<TipoPatente> tipoPatentes;
        List<TipoProduccion> tipoProducciones;

        switch (formulario.getCodigo()) {
            case Constantes.FBARTICULO:
                FORMBONArticulosU formularioArticuloU = formularioArticulosUService.encontrarFORMBONArticulosU(formulario.getIdFormulario());
                model.addAttribute("formularioEspecifico", formularioArticuloU);

                ruta = Constantes.FBARTICULORUTA;

                break;
            case Constantes.FBDIRECCIONT:
                FORMBONDireccionTesis formularioDireccionTesis = formularioDireccionTesisService.encontrarFORMBONDireccionTesis(formulario.getIdFormulario());
                tiposTesis = tipoTesisService.listarTipoTesis();

                model.addAttribute("formularioEspecifico", formularioDireccionTesis);
                model.addAttribute("tiposTesis", tiposTesis);

                ruta = Constantes.FBDIRECCIONTRUTA;

                break;
            case Constantes.FBESTUDIOPOS:
                FORMBONEstudioPosdoctoral formularioPosdoctoral = formularioPosdoctoralService.encontrarFORMBONEstudioPosdoctoral(formulario.getIdFormulario());
                model.addAttribute("formularioEspecifico", formularioPosdoctoral);

                ruta = Constantes.FBESTUDIOPOSRUTA;

                break;
            case Constantes.FPAOTRAREVIS:
                FORMPAOtrasRevistas formularioOtraRevista = formularioOtrasRevistasService.encontrarFORMBONOtrasRevistas(formulario.getIdFormulario());
                tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
                tipoPublicaciones = tipoPublicacionService.listarTipoPublicaciones();
                tipoRevistas = tipoRevistaService.listarTipoRevistas();

                model.addAttribute("formularioEspecifico", formularioOtraRevista);
                model.addAttribute("tipoDifusiones", tipoDifusiones);
                model.addAttribute("tipoPublicaciones", tipoPublicaciones);
                model.addAttribute("tipoRevistas", tipoRevistas);

                ruta = Constantes.FBOTRAREVISRUTA;

                break;
            case Constantes.FBPONENCIA:
                FORMBONPonencia formularioPonencia = formularioPonenciaService.encontrarFORMBONPonencia(formulario.getIdFormulario());
                tipoDifusiones = tipoDifusionService.listarTipoDifusiones();

                model.addAttribute("formularioEspecifico", formularioPonencia);
                model.addAttribute("tipoDifusiones", tipoDifusiones);

                ruta = Constantes.FBPONENCIARUTA;

                break;
            case Constantes.FPAARTICULO:
                FORMPAArticulos formularioArticulos = formularioArticulosService.encontrarFORMPAArticulos(formulario.getIdFormulario());
                tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
                tipoRevistas = tipoRevistaService.listarTipoRevistas();

                model.addAttribute("formularioEspecifico", formularioArticulos);
                model.addAttribute("tipoDifusiones", tipoDifusiones);
                model.addAttribute("tipoRevistas", tipoRevistas);

                ruta = Constantes.FPAARTICULORUTA;

                break;
            case Constantes.FPAAUDIOV:
                FORMPAAudiovisuales formularioAudiovisuales = formularioAudiovisualService.encontrarFORMPAAudiovisuales(formulario.getIdFormulario());
                tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
                tipoMateriales = tipoMaterialService.listarTipoMateriales();
                tipoAportes = tipoAporteService.listarTipoAportes();

                model.addAttribute("formularioEspecifico", formularioAudiovisuales);
                model.addAttribute("tipoAportes", tipoAportes);
                model.addAttribute("tipoMateriales", tipoMateriales);
                model.addAttribute("tipoDifusiones", tipoDifusiones);

                ruta = Constantes.FPAAUDIOVRUTA;

                break;
            case Constantes.FPALIBROE:
                FORMPALibroEnsayo formularioLibroEnsayo = formularioLibroEnsayoService.encontrarFORMPALibroEnsayo(formulario.getIdFormulario());
                model.addAttribute("formularioEspecifico", formularioLibroEnsayo);

                ruta = Constantes.FPALIBROERUTA;

                break;
            case Constantes.FPALIBROI:
                FORMPALibroInvestigacion formularioLibroInvestigacion = formularioLibroInvestigacionService.encontrarFORMPALibroInvestigacion(formulario.getIdFormulario());
                model.addAttribute("formularioEspecifico", formularioLibroInvestigacion);

                ruta = Constantes.FPALIBROIRUTA;

                break;
            case Constantes.FPALIBROT:
                FORMPALibroTexto formularioLibroTexto = formularioLibroTextoService.encontrarFORMPALibroTexto(formulario.getIdFormulario());
                model.addAttribute("formularioEspecifico", formularioLibroTexto);

                ruta = Constantes.FPALIBROTRUTA;

                break;
            case Constantes.FPAOBRAARTIS:
                FORMPAObraArtistica formularioObraArtistica = formularioObraArtisticaService.encontrarFORMPAObraArtistica(formulario.getIdFormulario());
                tipoReconocimientos = tipoReconocimientoService.listarTipoReconocimientos();
                tipoObras = tipoObraService.listarTipoObras();

                model.addAttribute("formularioEspecifico", formularioObraArtistica);
                model.addAttribute("tipoObras", tipoObras);
                model.addAttribute("tipoReconocimientos", tipoReconocimientos);

                ruta = Constantes.FPAOBRAARTISRUTA;

                break;
            case Constantes.FPAPATENTE:
                FORMPAPatente formularioPatente = formularioPatenteService.encontrarFORMPAPatente(formulario.getIdFormulario());
                tipoPatentes = tipoPatenteService.listarTipoPatentes();

                model.addAttribute("formularioEspecifico", formularioPatente);
                model.addAttribute("tipoPatentes", tipoPatentes);

                ruta = Constantes.FPAPATENTERUTA;

                break;
            case Constantes.FPAPRODTEC:
                FORMPAProduccionTecnica formularioProduccionTecnica = formularioProduccionTecnicaService.encontrarFORMPAProduccionTecnica(formulario.getIdFormulario());
                tipoProducciones = tipoProduccionService.listarTipoProducciones();

                model.addAttribute("formularioEspecifico", formularioProduccionTecnica);
                model.addAttribute("tipoProducciones", tipoProducciones);

                ruta = Constantes.FPAPRODTECRUTA;

                break;
            case Constantes.FPASOFT:
                FORMPASoftware formularioSoftware = formularioSoftwareService.encontrarFORMPASoftware(formulario.getIdFormulario());
                tipoProducciones = tipoProduccionService.listarTipoProducciones();

                model.addAttribute("formularioEspecifico", formularioSoftware);
                model.addAttribute("tipoProducciones", tipoProducciones);

                ruta = Constantes.FPASOFTRUTA;

                break;
            case Constantes.FPAPREMIO:
                FORMPAPremio formularioPremio = formularioPremioService.encontrarFORMPAPremio(formulario.getIdFormulario());
                tipoDifusiones = tipoDifusionService.listarTipoDifusiones();

                model.addAttribute("formularioEspecifico", formularioPremio);
                model.addAttribute("tipoDifusiones", tipoDifusiones);

                ruta = Constantes.FPAPREMIORUTA;

                break;

            default:
                log.error("No se encuentra una ruta para el codigo del formuario enviado");
        }

        return ruta;
    }

    @PostMapping("/guardarFormularioPosdoctoral")
    public String guardar(@Validated Formulario formulario, @Validated FORMBONEstudioPosdoctoral formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioPosdoctoralService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioArticulos")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAArticulos formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioArticulosService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioDireccionTesis")
    public String guardar(@Validated Formulario formulario, @Validated FORMBONDireccionTesis formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioDireccionTesisService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioOtrasRevistas")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAOtrasRevistas formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioOtrasRevistasService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioPonencia")
    public String guardar(@Validated Formulario formulario, @Validated FORMBONPonencia formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioPonenciaService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioArticulosU")
    public String guardar(@Validated Formulario formulario, @Validated FORMBONArticulosU formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioArticulosUService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioAudiovisuales")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAAudiovisuales formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioAudiovisualService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioLibroEnsayo")
    public String guardar(@Validated Formulario formulario, @Validated FORMPALibroEnsayo formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioLibroEnsayoService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioLibroInvestigacion")
    public String guardar(@Validated Formulario formulario, @Validated FORMPALibroInvestigacion formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioLibroInvestigacionService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioLibroTexto")
    public String guardar(@Validated Formulario formulario, @Validated FORMPALibroTexto formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioLibroTextoService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioObraArtistica")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAObraArtistica formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioObraArtisticaService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioPatente")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAPatente formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioPatenteService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioProduccionTecnica")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAProduccionTecnica formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioProduccionTecnicaService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioSoftware")
    public String guardar(@Validated Formulario formulario, @Validated FORMPASoftware formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioSoftwareService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @PostMapping("/guardarFormularioPremio")
    public String guardar(@Validated Formulario formulario, @Validated FORMPAPremio formularioEspecifico, Errors errores) {

        formularioService.guardar(formulario);
        formularioPremioService.guardar(formularioEspecifico);
        Solicitud solicitud = solicitudService.buscarSolicitudPorFormulario(formulario);
        notificacionService.construirNotificacion(solicitud, Constantes.CORREO_CUERPO_MODIFICA_FORMULARIO);
        return "redirect:/observarSolicitud/" + solicitud.getIdSolicitud();
    }

    @GetMapping("/crearFormularioArticulos/{idPersona}")
    public String crearFormularioArticulos(Persona persona, Model model) {

        List<TipoDifusion> tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
        List<TipoRevista> tipoRevistas = tipoRevistaService.listarTipoRevistas();
        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);
        model.addAttribute("tipoDifusiones", tipoDifusiones);
        model.addAttribute("tipoRevistas", tipoRevistas);

        return "crearFormularioArticulos";
    }

    @GetMapping("/crearFormularioDireccionTesis/{idPersona}")
    public String crearFormularioDireccionTesis(Persona persona, Model model) {

        List<TipoTesis> tiposTesis = tipoTesisService.listarTipoTesis();
        persona = personaService.encontrarPersona(persona);

        model.addAttribute("tiposTesis", tiposTesis);
        model.addAttribute("persona", persona);

        return "crearFormularioDireccionTesis";
    }

    @GetMapping("/crearFormularioOtrasRevistas/{idPersona}")
    public String crearFormularioOtrasRevistas(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoDifusion> tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
        List<TipoPublicacion> tipoPublicaciones = tipoPublicacionService.listarTipoPublicaciones();
        List<TipoRevista> tipoRevistas = tipoRevistaService.listarTipoRevistas();

        model.addAttribute("persona", persona);
        model.addAttribute("tipoDifusiones", tipoDifusiones);
        model.addAttribute("tipoPublicaciones", tipoPublicaciones);
        model.addAttribute("tipoRevistas", tipoRevistas);

        return "crearFormularioOtrasRevistas";
    }

    @GetMapping("/crearFormularioArticulosU/{idPersona}")
    public String crearFormularioArticulosU(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);

        return "crearFormularioArticulosU";
    }

    @GetMapping("/crearFormularioPosdoctoral/{idPersona}")
    public String crearFormularioPosdoctoral(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);

        return "crearFormularioPosdoctoral";
    }

    @GetMapping("/crearFormularioPonencia/{idPersona}")
    public String crearFormularioPonencia(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoDifusion> tipoDifusiones = tipoDifusionService.listarTipoDifusiones();

        model.addAttribute("persona", persona);
        model.addAttribute("tipoDifusiones", tipoDifusiones);
        return "crearFormularioPonencia";
    }

    @GetMapping("/crearFormularioPremio/{idPersona}")
    public String crearFormularioPremio(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoDifusion> tipoDifusiones = tipoDifusionService.listarTipoDifusiones();

        model.addAttribute("tipoDifusiones", tipoDifusiones);
        model.addAttribute("persona", persona);

        return "crearFormularioPremio";
    }

    @GetMapping("/crearFormularioAudioVisuales/{idPersona}")
    public String crearFormularioAudioVisuales(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoDifusion> tipoDifusiones = tipoDifusionService.listarTipoDifusiones();
        List<TipoMaterial> tipoMateriales = tipoMaterialService.listarTipoMateriales();
        List<TipoAporte> tipoAportes = tipoAporteService.listarTipoAportes();

        model.addAttribute("tipoAportes", tipoAportes);
        model.addAttribute("tipoMateriales", tipoMateriales);
        model.addAttribute("tipoDifusiones", tipoDifusiones);
        model.addAttribute("persona", persona);

        return "crearFormularioAudioVisuales";
    }

    @GetMapping("/crearFormularioLibroEnsayo/{idPersona}")
    public String crearFormularioLibroEnsayo(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);

        return "crearFormularioLibroEnsayo";
    }

    @GetMapping("/crearFormularioLibroTexto/{idPersona}")
    public String crearFormularioLibroTexto(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);

        return "crearFormularioLibroTexto";
    }

    @GetMapping("/crearFormularioLibroInvestigacion/{idPersona}")
    public String crearFormularioLibroInvestigacion(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);

        return "crearFormularioLibroInvestigacion";
    }

    @GetMapping("/crearFormularioObraArtistica/{idPersona}")
    public String crearFormularioObraArtistica(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoReconocimiento> tipoReconocimientos = tipoReconocimientoService.listarTipoReconocimientos();
        List<TipoObra> tipoObras = tipoObraService.listarTipoObras();

        model.addAttribute("tipoObras", tipoObras);
        model.addAttribute("tipoReconocimientos", tipoReconocimientos);
        model.addAttribute("persona", persona);

        return "crearFormularioObraArtistica";
    }

    @GetMapping("/crearFormularioPatente/{idPersona}")
    public String crearFormularioPatente(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoPatente> tipoPatentes = tipoPatenteService.listarTipoPatentes();

        model.addAttribute("persona", persona);
        model.addAttribute("tipoPatentes", tipoPatentes);

        return "crearFormularioPatente";
    }

    @GetMapping("/crearFormularioProduccionTecnica/{idPersona}")
    public String crearFormularioProduccionTecnica(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoProduccion> tipoProducciones = tipoProduccionService.listarTipoProducciones();

        model.addAttribute("persona", persona);
        model.addAttribute("tipoProducciones", tipoProducciones);

        return "crearFormularioProduccionTecnica";
    }

    @GetMapping("/crearFormularioSoftware/{idPersona}")
    public String crearFormularioSoftware(Persona persona, Model model) {

        persona = personaService.encontrarPersona(persona);
        List<TipoProduccion> tipoProducciones = tipoProduccionService.listarTipoProducciones();

        model.addAttribute("persona", persona);
        model.addAttribute("tipoProducciones", tipoProducciones);

        return "crearFormularioSoftware";
    }

    @PostMapping("/agregarFormularioArticulos/{idPersona}")
    public String agregarFormularioArticulos(@Validated Formulario formulario, @Validated FORMPAArticulos formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioArticulosService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Utilidades.calcularPuntajeArticulos(formularioEspecifico.getCategoriaIndexada()), Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);

        return "redirect:/";
    }

    @PostMapping("/agregarFormularioDireccionTesis/{idPersona}")
    public String agregarFormularioDireccionTesis(@Validated Formulario formulario, @Validated FORMBONDireccionTesis formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioDireccionTesisService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_DIRECCION_TESIS, Constantes.BONIFICACION, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioSoftware/{idPersona}")
    public String agregarFormularioSoftware(@Validated Formulario formulario, @Validated FORMPASoftware formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioSoftwareService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, "0", Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioProduccionTecnica/{idPersona}")
    public String agregarFormularioProduccionTecnica(@Validated Formulario formulario, @Validated FORMPAProduccionTecnica formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioProduccionTecnicaService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, "0", Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioPatente/{idPersona}")
    public String agregarFormularioPatente(@Validated Formulario formulario, @Validated FORMPAPatente formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioPatenteService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_PATENTE, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioObraArtistica/{idPersona}")
    public String agregarFormularioObraArtistica(@Validated Formulario formulario, @Validated FORMPAObraArtistica formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioObraArtisticaService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_OBRA_ARTISTICA, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioLibroInvestigacion/{idPersona}")
    public String agregarFormularioLibroInvestigacion(@Validated Formulario formulario, @Validated FORMPALibroInvestigacion formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);
        
        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioLibroInvestigacionService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_LIBRO_INVESTIGACION, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioLibroTexto/{idPersona}")
    public String agregarFormularioLibroTexto(@Validated Formulario formulario, @Validated FORMPALibroTexto formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioLibroTextoService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_LIBRO_TEXTO, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioLibroEnsayo/{idPersona}")
    public String agregarFormularioLibroEnsayo(@Validated Formulario formulario, @Validated FORMPALibroEnsayo formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioLibroEnsayoService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_LIBRO_ENSAYO, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioAudioVisuales/{idPersona}")
    public String agregarFormularioAudioVisuales(@Validated Formulario formulario, @Validated FORMPAAudiovisuales formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioAudiovisualService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Utilidades.calcularPuntajeAudiovisual(formularioEspecifico.getTipoDifusion().getNombre()), Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioPremio/{idPersona}")
    public String agregarFormularioPremio(@Validated Formulario formulario, @Validated FORMPAPremio formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioPremioService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_PREMIO, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioOtrasRevistas/{idPersona}")
    public String agregarFormularioOtrasRevistas(@Validated Formulario formulario, @Validated FORMPAOtrasRevistas formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioOtrasRevistasService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_OTRAS_REVISTAS, Constantes.PRODUCTIVIDAD_ACADEMICA, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioArticulosU/{idPersona}")
    public String agregarFormularioArticulosU(@Validated Formulario formulario, @Validated FORMBONArticulosU formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioArticulosUService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_ARTICULOS_U, Constantes.BONIFICACION, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioPosdoctoral/{idPersona}")
    public String agregarFormularioPosdoctoral(@Validated Formulario formulario, @Validated FORMBONEstudioPosdoctoral formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioPosdoctoralService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Constantes.PUNTAJE_POSDOCTORAL, Constantes.BONIFICACION, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }

    @PostMapping("/agregarFormularioPonencia/{idPersona}")
    public String agregarFormularioPonencia(@Validated Formulario formulario, @Validated FORMBONPonencia formularioEspecifico, Persona persona, @RequestParam("file") MultipartFile archivo) {

        persona = personaService.encontrarPersona(persona);

        formularioService.guardar(formulario);

        formularioEspecifico.setIdFormulario(formulario.getIdFormulario());
        formularioPonenciaService.guardar(formularioEspecifico);

        Solicitud solicitud = solicitudService.construirSolicitud(persona, Constantes.NUEVA, formulario, Utilidades.calcularPuntajePonencia(formularioEspecifico.getTipoDifusion().getNombre()), Constantes.BONIFICACION, Constantes.CORREO_CUERPO_CREACION_NUEVA);
        documentoService.persistirDocumento(solicitud, archivo);
        return "redirect:/";
    }
}

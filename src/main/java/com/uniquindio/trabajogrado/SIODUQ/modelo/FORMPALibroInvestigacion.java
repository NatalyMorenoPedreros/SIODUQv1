package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_libro_investigacion")
public class FORMPALibroInvestigacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "anioasignacion")
    private String anioAsignacion;
    @Column(name = "numeroedicion")
    private String numeroEdicion;
    @Column(name = "numeroejemplares")
    private Integer numeroEjemplares;
    @Column(name = "areaconocimiento")
    private String areaConocimiento;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "tituloartpublicado")
    private String tituloArticuloPublicado;
    @Column(name = "anioartpublicado")
    private String anioPublicacionArticulo;
    @Column(name = "artpresentadoantes")
    private String articuloPresentadoAntes;
    @Column(name = "fechapresentacionant")
    private String fechaPresentacionAnterior;
    @Column(name = "tituloproyecto")
    private String tituloProyecto;
    @Column(name = "certificaprimervez")
    private String certificadoPrimeraVez;    
}

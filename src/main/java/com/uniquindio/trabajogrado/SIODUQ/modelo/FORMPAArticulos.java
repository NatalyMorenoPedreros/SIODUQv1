package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_articulos")
public class FORMPAArticulos implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipodifusion")    
    TipoDifusion tipoDifusion;
    
    @OneToOne
    @JoinColumn(name = "tiporevista")
    TipoRevista tipoRevista;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "titulorevista")
    private String tituloRevista;
    @Column(name = "issn")
    private String issn;
    @Column(name = "fechaaceptacion")
    private String fechaAceptacion;
    @Column(name = "fechapublicacion")
    private String fechaPublicacion;
    @Column(name = "categoriaindexada")
    private String categoriaIndexada;
    @Column(name = "fechaindexacion")
    private String fechaIndexacion;
    @Column(name = "proyectoinvestigacion")
    private String proyectoInvestigacion;
    @Column(name = "numeroproyecto")
    private String numeroProyecto;
    @Column(name = "pais")
    private String pais;
    @Column(name = "editorial")
    private String editorial;
    @Column(name = "idioma")
    private String idioma;
    @Column(name = "paginas")
    private String paginas;
    @Column(name = "paginainicial")
    private String paginaInicial;
    @Column(name = "paginafinal")
    private String paginaFinal;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "sir")
    private String sir;
    @Column(name = "universidades")
    private String universidades;
}

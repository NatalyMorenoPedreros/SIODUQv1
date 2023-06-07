package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_audiovisuales")
public class FORMPAAudiovisuales implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipomaterial")
    TipoMaterial tipoMaterial;
    
    @OneToOne
    @JoinColumn(name = "tipodifusion")
    TipoDifusion tipoDifusion;
    
    @OneToOne
    @JoinColumn(name = "tipoaporte")
    TipoAporte tipoAporte;
    
    @Column(name = "titulorevista")
    private String tituloRevista;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "anio")
    private String anio;
    @Column(name = "mediodifusion")
    private String medioDifusion;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "areaconocimiento")
    private String areaConocimiento;
    @Column(name = "temaespecifico")
    private String tema;
    @Column(name = "audiencia")
    private String audiencia;
    @Column(name = "guia")
    private String guia;
    
}

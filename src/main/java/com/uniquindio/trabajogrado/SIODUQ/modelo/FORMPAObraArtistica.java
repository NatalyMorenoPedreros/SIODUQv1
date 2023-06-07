package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_obra_artistica")
public class FORMPAObraArtistica implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipoobra")
    TipoObra tipoObra;
    
    @OneToOne
    @JoinColumn(name = "tiporeconocimiento")
    TipoReconocimiento tipoReconocimiento;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fechacreacion")
    private String fechaCreacion;
    @Column(name = "tecnica")
    private String tecnica;
    @Column(name = "dimension")
    private String dimension;
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @Column(name = "director")
    private String director;
    @Column(name = "autorguion")
    private String autorGuion;
    @Column(name = "salaejecucion")
    private String salaEjecucion;
    @Column(name = "fechaexhibicion")
    private String fechaExhibicion;
    @Column(name = "ciudadexhibicion")
    private String ciudadExhibicion;
    @Column(name = "numeropresentacion")
    private String numeroPresentacion;
    @Column(name = "rol")
    private String rol;
    @Column(name = "entidad")
    private String entidad;
    @Column(name = "area")
    private String area;
    @Column(name = "fechacreacionguion")
    private String fechaCreacionGuion;
    
}

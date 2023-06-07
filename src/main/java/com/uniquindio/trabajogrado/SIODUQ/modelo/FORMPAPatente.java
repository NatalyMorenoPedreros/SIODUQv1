package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_patente")
public class FORMPAPatente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipopatente")
    TipoPatente tipoPatente;
    
    @Column(name = "numeroresolucion")
    private String numeroResolucion;
    @Column(name = "numeroregistro")
    private String numeroRegistro;
    @Column(name = "nombreproducto")
    private String nombreProducto;
    @Column(name = "vigencia")
    private String vigencia;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "areaconocimiento")
    private String areaConocimiento;
    @Column(name = "universidades")
    private String universidades;
}

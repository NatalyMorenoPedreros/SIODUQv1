package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_produccion_tecnica")
public class FORMPAProduccionTecnica implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipoproduccion")
    TipoProduccion tipoProduccion;
    
    @Column(name = "fechacreacion")
    private String fechaCreacion;
    @Column(name = "nombreproducto")
    private String nombreProducto;
    @Column(name = "areaconocimiento")
    private String areaConocimiento;
    @Column(name = "universidades")
    private String universidades;
}

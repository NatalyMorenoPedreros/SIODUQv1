package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_software")
public class FORMPASoftware implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipoproduccion")
    TipoProduccion tipoProduccion;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numeroregistro")
    private String numeroRegistro;
    @Column(name = "fechaexpedicion")
    private String fechaExpedicion;
    @Column(name = "areaconocimiento")
    private String area;
    @Column(name = "universidades")
    private String universidades;
}

package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formpa_premio")
public class FORMPAPremio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipodifusion")
    TipoDifusion tipoDifusion;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "premio")
    private String premio;
    @Column(name = "presentadoantes")
    private String presentadoAntes;
    @Column(name = "fechaantes")
    private String fechaAntes;
    @Column(name = "institucion")
    private String institucion;
    @Column(name = "fechaotorgamiento")
    private String fechaOtorgamiento;
    @Column(name = "universidades")
    private String universidades;
}

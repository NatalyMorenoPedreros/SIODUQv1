package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formbon_posdoctoral")
public class FORMBONEstudioPosdoctoral implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "titulotrabajo")
    private String tituloTrabajo;
    @Column(name = "fechainicio")
    private String fechaInicio;
    @Column(name = "fechafinaliza")
    private String fechaFinaliza;
    @Column(name = "entidad")
    private String entidad;
}

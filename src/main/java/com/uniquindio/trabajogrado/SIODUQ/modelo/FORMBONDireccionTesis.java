package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formbon_direccion_tesis")
public class FORMBONDireccionTesis implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipotesis")
    TipoTesis tipoTesis;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "nombreestudiante")
    private String nombreEstudiante;
    @Column(name = "fechasustentacion")
    private String fechaSustentacion;
    @Column(name = "programaestudiante")
    private String programaEstudiante;
    @Column(name = "universidadestudiante")
    private String universidad;
}

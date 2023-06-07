package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formulario")
public class Formulario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @Column(name = "fechapresentacion")
    private String fechaPresentacion;
    @Column(name = "nombreautores")
    private String nombreAutores;
    @Column(name = "numeroautores")
    private int numeroAutores;
    @Column(name = "codigo")
    private String codigo;
    
}

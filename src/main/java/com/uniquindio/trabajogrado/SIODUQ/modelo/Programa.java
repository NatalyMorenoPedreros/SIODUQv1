package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "programa")
public class Programa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Integer idPrograma;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "ext")
    private String extension;
}

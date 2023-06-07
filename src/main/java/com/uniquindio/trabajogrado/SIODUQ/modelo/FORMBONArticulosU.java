package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formbon_articulo_u")
public class FORMBONArticulosU implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombrerevista")
    private String nombreRevista;
    @Column(name = "issn")
    private String issn;
    @Column(name = "aniopublicacion")
    private String anioPublicacion;
}

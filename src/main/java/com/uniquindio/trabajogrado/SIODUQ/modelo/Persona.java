package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @OneToOne
    @JoinColumn(name = "tipoidentificacion")
    TipoIdentificacion tipoIdentificacion;
    
    @OneToOne
    @JoinColumn(name = "programa")
    Programa programa;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "celular")
    private String celular;
    @Column(name = "correo")
    private String correo;
    @Column(name = "identificacion")
    private String identificacion;
}

package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formbon_ponencia")
public class FORMBONPonencia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "idformulario")
    private Integer idFormulario;
    
    @OneToOne
    @JoinColumn(name = "tipodifusion")
    TipoDifusion tipoDifusion;
    
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "aniopublicado")
    private String anioPublicado;
    @Column(name = "lugarevento")
    private String lugarEvento;
    @Column(name = "fechaevento")
    private String fechaEvento;
    @Column(name = "nombreevento")
    private String nombreEvento;
    @Column(name = "certificaprimervez")
    private String certificadoPrimeraVez;
}

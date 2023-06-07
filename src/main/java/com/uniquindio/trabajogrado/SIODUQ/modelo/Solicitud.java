package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;
    
    @OneToOne
    @JoinColumn(name = "estado")
    Estado estado;
    
    @OneToOne
    @JoinColumn(name = "formulario")
    Formulario formulario;
    
    @ManyToOne
    @JoinColumn(name = "persona")
    Persona persona;
   
    @OneToOne
    @JoinColumn(name = "tiposolicitud")
    TipoSolicitud tipoSolicitud;
    
    @Column(name = "fechacreacion")
    private Timestamp fechaCreacion;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "puntajetentativo")
    private String puntajeTentativo;
}

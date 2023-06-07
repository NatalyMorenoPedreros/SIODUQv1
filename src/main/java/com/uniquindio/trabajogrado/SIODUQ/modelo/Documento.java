package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "documento")
public class Documento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Integer idDocumento;
    
    @ManyToOne
    @JoinColumn(name = "solicitud")
    Solicitud solicitud;
    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "urldocumento")
    private String direccionURL;
    @Column(name = "fechacarga")
    private Timestamp fechaCarga;
}

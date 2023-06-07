package com.uniquindio.trabajogrado.SIODUQ.modelo;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipo_difusion")
public class TipoDifusion {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_difusion")
    private Integer idTipoDifusion;
    @Column(name = "nombre")
    private String nombre;
}

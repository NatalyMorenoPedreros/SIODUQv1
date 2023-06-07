package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notificacion")
public class Notificacion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;

    @ManyToOne
    @JoinColumn(name = "solicitud")
    Solicitud solicitud;
    
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fechacreacion")
    private Timestamp fechaCreacion;
}

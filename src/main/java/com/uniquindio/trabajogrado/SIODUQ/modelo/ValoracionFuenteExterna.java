package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "valoracion_fuente_externa")
public class ValoracionFuenteExterna implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion")
    private Integer idValoracion;
    
    @ManyToOne
    @JoinColumn(name = "solicitud")
    Solicitud solicitud;
    
    @Column(name = "puntajetentativo")
    private String puntajeTentativo;
    @Column(name = "nombreevaluador")
    private String nombreEvaluador;
    @Column(name = "correo")
    private String correo;
    @Column(name = "fecha")
    private String fecha;
}

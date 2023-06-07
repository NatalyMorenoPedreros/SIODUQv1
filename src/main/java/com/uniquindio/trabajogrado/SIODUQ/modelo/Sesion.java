package com.uniquindio.trabajogrado.SIODUQ.modelo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sesion")
public class Sesion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private Integer idSesion;
    
    @OneToOne
    @JoinColumn(name= "persona")
    Persona persona;
    
    @OneToOne
    @JoinColumn(name="rol")
    Rol rol;
    
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
}

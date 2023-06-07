package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Formulario;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudDao extends JpaRepository<Solicitud, Integer>{
    
    List<Solicitud> findByPersona (Persona persona);
    
    Solicitud findByFormulario (Formulario formulario);
    
    long countByPersona(Persona persona);
    
}

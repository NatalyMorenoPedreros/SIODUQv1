package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Documento;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoDao extends JpaRepository<Documento, Integer>{
    
    Documento findBySolicitud(Solicitud solicitud);
}

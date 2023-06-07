package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoSolicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITipoSolicitudDao extends JpaRepository<TipoSolicitud, Integer> {

    TipoSolicitud findByNombre(String nombre);
}

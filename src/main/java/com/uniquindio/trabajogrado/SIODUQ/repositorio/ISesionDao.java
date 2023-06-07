package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISesionDao extends JpaRepository<Sesion, Integer>{
    Sesion findByUsername(String username);
}

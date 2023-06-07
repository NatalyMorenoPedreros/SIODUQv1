package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaDao extends JpaRepository<Persona, Integer>{
    
}

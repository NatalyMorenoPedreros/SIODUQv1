package com.uniquindio.trabajogrado.SIODUQ.repositorio;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoDao extends JpaRepository<Estado, Integer>{
    
    Estado findByNombre(String nombre);
    
}

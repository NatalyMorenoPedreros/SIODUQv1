package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IEstadoDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    private IEstadoDao estadoDao;
    
    @Override
    public List<Estado> listarEstados() {
        return (List<Estado>) estadoDao.findAll();
    }

    @Override
    public void guardar(Estado estado) {
        estadoDao.save(estado);
    }

    @Override
    public void eliminar(Estado estado) {
        estadoDao.delete(estado);
    }

    @Override
    public Estado encontrarEstado(Estado estado) {
        return estadoDao.findById(estado.getIdEstado()).orElse(null);
    }

    @Override
    public Estado encontrarEstadoPorNombre(String nombre) {
        return estadoDao.findByNombre(nombre);
    }
}

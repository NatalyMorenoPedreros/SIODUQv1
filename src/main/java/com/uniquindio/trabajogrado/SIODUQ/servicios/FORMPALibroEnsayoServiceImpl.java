package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPALibroEnsayoDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroEnsayo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPALibroEnsayoServiceImpl implements FORMPALibroEnsayoService {

    @Autowired
    private IFORMPALibroEnsayoDao formularioDao;

    @Override
    public List<FORMPALibroEnsayo> listarFORMPALibroEnsayos() {
        return (List<FORMPALibroEnsayo>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPALibroEnsayo formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPALibroEnsayo formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPALibroEnsayo encontrarFORMPALibroEnsayo(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

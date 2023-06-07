package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPAAudiovisualesDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAAudiovisuales;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPAAudiovisualesServiceImpl implements FORMPAAudiovisualesService {

    @Autowired
    private IFORMPAAudiovisualesDao formularioDao;

    @Override
    public List<FORMPAAudiovisuales> listarFORMPAAudiovisuales() {
        return (List<FORMPAAudiovisuales>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPAAudiovisuales formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPAAudiovisuales formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPAAudiovisuales encontrarFORMPAAudiovisuales(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

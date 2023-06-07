package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPASoftwareDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPASoftware;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPASoftwareServiceImpl implements FORMPASoftwareService {

    @Autowired
    private IFORMPASoftwareDao formularioDao;

    @Override
    public List<FORMPASoftware> listarFORMPASoftwares() {
        return (List<FORMPASoftware>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPASoftware formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPASoftware formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPASoftware encontrarFORMPASoftware(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPAProduccionTecnicaDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAProduccionTecnica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPAProduccionTecnicaServiceImpl implements FORMPAProduccionTecnicaService {

    @Autowired
    private IFORMPAProduccionTecnicaDao formularioDao;

    @Override
    public List<FORMPAProduccionTecnica> listarFORMPAProduccionTecnicas() {
        return (List<FORMPAProduccionTecnica>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPAProduccionTecnica formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPAProduccionTecnica formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPAProduccionTecnica encontrarFORMPAProduccionTecnica(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

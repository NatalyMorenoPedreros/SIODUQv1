package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPALibroInvestigacionDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPALibroInvestigacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPALibroInvestigacionServiceImpl implements FORMPALibroInvestigacionService {

    @Autowired
    private IFORMPALibroInvestigacionDao formularioDao;

    @Override
    public List<FORMPALibroInvestigacion> listarFORMPALibroInvestigaciones() {
        return (List<FORMPALibroInvestigacion>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPALibroInvestigacion formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPALibroInvestigacion formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPALibroInvestigacion encontrarFORMPALibroInvestigacion(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }
}

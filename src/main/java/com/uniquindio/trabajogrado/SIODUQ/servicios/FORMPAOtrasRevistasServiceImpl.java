package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMBONOtrasRevistasDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAOtrasRevistas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FORMPAOtrasRevistasServiceImpl implements FORMPAOtrasRevistasService {

    @Autowired
    private IFORMBONOtrasRevistasDao formularioDao;

    @Override
    public List<FORMPAOtrasRevistas> listarFORMBONOtrasRevistas() {
        return (List<FORMPAOtrasRevistas>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPAOtrasRevistas formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPAOtrasRevistas formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPAOtrasRevistas encontrarFORMBONOtrasRevistas(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

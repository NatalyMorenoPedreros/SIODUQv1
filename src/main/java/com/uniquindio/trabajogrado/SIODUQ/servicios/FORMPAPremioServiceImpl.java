package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.FORMPAPremio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniquindio.trabajogrado.SIODUQ.repositorio.IFORMPAPremioDao;

@Service
public class FORMPAPremioServiceImpl implements FORMPAPremioService {

    @Autowired
    private IFORMPAPremioDao formularioDao;

    @Override
    public List<FORMPAPremio> listarFORMPAPremios() {
        return (List<FORMPAPremio>) formularioDao.findAll();
    }

    @Override
    public void guardar(FORMPAPremio formulario) {
        formularioDao.save(formulario);
    }

    @Override
    public void eliminar(FORMPAPremio formulario) {
        formularioDao.delete(formulario);
    }

    @Override
    public FORMPAPremio encontrarFORMPAPremio(Integer formulario) {
        return formularioDao.findById(formulario).orElse(null);
    }

}

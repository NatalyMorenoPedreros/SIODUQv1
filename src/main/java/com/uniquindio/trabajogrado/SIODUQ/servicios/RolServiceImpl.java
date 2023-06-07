package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IRolDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Rol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private IRolDao rolDao;

    @Override
    public List<Rol> listarRoles() {
        return (List<Rol>) rolDao.findAll();
    }

    @Override
    public void guardar(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    public void eliminar(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    public Rol encontrarRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    public Rol encontrarRolPorNombre(String nombre) {
        return rolDao.findByNombre(nombre);
    }

}

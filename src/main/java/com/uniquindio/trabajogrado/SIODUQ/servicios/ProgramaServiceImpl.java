package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IProgramaDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    private IProgramaDao programaDao;

    @Override
    public List<Programa> listarProgramas() {
        return (List<Programa>) programaDao.findAll();
    }

    @Override
    public void guardar(Programa programa) {
        programaDao.save(programa);
    }

    @Override
    public void eliminar(Programa programa) {
        programaDao.delete(programa);
    }

    @Override
    public Programa encontrarPrograma(Programa programa) {
        return programaDao.findById(programa.getIdPrograma()).orElse(programa);
    }

}

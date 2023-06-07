package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.IValoracionFuenteExternaDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.ValoracionFuenteExterna;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValoracionFuenteExternaServiceImpl implements ValoracionFuenteExternaService {

    @Autowired
    private IValoracionFuenteExternaDao valoracionFuenteExternaDao;

    @Override
    @Transactional(readOnly = true)
    public List<ValoracionFuenteExterna> listarValoracionFuenteExternas() {
        return (List<ValoracionFuenteExterna>) valoracionFuenteExternaDao.findAll();
    }

    @Override
    public void guardar(ValoracionFuenteExterna valoracionFuenteExterna) {
        valoracionFuenteExternaDao.save(valoracionFuenteExterna);
    }

    @Override
    public void eliminar(ValoracionFuenteExterna valoracionFuenteExterna) {
        valoracionFuenteExternaDao.delete(valoracionFuenteExterna);
    }

    @Override
    @Transactional(readOnly = true)
    public ValoracionFuenteExterna encontrarValoracionFuenteExterna(ValoracionFuenteExterna valoracionFuenteExterna) {
        return valoracionFuenteExternaDao.findById(valoracionFuenteExterna.getIdValoracion()).orElse(null);
    }

}

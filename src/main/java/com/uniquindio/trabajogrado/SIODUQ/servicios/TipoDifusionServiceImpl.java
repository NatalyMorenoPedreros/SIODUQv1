package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoDifusionDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoDifusion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDifusionServiceImpl implements TipoDifusionService {

    @Autowired
    private ITipoDifusionDao tipoDifusionDao;

    @Override
    public List<TipoDifusion> listarTipoDifusiones() {
        return (List<TipoDifusion>) tipoDifusionDao.findAll();
    }

    @Override
    public void guardar(TipoDifusion tipoDifusion) {
        tipoDifusionDao.save(tipoDifusion);
    }

    @Override
    public void eliminar(TipoDifusion tipoDifusion) {
        tipoDifusionDao.delete(tipoDifusion);
    }

    @Override
    public TipoDifusion encontrarTipoDifusion(TipoDifusion tipoDifusion) {
        return tipoDifusionDao.findById(tipoDifusion.getIdTipoDifusion()).orElse(null);
    }

}

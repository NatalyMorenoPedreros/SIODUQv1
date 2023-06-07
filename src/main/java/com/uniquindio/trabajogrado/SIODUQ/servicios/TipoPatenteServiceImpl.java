package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoPatenteDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoPatente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPatenteServiceImpl implements TipoPatenteService {

    @Autowired
    private ITipoPatenteDao tipoPatenteDao;

    @Override
    public List<TipoPatente> listarTipoPatentes() {
        return (List<TipoPatente>) tipoPatenteDao.findAll();
    }

    @Override
    public void guardar(TipoPatente tipoPatente) {
        tipoPatenteDao.save(tipoPatente);
    }

    @Override
    public void eliminar(TipoPatente tipoPatente) {
        tipoPatenteDao.delete(tipoPatente);
    }

    @Override
    public TipoPatente encontrarTipoPatente(TipoPatente tipoPatente) {
        return tipoPatenteDao.findById(tipoPatente.getIdTipoPatente()).orElse(null);
    }
}

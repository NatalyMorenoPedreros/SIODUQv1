package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoObraDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoObra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoObraServiceImpl implements TipoObraService {

    @Autowired
    private ITipoObraDao tipoObraDao;

    @Override
    public List<TipoObra> listarTipoObras() {
        return (List<TipoObra>) tipoObraDao.findAll();
    }

    @Override
    public void guardar(TipoObra tipoObra) {
        tipoObraDao.save(tipoObra);
    }

    @Override
    public void eliminar(TipoObra tipoObra) {
        tipoObraDao.delete(tipoObra);
    }

    @Override
    public TipoObra encontrarTipoObra(TipoObra tipoObra) {
        return tipoObraDao.findById(tipoObra.getIdTipoObra()).orElse(null);
    }

}

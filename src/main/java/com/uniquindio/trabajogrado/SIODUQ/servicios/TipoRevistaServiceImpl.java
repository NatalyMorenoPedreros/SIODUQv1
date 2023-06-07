package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoRevistaDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoRevista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoRevistaServiceImpl implements TipoRevistaService {

    @Autowired
    private ITipoRevistaDao tipoRevistaDao;

    @Override
    public List<TipoRevista> listarTipoRevistas() {
        return (List<TipoRevista>) tipoRevistaDao.findAll();
    }

    @Override
    public void guardar(TipoRevista tipoRevista) {
        tipoRevistaDao.save(tipoRevista);
    }

    @Override
    public void eliminar(TipoRevista tipoRevista) {
        tipoRevistaDao.delete(tipoRevista);
    }

    @Override
    public TipoRevista encontrarTipoRevista(TipoRevista tipoRevista) {
        return tipoRevistaDao.findById(tipoRevista.getIdTipoRevista()).orElse(null);
    }

}

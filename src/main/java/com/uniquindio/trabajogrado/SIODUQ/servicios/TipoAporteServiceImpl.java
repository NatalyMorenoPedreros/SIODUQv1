package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoAporteDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoAporte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoAporteServiceImpl implements TipoAporteService {

    @Autowired
    private ITipoAporteDao tipoAporteDao;

    @Override
    public List<TipoAporte> listarTipoAportes() {
        return (List<TipoAporte>) tipoAporteDao.findAll();
    }

    @Override
    public void guardar(TipoAporte tipoAporte) {
        tipoAporteDao.save(tipoAporte);
    }

    @Override
    public void eliminar(TipoAporte tipoAporte) {
        tipoAporteDao.delete(tipoAporte);
    }

    @Override
    public TipoAporte encontrarTipoAporte(TipoAporte tipoAporte) {
        return tipoAporteDao.findById(tipoAporte.getIdTipoAporte()).orElse(null);
    }

}

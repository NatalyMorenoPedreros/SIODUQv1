package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoPublicacionDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoPublicacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoPublicacionServiceImpl implements TipoPublicacionService {

    @Autowired
    private ITipoPublicacionDao tipoPublicacionDao;

    @Override
    public List<TipoPublicacion> listarTipoPublicaciones() {
        return (List<TipoPublicacion>) tipoPublicacionDao.findAll();
    }

    @Override
    public void guardar(TipoPublicacion tipoPublicacion) {
        tipoPublicacionDao.save(tipoPublicacion);
    }

    @Override
    public void eliminar(TipoPublicacion tipoPublicacion) {
        tipoPublicacionDao.delete(tipoPublicacion);
    }

    @Override
    public TipoPublicacion encontrarTipoPublicacion(TipoPublicacion tipoPublicacion) {
        return tipoPublicacionDao.findById(tipoPublicacion.getIdTipoPublicacion()).orElse(null);
    }

}

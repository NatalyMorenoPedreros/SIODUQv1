package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoIdentificacionDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoIdentificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

    @Autowired
    private ITipoIdentificacionDao tipoIdentificacionDao;

    @Override
    public List<TipoIdentificacion> listarTipoIdentificaciones() {
        return (List<TipoIdentificacion>) tipoIdentificacionDao.findAll();
    }

    @Override
    public void guardar(TipoIdentificacion tipoIdentificacion) {
        tipoIdentificacionDao.save(tipoIdentificacion);
    }

    @Override
    public void eliminar(TipoIdentificacion tipoIdentificacion) {
        tipoIdentificacionDao.delete(tipoIdentificacion);
    }

    @Override
    public TipoIdentificacion encontrarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionDao.findById(tipoIdentificacion.getIdTipoIdentificacion()).orElse(null);
    }

}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoSolicitudDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoSolicitud;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSolicitudServiceImpl implements TipoSolicitudService {

    @Autowired
    private ITipoSolicitudDao tipoSolicitudDao;

    @Override
    public List<TipoSolicitud> listarTipoSolicitudes() {
        return (List<TipoSolicitud>) tipoSolicitudDao.findAll();
    }

    @Override
    public void guardar(TipoSolicitud tipoSolicitud) {
        tipoSolicitudDao.save(tipoSolicitud);
    }

    @Override
    public void eliminar(TipoSolicitud tipoSolicitud) {
        tipoSolicitudDao.delete(tipoSolicitud);
    }

    @Override
    public TipoSolicitud encontrarTipoSolicitud(TipoSolicitud tipoSolicitud) {
        return tipoSolicitudDao.findById(tipoSolicitud.getIdTipoSolicitud()).orElse(null);
    }

    @Override
    public TipoSolicitud encontrarTipoPorNombre(String nombre) {
        return tipoSolicitudDao.findByNombre(nombre);
    }

}

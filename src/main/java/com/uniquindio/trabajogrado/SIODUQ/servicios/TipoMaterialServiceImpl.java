package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.repositorio.ITipoMaterialDao;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoMaterial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoMaterialServiceImpl implements TipoMaterialService {

    @Autowired
    private ITipoMaterialDao tipoMaterialDao;

    @Override
    public List<TipoMaterial> listarTipoMateriales() {
        return (List<TipoMaterial>) tipoMaterialDao.findAll();
    }

    @Override
    public void guardar(TipoMaterial tipoMaterial) {
        tipoMaterialDao.save(tipoMaterial);
    }

    @Override
    public void eliminar(TipoMaterial tipoMaterial) {
        tipoMaterialDao.delete(tipoMaterial);
    }

    @Override
    public TipoMaterial encontrarTipoMaterial(TipoMaterial tipoMaterial) {
        return tipoMaterialDao.findById(tipoMaterial.getIdTipoMaterial()).orElse(tipoMaterial);
    }

}

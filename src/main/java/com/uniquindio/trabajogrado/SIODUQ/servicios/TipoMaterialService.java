package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoMaterial;
import java.util.List;

public interface TipoMaterialService {
    public List<TipoMaterial> listarTipoMateriales();
    
    public void guardar(TipoMaterial tipoMaterial);
    
    public void eliminar(TipoMaterial tipoMaterial);
    
    public TipoMaterial encontrarTipoMaterial(TipoMaterial tipoMaterial);
}

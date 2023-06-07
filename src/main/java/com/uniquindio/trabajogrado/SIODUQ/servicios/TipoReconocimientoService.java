package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoReconocimiento;
import java.util.List;

public interface TipoReconocimientoService {
    public List<TipoReconocimiento> listarTipoReconocimientos();
    
    public void guardar(TipoReconocimiento tipoReconocimiento);
    
    public void eliminar(TipoReconocimiento tipoReconocimiento);
    
    public TipoReconocimiento encontrarTipoReconocimiento(TipoReconocimiento tipoReconocimiento);
}

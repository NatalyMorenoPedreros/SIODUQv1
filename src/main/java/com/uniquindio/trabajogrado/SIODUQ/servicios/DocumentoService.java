package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.modelo.Documento;
import com.uniquindio.trabajogrado.SIODUQ.modelo.Solicitud;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface DocumentoService {
    public List<Documento> listarDocumentos();
    
    public void guardar(Documento documento);
    
    public void eliminar(Documento documento);
    
    public Documento encontrarDocumento(Documento documento);
    
    public void persistirDocumento(Solicitud solicitud, MultipartFile archivo);
    
    public Documento obtenerDocumentoPorSolicitud(Solicitud solicitud);
    
    public void actualizarDocumento(MultipartFile archivo, Documento documento);
    
}

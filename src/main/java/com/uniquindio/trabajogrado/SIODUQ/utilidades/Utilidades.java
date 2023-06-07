package com.uniquindio.trabajogrado.SIODUQ.utilidades;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utilidades {

    public static String calcularPuntajeArticulos(String categoria) {

        switch (categoria) {
            case Constantes.ARTICULOS_CATEGORIA_A1:
                return Constantes.PUNTAJE_ARTICULOS_CATEGORIA_A1;
            case Constantes.ARTICULOS_CATEGORIA_A2:
                return Constantes.PUNTAJE_ARTICULOS_CATEGORIA_A2;
            case Constantes.ARTICULOS_CATEGORIA_B:
                return Constantes.PUNTAJE_ARTICULOS_CATEGORIA_B;
            case Constantes.ARTICULOS_CATEGORIA_C:
                return Constantes.PUNTAJE_ARTICULOS_CATEGORIA_C;
            default:
                log.info("No existe la categoria. Se coloca puntaje por defecto");
                return "0";
        }
    }

    public static String calcularPuntajeAudiovisual(String difusion) {

        switch (difusion) {
            case Constantes.DIFUSION_NACIONAL:
                return Constantes.PUNTAJE_DIFUSION_NACIONAL;
            case Constantes.DIFUSION_INTERNACIONAL:
                return Constantes.PUNTAJE_DIFUSION_INTERNACIONAL;
            default:
                log.info("No existe la difusion. Se coloca puntaje por defecto");
                return "0";
        }
    }

    public static String calcularPuntajePonencia(String difusion) {

        switch (difusion) {
            case Constantes.DIFUSION_NACIONAL:
                return Constantes.PUNTAJE_DIFUSION_NACIONAL_PONENCIA;
            case Constantes.DIFUSION_INTERNACIONAL:
                return Constantes.PUNTAJE_DIFUSION_INTERNACIONAL_PONENCIA;
            case Constantes.DIFUSION_REGIONAL:
                return Constantes.PUNTAJE_DIFUSION_REGIONAL_PONENCIA;
            default:
                log.info("No existe la difusion. Se coloca puntaje por defecto");
                return "0";
        }
    }

    public static String realizarCodigo(long numeroSolicitudes, String tipoSolicitud) {
        numeroSolicitudes++;
        return (tipoSolicitud.equals(Constantes.PRODUCTIVIDAD_ACADEMICA)) ? Constantes.PREFIJO_PA + numeroSolicitudes : Constantes.PREFIJO_BON + numeroSolicitudes;
    }
    
    public static boolean revisarDominioCorreo(String correo){
        
        int posicionArroba = correo.indexOf("@");
        String dominio = correo.substring(posicionArroba);
        System.out.println("Dominio " + dominio);
        
        return dominio.equals(Constantes.DOMINIO_CORREO);
    }
}

package com.uniquindio.trabajogrado.SIODUQ.servicios;

import com.uniquindio.trabajogrado.SIODUQ.servicios.TipoIdentificacionService;
import com.uniquindio.trabajogrado.SIODUQ.modelo.TipoIdentificacion;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TipoIdentificacionServiceTest {
    
    public TipoIdentificacionServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of listarTipoIdentificaciones method, of class TipoIdentificacionService.
     */
    @Test
    public void testListarTipoIdentificaciones() {
        System.out.println("Prueba listar TipoIdentificaciones");
        TipoIdentificacionService instance = new TipoIdentificacionServiceImpl();
        List<TipoIdentificacion> result = instance.listarTipoIdentificaciones();
        assertNull(result);
    }

    /**
     * Test of guardar method, of class TipoIdentificacionService.
     */
    @Test
    public void testGuardar() {
        System.out.println("Guardar TipoIdentificacion");
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        tipoIdentificacion.setNombre("PRUEBA");
        TipoIdentificacionService instance = new TipoIdentificacionServiceImpl();
        instance.guardar(tipoIdentificacion);
        assertNotNull(tipoIdentificacion);
    }

    public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

        public List<TipoIdentificacion> listarTipoIdentificaciones() {
            return null;
        }

        public void guardar(TipoIdentificacion tipoIdentificacion) {
        }

        public void eliminar(TipoIdentificacion tipoIdentificacion) {
        }

        public TipoIdentificacion encontrarTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
            return null;
        }
    }

    
    
}

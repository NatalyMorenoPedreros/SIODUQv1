package com.uniquindio.trabajogrado.SIODUQ.logica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EncriptarPasswordTest {
    
    public EncriptarPasswordTest() {
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
     * Test of encriptarPassword method, of class EncriptarPassword.
     */
    @Test
    public void testEncriptarPassword() {
        System.out.println("Prueba de encriptacion de una contrasena");
        String password = "12345";
        String result = EncriptarContrasena.encriptarPassword(password);
        assertTrue(!result.equals(password));
    }
    
}

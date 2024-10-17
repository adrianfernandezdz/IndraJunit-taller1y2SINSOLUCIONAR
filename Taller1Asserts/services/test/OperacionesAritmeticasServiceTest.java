package Taller1.Taller1Asserts.services.test;

import Taller1.Taller1Asserts.services.OperacionesAritmeticasService;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperacionesAritmeticasServiceTest {

    private final OperacionesAritmeticasService servicio = new OperacionesAritmeticasService();

    // Test para assertEquals
    @Test
    public void testSumar() {
        assertEquals(5, servicio.sumar(2, 3));
    }

    // Test para assertNotEquals
    @Test
    public void testSonDiferentes() {
        assertNotEquals(5, servicio.sumar(2, 2));
    }

    // Test para assertTrue
    @Test
    public void testEsPar() {
        assertTrue(servicio.sonDiferentes(3, 2));
    }

    // Test para assertFalse
    @Test
    public void testNoEsPar() {
        assertFalse(servicio.esPar(5));
    }

    // Test para assertNull
    @Test
    public void testObtenerArrayNulo() {
        int[] array = servicio.obtenerArrayNulo();
        assertNull(array);
    }

    // Test para assertNotNull
    @Test
    public void testObtenerArrayNoNulo() {
        int[] array = servicio.obtenerArrayNoNulo();
        assertNotNull(array);
    }

    // Test para assertArrayEquals
    @Test
    public void testArray() {
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, servicio.obtenerArrayNoNulo());
    }

    // Test para assertThrows
    @Test
    public void testDividirPorCero() {
        assertThrows(ArithmeticException.class, () -> servicio.dividir(10, 0));
    }

    // Test para assertDoesNotThrow
    @Test
    public void testDividirSinExcepcion() {
        assertDoesNotThrow(() -> servicio.dividir(10, 2));
    }

    // Test para assertAll
    @Test
    public void testVariasAserciones() {
        assertAll("Operaciones aritméticas",
                () -> assertEquals(4, servicio.sumar(2, 2)),
                () -> assertTrue(servicio.esPar(4)),
                () -> assertFalse(servicio.esPar(3))
        );
    }

    // Test para assertTimeoutPreemptively
    @Test
    public void testTimeout() {
        assertTimeoutPreemptively(ofMillis(100), () -> servicio.sumar(2, 3));
    }
}

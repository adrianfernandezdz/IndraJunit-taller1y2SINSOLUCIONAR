package Taller1.Taller1Asserts.services.test;

import Taller1.Taller1Asserts.services.EjemploService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EjemploTestService {

    private final EjemploService stringService = new EjemploService();

    @Test
    void testConcatenate() {
        String result = stringService.concatenate("Hello", "World");
        assertEquals("HelloWorld", result, "Concatenation of 'Hello' and 'World' should be 'HelloWorld'");
    }

    @Test
    void testGetLength() {
        int length = stringService.getLength("OpenAI");
        assertEquals(6, length, "Length of 'OpenAI' should be 6");

        length = stringService.getLength("");
        assertEquals(0, length, "Length of an empty string should be 0");
    }

    @Test
    void testToUpperCase() {
        String result = stringService.toUpperCase("openai");
        assertEquals("OPENAI", result, "'openai' should be converted to 'OPENAI'");

        result = stringService.toUpperCase("Java");
        assertEquals("JAVA", result, "'Java' should be converted to 'JAVA'");

        // Prueba de excepción para entrada nula
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            stringService.toUpperCase(null);
        });
        assertEquals("Input string cannot be null", exception.getMessage());
    }

    @Test
    void testContains() {
        assertTrue(stringService.contains("HelloWorld", "World"), "'HelloWorld' should contain 'World'");
        assertFalse(stringService.contains("HelloWorld", "Java"), "'HelloWorld' should not contain 'Java'");
        assertNotNull(stringService.contains("HelloWorld", "World"));
    }
}

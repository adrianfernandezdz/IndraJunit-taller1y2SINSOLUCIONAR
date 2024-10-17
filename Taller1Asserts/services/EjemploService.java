package Taller1.Taller1Asserts.services;

public class EjemploService {
    // Método para concatenar dos cadenas
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    // Método para obtener la longitud de una cadena
    public int getLength(String str) {
        return str.length();
    }

    // Método para convertir una cadena a mayúsculas
    public String toUpperCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }
        return str.toUpperCase();
    }

    // Método para verificar si una cadena contiene otra cadena
    public boolean contains(String str, String search) {
        return str.contains(search);
    }
}

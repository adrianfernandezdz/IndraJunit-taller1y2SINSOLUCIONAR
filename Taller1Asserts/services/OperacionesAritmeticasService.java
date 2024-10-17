package Taller1.Taller1Asserts.services;

public class OperacionesAritmeticasService {
    // Suma dos números
    public int sumar(int a, int b) {
        return a + b;
    }

    // Verifica si dos números son diferentes
    public boolean sonDiferentes(int a, int b) {
        return a != b;
    }

    // Verifica si un número es par
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Divide dos números
    public int dividir(int a, int b) {
        return a / b;
    }

    // Retorna un array nulo
    public int[] obtenerArrayNulo() {
        return null;
    }

    // Retorna un array no nulo
    public int[] obtenerArrayNoNulo() {
        return new int[]{1, 2, 3, 4, 5};
    }
}

package Calc;
public class Calculadora {
    public static void main(String[] args) {
        ProgramaCalculadora.menuPrincipal();
    }

    public static double somar(double a, double b) {
        return a + b;
    }

    public static double subtrair(double a, double b) {
        return a - b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        return a / b;
    }

    public static double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public static double raizQuadrada(double a) {
        return Math.sqrt(a);
    }
}

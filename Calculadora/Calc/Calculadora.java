package Calc;
public class Calculadora {
    public static void main(String[] args) {
        ProgramaCalculadora.menuPrincipal();
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public double subtrair(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }

    public double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public double raizQuadrada(double a) {
        return Math.sqrt(a);
    }
}

package Calc;
import java.util.Scanner;

public class ProgramaCalculadora {
    static Scanner scanner = new Scanner(System.in);

    static double valor1;
    static double valor2;
    static double resultado;

    public static void menuPrincipal() {
        int opcao;
        String menu = "Programa Calculadora\n\n"
                + "1-Somar\n"
                + "2-Subtrair\n"
                + "3-Multiplicar\n"
                + "4-Dividir\n"
                + "5-Potência\n"
                + "6-Raiz Quadrada\n"
                + "7-Finalizar\n\n";
        
        opcao = (int) lerValor(menu);

        switch (opcao) {
            case 1: //somar
                valor1 = lerValor("Informe o valor 1:");
                valor2 = lerValor("Informe o valor 2:");
                resultado = Calculadora.somar(valor1, valor2);
                mostrarResultado("Soma");
                break;

            case 2: //subtrair
                valor1 = lerValor("Informe o valor 1:");
                valor2 = lerValor("Informe o valor 2:");
                resultado = Calculadora.subtrair(valor1, valor2);
                mostrarResultado("Subtração");
                break;

            case 3: //multiplicar
                valor1 = lerValor("Informe o valor 1:");
                valor2 = lerValor("Informe o valor 2:");
                resultado = Calculadora.multiplicar(valor1, valor2);
                mostrarResultado("Multiplicação");
                break;

            case 4: //dividir
                valor1 = lerValor("Informe o valor 1:");
                valor2 = lerValor("Informe o valor 2:");
                resultado = Calculadora.dividir(valor1, valor2);
                mostrarResultado("Divisão");
                break;

            case 5: //potência
                valor1 = lerValor("Informe o valor 1:");
                valor2 = lerValor("Informe o valor 2:");
                resultado = Calculadora.potencia(valor1, valor2);
                mostrarResultado("Potência");
                break;

            case 6: //raiz quadrada
                valor1 = lerValor("Informe o valor 1:");
                resultado = Calculadora.raizQuadrada(valor1);
                mostrarResultado("Raiz quadrada");
                break;

            default:
                System.out.println("Adios");
                break;    
        }
    }

    public static double lerValor(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextDouble();
    }

    public static void mostrarResultado(String operacao) {
        System.out.println("O resultado da: " + operacao + " é " + resultado);
    }
}

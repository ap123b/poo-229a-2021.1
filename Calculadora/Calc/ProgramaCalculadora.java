package Calc;
import java.util.Scanner;

public class ProgramaCalculadora {
    static Scanner scanner = new Scanner(System.in);
    static double valor1;
    static double valor2;
    static double resultado;

    public static void menuPrincipal() {
        int opcao;
        boolean rodar = true;
        Calculadora Calc = new Calculadora();
        String menu = "Programa Calculadora\n\n"
                + "1-Somar\n"
                + "2-Subtrair\n"
                + "3-Multiplicar\n"
                + "4-Dividir\n"
                + "5-Potência\n"
                + "6-Raiz Quadrada\n"
                + "7-Finalizar\n\n"
                + ":: ";
        
        while(rodar) {
            System.out.print("\033[H\033[2J");
            opcao = (int) lerValor(menu);

            switch (opcao) {
                case 1: //somar
                    valor1 = lerValor("Informe o valor 1: ");
                    valor2 = lerValor("Informe o valor 2: ");
                    resultado = Calc.somar(valor1, valor2);
                    mostrarResultado("soma");
                    break;

                case 2: //subtrair
                    valor1 = lerValor("Informe o valor 1: ");
                    valor2 = lerValor("Informe o valor 2: ");
                    resultado = Calc.subtrair(valor1, valor2);
                    mostrarResultado("subtração");
                    break;

                case 3: //multiplicar
                    valor1 = lerValor("Informe o valor 1: ");
                    valor2 = lerValor("Informe o valor 2: ");
                    resultado = Calc.multiplicar(valor1, valor2);
                    mostrarResultado("multiplicação");
                    break;

                case 4: //dividir
                    valor1 = lerValor("Informe o valor 1: ");
                    valor2 = lerValor("Informe o valor 2: ");
                    resultado = Calc.dividir(valor1, valor2);
                    mostrarResultado("divisão");
                    break;

                case 5: //potência
                    valor1 = lerValor("Informe o valor 1: ");
                    valor2 = lerValor("Informe o valor 2: ");
                    resultado = Calc.potencia(valor1, valor2);
                    mostrarResultado("potência");
                    break;

                case 6: //raiz quadrada
                    valor1 = lerValor("Informe o valor 1: ");
                    resultado = Calc.raizQuadrada(valor1);
                    mostrarResultado("raiz quadrada");
                    break;

                default:
                    System.out.println("Adios");
                    rodar = false;
                    break;    
            }
        }
    }

    public static double lerValor(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }

    public static void mostrarResultado(String operacao) {
        System.out.println("\n\nO resultado da " + operacao + " é " + resultado);
        System.out.println("Aperte enter para prosseguir");
        scanner.nextLine();
        scanner.nextLine();
    }
}

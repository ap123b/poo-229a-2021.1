import java.util.Scanner;

public class ProgramaCalculadora {
    private static Scanner scan = new Scanner(System.in);
    private static double valor1;
    private static double valor2;
    private static double resultado;

    public static void MenuPrincipal() {
        Calculadora calc = new Calculadora();
        boolean rodar = true;
        int opcao;

        while(rodar) {
            System.out.print("\033[H\033[2J");
            String menu = "Programa Calculadora\n\n"
            + "1-Somar\n"
            + "2-Subtrair\n"
            + "3-Multiplicar\n"
            + "4-Dividir\n"
            + "5-Potência\n"
            + "6-Raiz Quadrada\n"
            + "7-Finalizar\n\n";

            opcao = (int) lerValor(menu);

            switch(opcao) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Soma");
                    valor1 = lerValor("Insira o valor de A: ");
                    valor2 = lerValor("Insira o valor de B: ");
                    resultado = calc.somar(valor1, valor2);
                    mostrarResultado("soma");
                    break;

                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Subtração");
                    valor1 = lerValor("Insira o valor de A: ");
                    valor2 = lerValor("Insira o valor de B: ");
                    resultado = calc.subtrair(valor1, valor2);
                    mostrarResultado("subtração");
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Multiplicação");
                    valor1 = lerValor("Insira o valor de A: ");
                    valor2 = lerValor("Insira o valor de B: ");
                    resultado = calc.multiplicar(valor1, valor2);
                    mostrarResultado("multiplicação");
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Divisão");
                    valor1 = lerValor("Insira o valor de A: ");
                    valor2 = lerValor("Insira o valor de B: ");
                    resultado = calc.dividir(valor1, valor2);
                    mostrarResultado("divisão");
                    break;

                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Potência");
                    valor1 = lerValor("Insira o valor de A: ");
                    valor2 = lerValor("Insira o valor de B: ");
                    resultado = calc.potencia(valor1, valor2);
                    mostrarResultado("potência");
                    break;

                case 6:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Raiz quadrada");
                    valor1 = lerValor("Insira o valor de A: ");
                    resultado = calc.raizQuadrada(valor1);
                    mostrarResultado("raiz quadrada");
                    break;

                case 7:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Obrigado por usar o programa");
                    rodar = false;
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Valor inválido!");
                    System.out.println("Aperte enter para continuar");
                    scan.nextLine();
                    scan.nextLine();
                    break;
            }
        }
    }

    private static double lerValor(String mensagem) {
        System.out.println(mensagem);
        return scan.nextDouble();
    }

    private static void mostrarResultado(String operacao) {
        System.out.println("O resultado da " + operacao + " é: " + resultado);
        System.out.println("Aperte enter para continuar");
        scan.nextLine();
        scan.nextLine();
    }
}

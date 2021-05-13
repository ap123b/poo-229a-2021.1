// 2.
class Conta {
    int numero;
    String titular;
    double saldo;
    double limite;
}

// 3.
class Programa {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        minhaConta.numero = 10;
        minhaConta.titular = "Shynji Miyasato";
        minhaConta.saldo = 1000;
        minhaConta.limite = 10000;

        System.out.println("Número da conta: " + minhaConta.numero);
        System.out.println("Titular da conta: " + minhaConta.titular);
        System.out.println("Saldo da conta: " + minhaConta.saldo);
        System.out.println("Limite da conta: " + minhaConta.limite);
    }
}

// 4.
class Conta {
    int numero;
    String titular;
    double saldo;
    double limite;

    boolean sacar(double valor) {
        if(valor > this.saldo || valor <= 0){
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    boolean depositar(double valor) {
        if(valor <= 0) {
            return false;
        } else {
            this.saldo += valor;
            return true;
        }
    }

    boolean transferir(Conta destinatario, double valor) {
        if(valor > this.saldo || valor <= 0) {
            return false;
        } else {
            this.sacar(valor);
            destinatario.depositar(valor);
            return true;
        }
    }
}

// 5.
class Teste {
    public static void main(String[] args) {
        Conta minhaConta1 = new Conta();
        Conta minhaConta2 = new Conta();

        minhaConta1.numero = 1;
        minhaConta1.titular = "Shynji Miyasato";
        minhaConta1.saldo = 1000;
        minhaConta1.limite = 10000;
        System.out.println("Conta 1:");
        System.out.println("Número da conta: " + minhaConta1.numero);
        System.out.println("Titular da conta: " + minhaConta1.titular);
        System.out.println("Saldo da conta: " + minhaConta1.saldo);
        System.out.println("Limite da conta: " + minhaConta1.limite + "\n");

        minhaConta2.numero = 2;
        minhaConta2.titular = "Luciano Stuart";
        minhaConta2.saldo = 1500;
        minhaConta2.limite = 10000;
        System.out.println("Conta 2:");
        System.out.println("Número da conta: " + minhaConta2.numero);
        System.out.println("Titular da conta: " + minhaConta2.titular);
        System.out.println("Saldo da conta: " + minhaConta2.saldo);
        System.out.println("Limite da conta: " + minhaConta2.limite + "\n");

        System.out.println("Teste saque: ");
        boolean status1 = minhaConta1.sacar(500);
        boolean status2 = minhaConta2.sacar(2000);

        System.out.println("Status saque conta 1: " + status1);
        System.out.println("Saldo conta 1 após saque: " + minhaConta1.saldo + "\n");

        System.out.println("Status saque conta 2: " + status2);
        System.out.println("Saldo conta 2 após saque: " + minhaConta2.saldo + "\n");

        System.out.println("Teste depósito: ");
        boolean status3 = minhaConta1.depositar(2000);
        boolean status4 = minhaConta2.depositar(1000);

        System.out.println("Status depósito conta 1: " + status3);
        System.out.println("Saldo conta 1 após depósito: " + minhaConta1.saldo + "\n");

        System.out.println("Status depósito conta 2: " + status4);
        System.out.println("Saldo conta 2 após depósito: " + minhaConta2.saldo + "\n");

        System.out.println("Teste transferência: ");
        boolean status5 = minhaConta1.transferir(minhaConta2, 500);
        System.out.println("Status transferência conta 1: " + status5);
        System.out.println("Saldo conta 1 após transferência: " + minhaConta1.saldo );
        System.out.println("Saldo conta 2 após transferência: " + minhaConta2.saldo + "\n");

        boolean status6 = minhaConta2.transferir(minhaConta2, 500);
        System.out.println("Status transferência conta 2: " + status6);
        System.out.println("Saldo conta 1 após transferência: " + minhaConta1.saldo );
        System.out.println("Saldo conta 2 após transferência: " + minhaConta2.saldo + "\n");
    }
}

// 6.
/* Devemos modificar a visibilidade dos atributos para 'private', impedindo que, assim,
Outras classes possam ver e alterar os atributos.

Aplicação: */
class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private double limite;

    boolean sacar(double valor) {
        if(valor > this.saldo || valor <= 0){
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    boolean depositar(double valor) {
        if(valor <= 0) {
            return false;
        } else {
            this.saldo += valor;
            return true;
        }
    }

    boolean transferir(Conta destinatario, double valor) {
        if(valor > this.saldo || valor <= 0) {
            return false;
        } else {
            this.sacar(valor);
            destinatario.depositar(valor);
            return true;
        }
    }
}

// 7.
/* Não é possível mais fazer alterações diretas assim por conta que os atributos
foram passados para private. */

// 8. 
class Funcionario {
    String nome;
    String departamento;
    double salario;
    String dataEntrada;
    String RG;
}

// 9.
class Funcionario {
    protected String nome;
    protected String departamento;
    protected double salario;
    protected String dataEntrada;
    protected String RG;
}

class Gerente extends Funcionario {
    int numeroFuncionarios;
    private int senha;
}

// 10.
class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.nome = "Gerson";
        funcionario1.departamento = "TI";
        funcionario1.salario = 1000;
        funcionario1.dataEntrada = "12/07/2005";
        funcionario1.RG = "12312312312";

        System.out.println("Nome do funcionário: " + funcionario1.nome);
        System.out.println("Departamento do funcionário: " + funcionario1.departamento);
        System.out.println("Salário do funcionário: " + funcionario1.salario);
        System.out.println("Data de Entrada do funcionário: " + funcionario1.dataEntrada);
        System.out.println("RG do funcionário: " + funcionario1.RG);
    }
}

class TesteGerente {
    public static void main(String[] args) {
        Gerente gerente1 = new Gerente();
        gerente1.nome = "Gerson";
        gerente1.departamento = "TI";
        gerente1.salario = 1000;
        gerente1.dataEntrada = "12/07/2005";
        gerente1.RG = "12312312312";
        gerente1.numeroFuncionarios = 10;
        gerente1.senha = 123;

        System.out.println("Nome do gerente: " + gerente1.nome);
        System.out.println("Departamento do gerente: " + gerente1.departamento);
        System.out.println("Salário do gerente: " + gerente1.salario);
        System.out.println("Data de Entrada do gerente: " + gerente1.dataEntrada);
        System.out.println("RG do gerente: " + gerente1.RG);
        System.out.println("Senhad o gerente: " + gerente1.senha);
        System.out.println("Número de funcionários gerenciados: " + gerente1.numeroFuncionarios);
    }
}
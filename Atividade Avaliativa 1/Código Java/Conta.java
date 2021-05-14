public class Conta {
    // Atributos
    private int numero;
    private String titular;
    private double saldo;
    private double limite;

    // Getters
    public int getNumero() {
        return this.numero;
    }
    public String getTitular() {
        return this.titular;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public double getLimite() {
        return this.limite;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }

    // Sacar
    public boolean sacar(double valor) {
        if(valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }

        else {
            return false;
        }
    }

    // Depositar
    public boolean depositar(double valor) {
        if(valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return true;
        }

        else {
            return false;
        }
    }

    // Transferir
    public boolean transferir(Conta destinatario, double valor) {
        if(this.sacar(valor)) {
            destinatario.depositar(valor);
            return true;
        }

        else {
            return true;
        }
    }
}

public class TesteContas {
    public static void main(String[] args) {
        // Criando objetos
        Conta minhaConta1 = new Conta();
        Conta minhaConta2 = new Conta();

        minhaConta1.setNumero(1);
        minhaConta1.setTitular("Shynji Miyasato");
        minhaConta1.setSaldo(1000);
        minhaConta1.setLimite(10000);
        System.out.println("Conta 1:");
        System.out.println("Número: "+ minhaConta1.getNumero());
        System.out.println("Titular: "+ minhaConta1.getTitular());
        System.out.println("Saldo: "+ minhaConta1.getSaldo());
        System.out.println("Limite: "+ minhaConta1.getLimite()+"\n");

        minhaConta2.setNumero(2);
        minhaConta2.setTitular("Luciano Stuart");
        minhaConta2.setSaldo(1500);
        minhaConta2.setLimite(10000);
        System.out.println("Conta 2:");
        System.out.println("Número: "+ minhaConta2.getNumero());
        System.out.println("Titular: "+ minhaConta2.getTitular());
        System.out.println("Saldo: "+ minhaConta2.getSaldo());
        System.out.println("Limite: "+ minhaConta2.getLimite()+"\n");

        // Testar saque
        System.out.println("Teste saque: ");
        boolean status1 = minhaConta1.sacar(500);
        boolean status2 = minhaConta2.sacar(2000);
        
        System.out.println("Saque conta 1 (R$ 500): "+ status1);
        System.out.println("Saldo: "+ minhaConta1.getSaldo());
        System.out.println("Saque conta 2 (R$ 2000): "+ status2);
        System.out.println("Saldo: "+ minhaConta2.getSaldo());
        System.out.print("\n");

        // Testar depósito
        System.out.println("Teste depósito: ");
        status1 = minhaConta1.depositar(2000);
        status2 = minhaConta2.depositar(1000);

        System.out.println("Depósito conta 1 (R$ 2000): "+ status1);
        System.out.println("Saldo: "+ minhaConta1.getSaldo());
        System.out.println("Depósito conta 2 (R$ 1000): "+ status2);
        System.out.println("Saldo: "+ minhaConta2.getSaldo());
        System.out.print("\n");
        
        // Testar transferência
        System.out.println("Teste transferência: ");
        status1 = minhaConta1.transferir(minhaConta2, 2000);
        System.out.println("Transferência conta 1 (R$ 2000): "+ status1);
        System.out.println("Saldo Conta 1: "+ minhaConta1.getSaldo());
        System.out.println("Saldo Conta 2: " + minhaConta2.getSaldo() + "\n");

        status2 = minhaConta2.transferir(minhaConta1, 1000);
        System.out.println("Transferência conta 2 (R$ 1000): "+ status1);
        System.out.println("Saldo Conta 1: "+ minhaConta1.getSaldo());
        System.out.println("Saldo Conta 2: " + minhaConta2.getSaldo() + "\n");
    }
}

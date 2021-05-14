public class TesteGerente {
    public static void main(String[] args) {
        Gerente g = new Gerente();
        g.setRG("12345678910");
        g.setNome("Luciano Stuart");
        g.setDepartamento("TI");
        g.setSalario(69420);
        g.setDataEntrada("20/11/2015");
        g.setSenha(123456);
        g.numeroGerencia = 10;

        System.out.println("RG: " + g.getRG());
        System.out.println("Nome: " + g.getNome());
        System.out.println("Departamento: " + g.getDepartamento());
        System.out.println("Salário: " + g.getSalario());
        System.out.println("Data Entrada: " + g.getDataEntrada());
        System.out.println("Senha: " + g.getSalario());
        System.out.println("Gerencia: " + g.numeroGerencia);
    }
}

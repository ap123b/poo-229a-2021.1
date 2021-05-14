public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f = new Funcionario();
        f.setRG("12345678910");
        f.setNome("Luciano Stuart");
        f.setDepartamento("TI");
        f.setSalario(69420);
        f.setDataEntrada("20/11/2015");

        System.out.println("RG: " + f.getRG());
        System.out.println("Nome: " + f.getNome());
        System.out.println("Departamento: " + f.getDepartamento());
        System.out.println("Salário: " + f.getSalario());
        System.out.println("Data Entrada: " + f.getDataEntrada());
    }
}

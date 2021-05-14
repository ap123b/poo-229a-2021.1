public class Funcionario {
    // Atributos
    protected String rg;
    protected String nome;
    protected String departamento;
    protected double salario;
    protected String dataEntrada;

    // Getters
    public String getRG() {
        return this.rg;
    }
    public String getNome() {
        return this.nome;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    public double getSalario() {
        return this.salario;
    }
    public String getDataEntrada() {
        return this.dataEntrada;
    }

    // Setters
    public void setRG(String rg) {
        this.rg = rg;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}

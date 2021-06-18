// Jogador

public class Jogador {
    // Atributos
    private String  nome;
    private Integer pontos;


    // Getters
    public String getNome()
    {
        return this.nome;
    }
    public Integer getPontos()
    {
        return this.pontos;
    }


    // Setters
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setPontos(Integer pontos)
    {
        this.pontos = pontos;
    }


    // Outros métodos
    public void cadastrarJogador(String valor)
    {
        this.nome = valor;
        this.pontos = 0;
    }
}

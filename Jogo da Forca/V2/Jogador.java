// Pacote
package V2;

public class Jogador {
    // Atributos
    private String  nome;
    private Integer pontos;

    // Getters
    public String getNome() { return this.nome; }
    public Integer getPontos() { return this.pontos; }

    // Setters
    public void setNome(String e) { this.nome = e; }
    public void setPontos(Integer e) { this.pontos = e; }

    // Cadastrar jogador
    public void cadastrarJogador(String e) { this.nome = e; this.pontos = 0; }
}

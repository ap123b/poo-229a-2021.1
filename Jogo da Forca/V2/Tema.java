// Pacote
package V2;

// Bibliotecas
import java.util.ArrayList;

public class Tema 
{
    // Atributos
    private ArrayList<String> BancoDePalavras;
    private String            nome;

    // Getters
    public ArrayList<String> getBancoDePalavras() { return this.BancoDePalavras; }
    public String getNome() { return this.nome; }

    // Setters
    public void setBancoDePalavras(ArrayList<String> e) { this.BancoDePalavras = e; }
    public void setNome(String e) { this.nome = e; }

    // Cadastrar palavra
    public boolean cadastrarPalavra(String toAdd)
    {
        // Verificando se a palavra já existe
        for(String s : this.getBancoDePalavras())
        {
            if(s.toLowerCase().equals(toAdd.toLowerCase()))
            {
                return false;
            }
        }

        // Caso não exista, adiciona e retorna verdadeiro
        ArrayList<String> newBanco = this.getBancoDePalavras();
        newBanco.add(toAdd);

        this.setBancoDePalavras(newBanco);

        return true;
    }

    public boolean removerPalavra(String toRemove)
    {
        // Verificando se a palavra existe
        for(String s : this.getBancoDePalavras())
        {
            if(s.toLowerCase().equals(toRemove.toLowerCase()))
            {
                ArrayList<String> newBanco = this.getBancoDePalavras();

                int index = newBanco.indexOf(s);
                newBanco.remove(index);

                this.setBancoDePalavras(newBanco);

                return true;
            }
        }

        // Caso não exista, retorna falso
        return false;
    }
}
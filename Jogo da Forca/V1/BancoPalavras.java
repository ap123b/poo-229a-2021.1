package V1;

// Banco de palavras
import java.util.ArrayList;

public class BancoPalavras
{
    // Atributos
    private ArrayList<String> palavraOuFrase;


    // Getters
    public ArrayList<String> getPalavraOuFrase()
    {
        return this.palavraOuFrase;
    }


    //  Setter
    public void setPalavraOuFrase(ArrayList<String> palavraOuFrase)
    {
        this.palavraOuFrase = palavraOuFrase;
    }


    // Outros métodos
    public void cadastrarPalavraOuFrase(String palavraOuFrase)
    {
        this.palavraOuFrase.add(palavraOuFrase);
    }

    public void removerPalavraOuFrase(String palavraOuFrase)
    {
        for(String p : this.palavraOuFrase)
        {
            if(p.equals(palavraOuFrase))
            {
                this.palavraOuFrase.remove(this.palavraOuFrase.indexOf(p));
            }
        }
    }
}
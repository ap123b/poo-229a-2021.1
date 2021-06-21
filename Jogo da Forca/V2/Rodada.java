// Pacote
package V2;

// Bibliotecas
import java.util.ArrayList;
import java.util.Random;

public class Rodada 
{
    // Atributos
    private static ArrayList<Tema> temas;
    private static Integer         totalPontos;
    private static String          palavra;
    private static Tema            tema;

    // Constantes
    private static final Integer pontosPalavra = 100;
    private static final Integer pontosLetra   = 15;

    // Getters
    public ArrayList<Tema> getTemas() { return temas; }
    public Integer getTotalPontos() { return totalPontos; }
    public String getPalavra() { return palavra; }
    public Tema getTema() { return tema; }
    public Integer getPontosPalavra() { return pontosPalavra; }
    public Integer getPontosLetra() { return pontosLetra; }

    // Setters
    public void setTemas(ArrayList<Tema> e) { temas = e; }
    public void setTotalPontos(Integer e) { totalPontos = e; }
    public void setPalavra(String e) { palavra = e; }
    public void setTema(Tema e) { tema = e; }
    
    // Adicionar tema
    public boolean adicionarTema(Tema toAdd)
    {
        // Verificando se tema já existe
        for(Tema t : this.getTemas())
        {
            if(t.getNome().toLowerCase().equals(toAdd.getNome().toLowerCase()))
            {
                return false;
            }
        }

        // Caso não exista, adicione e retorne verdadeiro
        ArrayList<Tema> newTemas = this.getTemas();
        newTemas.add(toAdd);

        this.setTemas(newTemas);

        return true;
    }

    // Remover tema
    public boolean removerTema(Tema toRemove)
    {
        // Verificando se tema existe
        for(Tema t : this.getTemas())
        {
            if(t.getNome().toLowerCase().equals(toRemove.getNome().toLowerCase()))
            {
                ArrayList<Tema> newTemas = this.getTemas();
                
                int index = newTemas.indexOf(t);
                newTemas.remove(index);

                this.setTemas(newTemas);

                return true;
            }
        }

        // Caso não exista, retorne falso
        return false;
    }

    // Escolher tema
    public void escolherTema()
    {
        Random gerador = new Random();
        Integer index = gerador.nextInt(this.getTemas().size());

        this.setTema(this.getTemas().get(index));
    }

    // Escolher palavra
    public boolean escolherPalavra()
    {
        if(temas.size() > 0)
        {
            // Escolhendo tema
            this.escolherTema();

            Random gerador = new Random();
            Integer index = gerador.nextInt(this.getTema().getBancoDePalavras().size());

            this.setPalavra(this.getTema().getBancoDePalavras().get(index)); 
            return true;  
        }

        return false;
    }
}

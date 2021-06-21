package V1;

// Rodada
import java.util.ArrayList;
import java.util.Random;

public class Rodada {
    // Atributos
    private static ArrayList<Tema> temas;
    private static Integer         totalPontos;
    private static String          palavraOuFrase;
    private static Tema            tema;

    // Constantes
    private static final Integer pontosPalavraCerta = 100;
    private static final Integer pontosLetra        = 15;


    // Getters
    public ArrayList<Tema> getTemas()
    {
        return temas;
    }

    public Tema getTemaEscolhido()
    {
        return tema;
    }

    public String getPalavraOuFrase()
    {
         return palavraOuFrase;
    }

    public Integer getTotalPontos()
    {
        return totalPontos;
    }

    public Integer getPontosPalavra()
    {
        return pontosPalavraCerta;
    }

    public Integer getPontosLetra()
    {
        return pontosLetra;
    }


    // Setters
    public void setTemas(ArrayList<Tema> temaLista)
    {
        temas = temaLista;
    }

    public void setTema(Tema temaEscolhido)
    {
        tema = temaEscolhido;
    }

    public void setPalavraOuFrase(String palavraOuFraseEscolhido)
    {
        palavraOuFrase = palavraOuFraseEscolhido;
    }

    public void setTotalPontos(Integer pontos)
    {
        totalPontos = pontos;
    }


    // Outros métodos
    public void escolherTema()
    {
        Random gerador = new Random();
        Integer index = gerador.nextInt(temas.size());

        this.setTema(temas.get(index));
    }

    public void escolherPalavra()
    {
        if(temas.size() > 0)
        {
            this.escolherTema();

            Random gerador = new Random();
            Integer index = gerador.nextInt(tema.getPalavraOuFrase().size());

            this.setPalavraOuFrase(tema.getPalavraOuFrase().get(index));   
        }
    }
}

// Controle das rodadas
import java.util.ArrayList;

public class ControleRodada {
    // Atributos
    private static Rodada                rodada;
    private static ArrayList<Character>  letrasCertas;
    private static ArrayList<Character>  letrasErradas;
    private static Integer               errosCometidos;

    // Constantes
    private static final Integer maxErros = 5;

    
    // Getters
    public Rodada getRodada()
    {
        return rodada;
    }

    public ArrayList<Character> getLetrasCertas()
    {
        return letrasCertas;
    }

    public ArrayList<Character> getLetrasErradas()
    {
        return letrasErradas;
    }

    public Integer getErrosCometidos()
    {
        return errosCometidos;
    }

    public Integer getMaxErros()
    {
        return maxErros;
    }


    // Setters
    public void setRodada(Rodada e)
    {
        rodada = e;
    }

    public void setLetrasCertas(ArrayList<Character> letras)
    {
        letrasCertas = letras;
    }

    public void setLetrasErradas(ArrayList<Character> letras)
    {
        letrasErradas = letras;
    }

    public void setErrosCometidos(Integer erros)
    {
        errosCometidos = erros;
    }


    // Outros métodos
    public boolean verificarLetra(Character letra)
    {
        String  palavraOuFrase = rodada.getPalavraOuFrase();
        boolean found          = false;
        boolean alreadyIn      = false;

        for(Character c : letrasCertas)
        {
            if(Character.toLowerCase(c) == Character.toLowerCase(letra))
            {
                alreadyIn = true;
            }
        }


        for(Character c : palavraOuFrase.toCharArray())
        {
            if(Character.toLowerCase(c) == Character.toLowerCase(letra))
            {
                found = true;
                break;
            }
        }

        if(found && !alreadyIn)
        {
            letrasCertas.add(letra);
            return true;
        }

        else if(!found && !alreadyIn)
        {
            boolean jaErrou = false;

            for(Character c : letrasErradas)
            {
                if(Character.toLowerCase(c) == Character.toLowerCase(letra))
                {
                    jaErrou = true;
                    break;
                }
            }

            if(!jaErrou)
            {
                letrasErradas.add(letra);
                setErrosCometidos(getErrosCometidos() + 1);
            }
            return false;
        }

        else
        {
            return false;
        }
    }
}

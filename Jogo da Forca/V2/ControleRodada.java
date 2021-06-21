// Pacote
package V2;

// Bibliotecas
import java.util.ArrayList;

public class ControleRodada {
    // Atributos
    private static Rodada                rodada;
    private static ArrayList<Character>  letrasCertas;
    private static ArrayList<Character>  letrasErradas;
    private static Integer               errosCometidos;

    // Constantes
    private static final Integer maxErros = 6;

    // Getters
    public Rodada getRodada() { return rodada; }
    public ArrayList<Character> getLetrasCertas() { return letrasCertas; }
    public ArrayList<Character> getLetrasErradas() { return letrasErradas; }
    public Integer getErrosCometidos() { return errosCometidos; }
    public Integer getMaxErros() { return maxErros; }

    // Setters
    public void setRodada(Rodada e) { rodada = e; }
    public void setLetrasCertas(ArrayList<Character> e) { letrasCertas = e; }
    public void setLetrasErradas(ArrayList<Character> e) { letrasErradas = e; }
    public void setErrosCometidos(Integer e) { errosCometidos = e; }

    // Verificar letra
    public void verificarLetra(Character letra)
    {
        // Variáveis locais
        String palavra = this.getRodada().getPalavra();
        boolean found = false;
        boolean alreadyRight = false;
        boolean alreadyWrong = false;

        // Verificando se a letra já não foi inserida e está certa
        for(Character c : this.getLetrasCertas())
        {
            if(Character.toLowerCase(c) == Character.toLowerCase(letra))
            {
                alreadyRight = true;
            }
        }

        // Verificando se a letra já não foi inserida e está errada
        for(Character c : this.getLetrasErradas())
        {
            if(Character.toLowerCase(c) == Character.toLowerCase(letra))
            {
                alreadyWrong = true;
            }
        }

        // Se não foi inserida, então verificar se está certa ou errada
        if(!alreadyRight && !alreadyWrong)
        {
            for(Character c : palavra.toCharArray())
            {
                if(Character.toLowerCase(c) == Character.toLowerCase(letra))
                {
                    found = true;
                    break;
                }
            }

            // Se achar a letra, certo
            if(found)
            {
                ArrayList<Character> newLetrasCertas = this.getLetrasCertas();
                newLetrasCertas.add(letra);

                this.setLetrasCertas(newLetrasCertas);
                this.getRodada().setTotalPontos(this.getRodada().getTotalPontos() + this.getRodada().getPontosLetra());
            }

            // Caso contrário, errado
            else
            {
                ArrayList<Character> newLetrasErradas = this.getLetrasErradas();
                newLetrasErradas.add(letra);

                this.setLetrasErradas(newLetrasErradas);
                this.setErrosCometidos(this.getErrosCometidos() + 1);
            }
        }
    }
}

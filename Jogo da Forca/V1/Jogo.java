package V1;

// Onde a mágia acontece
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    // Scanner
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {   
        // Alocando Jogador, Rodada e Controle da Rodada na memória
        Jogador jogador;
        ControleRodada cR;

        // Inicializando Jogador, Rodada e Controle da Rodada
        jogador = cadastrarJogador();
        cR = cadastrarRodada();

        int choice = 0;

        while(choice != 3) {
            System.out.print("\033[H\033[2J");
            System.out.println("1- Jogar");
            System.out.println("2- Editar temas");
            System.out.println("3- Sair");
            System.out.print(":: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice)
            {
                case 1:
                    cR.getRodada().escolherPalavra();
                    cR.setLetrasCertas(new ArrayList<Character>());
                    cR.setErrosCometidos(0);
                    cR.setLetrasErradas(new ArrayList<Character>());
                    String palavra = cR.getRodada().getPalavraOuFrase();
                    String resposta = "";
        
                    while(cR.getErrosCometidos() <= cR.getMaxErros())
                    {
                        System.out.print("\033[H\033[2J");
                        System.out.println("Nome do jogador: " + jogador.getNome());
                        System.out.println("Total de pontos: " + jogador.getPontos());
                        System.out.println("Pontos da rodada: " + cR.getRodada().getTotalPontos());
                        System.out.println("Erros cometidos: " + cR.getErrosCometidos() + "/" + cR.getMaxErros());
        
                        ArrayList<Character> letrasCertas = cR.getLetrasCertas();
                        resposta = "";
        
                        for(char c : palavra.toCharArray())
                        {
                            boolean found = false;
        
                            for(Character ch : letrasCertas)
                            {
                                if(Character.toLowerCase(ch) == Character.toLowerCase(c))
                                {
                                    found = true;
                                    break;
                                }
                            }
        
                            if(found)
                            {
                                resposta += c;
                            }

                            else if(c == ' ')
                            {
                                resposta += " ";
                            }
        
                            else
                            {
                                resposta += "*";
                            }
                        }
        
                        if(resposta.equals(palavra))
                        {
                            jogador.setPontos(jogador.getPontos() + cR.getRodada().getPontosPalavra());
                            cR.getRodada().setTotalPontos(cR.getRodada().getTotalPontos() + cR.getRodada().getPontosPalavra());
                            break;
                        }
        
                        System.out.println("Tema: " + cR.getRodada().getTemaEscolhido().getNome());
                        System.out.println("Palavra: " + resposta);
                        System.out.print(":: ");
                        Character guess = scan.next().charAt(0);
        
                        if(cR.verificarLetra(guess))
                        {
                            jogador.setPontos(jogador.getPontos() + cR.getRodada().getPontosLetra());
                            cR.getRodada().setTotalPontos(cR.getRodada().getTotalPontos() + cR.getRodada().getPontosLetra());
                        }
                    }
                    System.out.print("\033[H\033[2J");
        
                    if(cR.getErrosCometidos() > cR.getMaxErros())
                    {
                        System.out.println("Game Over!");
                    }
        
                    else
                    {
                        System.out.println("Parabéns!");
                    }
        
                    System.out.println("Palavra: " + cR.getRodada().getPalavraOuFrase());
                    System.out.println("Total de pontos: " + jogador.getPontos());
                    System.out.println("Pontos da rodada: " + cR.getRodada().getTotalPontos());
                    cR.getRodada().setTotalPontos(0);

                    if(cR.getErrosCometidos() > cR.getMaxErros())
                    {
                        jogador.setPontos(0);
                    }

                    scan.nextLine();
                    scan.nextLine();
                    break;

                case 2:
                    cR = editarTemas(cR);
                    break;

                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Obrigado por jogar!");
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Valor inválido!");
                    scan.nextLine();
                    break;
            }
        }

        scan.close();
    }

    public static Jogador cadastrarJogador()
    {
        System.out.print("\033[H\033[2J");
        System.out.print("Informe seu nome: ");
        String nomeJugador = scan.nextLine();

        Jogador retorno = new Jogador();
        retorno.cadastrarJogador(nomeJugador);

        return retorno;
    }

    public static ControleRodada cadastrarRodada()
    {
        System.out.print("\033[H\033[2J");
        System.out.print("Informe o número de temas a serem inseridos: ");
        int numeroTemas = scan.nextInt();
        scan.nextLine();

        ArrayList<Tema> listaTemas = new ArrayList<Tema>();

        for(int i = 0; i < numeroTemas; i++)
        {
            ArrayList<String> listaPalavras = new ArrayList<String>();
            Tema              holder        = new Tema();
            String            palavra       = "";

            System.out.print("\033[H\033[2J");
            System.out.println("(" + (i+1) + "/" + numeroTemas + ")");
            System.out.print("Informe o nome do tema: ");
            String nome = scan.nextLine();

            while(!palavra.equals("q!"))
            {
                System.out.print("Informe uma palavra ou frase pro tema (q! = sair): ");
                palavra = scan.nextLine();

                if(!palavra.equals("q!"))
                {
                    listaPalavras.add(palavra);
                }
            }

            holder.setNome(nome);
            holder.setPalavraOuFrase(listaPalavras);

            listaTemas.add(holder);
        }

        Rodada rodada = new Rodada();
        rodada.setTemas(listaTemas);
        rodada.setTotalPontos(0);
        rodada.setTema(new Tema());

        ControleRodada retorno = new ControleRodada();
        retorno.setRodada(rodada);
        retorno.setLetrasCertas(new ArrayList<Character>());
        retorno.setLetrasErradas(new ArrayList<Character>());
        retorno.setErrosCometidos(0);

        return retorno;
    }

    public static ControleRodada editarTemas(ControleRodada cR)
    {
        ControleRodada retorno = new ControleRodada();

        System.out.print("\033[H\033[2J");
        System.out.println("Escolha o que quer editar");
        System.out.println("1- Adicionar tema");
        System.out.println("2- Remover tema");
        System.out.println("3- Voltar");
        System.out.print(":: ");
        int choice = scan.nextInt();
        scan.nextLine();

        String nome = "";

        switch(choice)
        {
            case 1:
                ArrayList<String> listaPalavras = new ArrayList<String>();
                Tema              holder        = new Tema();
                String            palavra       = "";

                System.out.print("\033[H\033[2J");
                System.out.print("Insira o nome do tema: ");
                nome = scan.nextLine();
                while(!palavra.equals("q!"))
                {
                    System.out.print("Informe uma palavra ou frase pro tema (q! = sair): ");
                    palavra = scan.nextLine();

                    if(!palavra.equals("q!"))
                    {
                        listaPalavras.add(palavra);
                    }
                }

                holder.setNome(nome);
                holder.setPalavraOuFrase(listaPalavras);

                cR.getRodada().getTemas().add(holder);
                retorno = cR;

                break;

            case 2:
                System.out.print("\033[H\033[2J");
                System.out.print("Insira o nome do tema: ");
                nome = scan.nextLine();
                int index = 0;

                for(Tema t : cR.getRodada().getTemas())
                {
                    String name = t.getNome().toString().toLowerCase();
                    if(name.equals(nome.toLowerCase()))
                    {
                        System.out.println("e");
                        index = cR.getRodada().getTemas().indexOf(t);
                    }
                }
                cR.getRodada().getTemas().remove(index);
                retorno = cR;

                break;

            default:
                retorno = cR;
                break;
        }

        return retorno;
    }
}

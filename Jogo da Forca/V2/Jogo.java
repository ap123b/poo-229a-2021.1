// Pacote
package V2;

// Bibliotecas
import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    // Scanner
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        boolean        rodar  = true;
        Jogador        plr    = criarJogador();
        ControleRodada cR     = criarControleRodada();
        int            rodada = 0;

        while(rodar)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Jogo da Forca");
            System.out.println("1- Jogar");
            System.out.println("2- Editar");
            System.out.println("3- Sair");
            System.out.print(":: ");
            rodada = scan.nextInt();
            scan.nextLine();

            switch(rodada)
            {
                case 1:
                    cR = jogar(cR, plr);

                    if(cR.getRodada().getTotalPontos() > 0)
                    {
                        plr.setPontos(cR.getRodada().getTotalPontos() + plr.getPontos());
                    }

                    else
                    {
                        plr.setPontos(0);
                    }
                    
                    break;

                case 2:
                    cR = menu(cR);
                    break;

                case 3:
                    rodar = false;
                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Valor inexistente...");
                    System.out.println("Aperte enter para continuar...");
                    scan.nextLine();
                    break;
            }
        }
    }

    public static String getPrintableString(String palavra, ArrayList<Character> letrasCertas)
    {
        String retorno = "";

        for(Character c : palavra.toCharArray())
        {
            boolean found = false;

            if(c != ' ')
            {
                for(Character ch : letrasCertas)
                {
                    if(Character.toLowerCase(ch) == Character.toLowerCase(c))
                    {
                        found = true;
                    }
                }

                if(found) { retorno += c; }
                else { retorno += '*'; }
            }

            else { retorno += ' '; }
        }

        return retorno;
    }

    public static void printarBonequinho(Integer numeroErros)
    {
        switch(numeroErros)
        {
            case 1:
                System.out.println(" O ");
                break;

            case 2:
                System.out.println(" O ");
                System.out.println(" | ");
                break;

            case 3:
                System.out.println(" O ");
                System.out.println("-| ");
                break;

            case 4:
                System.out.println(" O ");
                System.out.println("-|-");
                break;

            case 5:
                System.out.println(" O ");
                System.out.println("-|-");
                System.out.println("/");
                break;

            case 6:
                System.out.println(" O ");
                System.out.println("-|-");
                System.out.println("/ \\");
                break;

            default:
                System.out.println("");
                break;
        }
    }

    public static Jogador criarJogador()
    {
        Jogador retorno = new Jogador();

        System.out.print("\033[H\033[2J");
        System.out.print("Informe seu nome: ");
        String nome = scan.nextLine();

        retorno.cadastrarJogador(nome);

        return retorno;
    }

    public static Rodada criarRodada()
    {
        Rodada retorno = new Rodada();

        System.out.print("\033[H\033[2J");
        System.out.print("Quantos temas você deseja inserir: ");
        int n = scan.nextInt();
        scan.nextLine();

        ArrayList<Tema> listaTemas = new ArrayList<Tema>();

        for(int i = 0; i < n; i++)
        {
            Tema            holder        = new Tema();
            String          nome          = "";
            String          palavra       = "";
            ArrayList<String> listaPalavras = new ArrayList<String>();

            System.out.print("\033[H\033[2J");
            System.out.print("Informe o nome do tema: ");
            nome = scan.nextLine();

            while(!palavra.equals("q!"))
            {
                System.out.print("Insira uma palavra ou frase (q! = sair): ");
                palavra = scan.nextLine();

                if(!palavra.equals("q!"))
                {
                    listaPalavras.add(palavra);
                }
            }

            holder.setNome(nome);
            holder.setBancoDePalavras(listaPalavras);
            listaTemas.add(holder);
        }

        retorno.setTemas(listaTemas);

        return new Rodada();
    }

    public static ControleRodada criarControleRodada()
    {
        Rodada rodada = criarRodada();
        ControleRodada retorno = new ControleRodada();

        retorno.setRodada(rodada);
        retorno.setErrosCometidos(0);
        retorno.setLetrasCertas(new ArrayList<Character>());
        retorno.setLetrasErradas(new ArrayList<Character>());

        return retorno;
    }

    public static ControleRodada jogar(ControleRodada cR, Jogador plr)
    {
        if(cR.getRodada().escolherPalavra()) {
            cR.getRodada().setTotalPontos(0);
            while(cR.getErrosCometidos() <= cR.getMaxErros())
            {
                ArrayList<Character> letrasCertas = cR.getLetrasCertas();
                String palavra = cR.getRodada().getPalavra();
                String resposta = getPrintableString(palavra, letrasCertas);

                System.out.print("\033[H\033[2J");
                System.out.println("Jogador: " + plr.getNome());
                System.out.println("Pontos totais: " + (plr.getPontos() + cR.getRodada().getTotalPontos()));
                System.out.println("Pontos da rodada: " + cR.getRodada().getTotalPontos());
                System.out.println("Tema: " + cR.getRodada().getTema().getNome());
                System.out.println("Palavra: " + resposta);
                System.out.println("Boneco: ");
                printarBonequinho(cR.getErrosCometidos());

                if(resposta.equals(palavra))
                {
                    cR.getRodada().setTotalPontos(cR.getRodada().getTotalPontos() + cR.getRodada().getPontosPalavra());
                    break;
                }

                System.out.print("\n:: ");
                Character guess = scan.next().charAt(0);

                cR.verificarLetra(guess);
            }

            System.out.print("\033[H\033[2J");

            if(cR.getErrosCometidos() > cR.getMaxErros()) { System.out.println("Game over"); }
            else { System.out.println("Parabéns!"); }

            System.out.println("Palavra: " + cR.getRodada().getPalavra());
            System.out.println("Pontos da rodada: " + cR.getRodada().getTotalPontos());
            System.out.println("Total de pontos: " + (plr.getPontos() + cR.getRodada().getTotalPontos()));

            if(cR.getErrosCometidos() > cR.getMaxErros()) { cR.getRodada().setTotalPontos(0); }

            scan.nextLine();
            scan.nextLine();
            
            cR.setErrosCometidos(0);
            cR.setLetrasCertas(new ArrayList<Character>());
            cR.setLetrasErradas(new ArrayList<Character>());
        }

        else
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Impossível iniciar jogo.");
            scan.nextLine();
            scan.nextLine();
        }

        return cR;
    }

    public static ControleRodada menu(ControleRodada cR)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("1- Adicionar tema");
        System.out.println("2- Remover tema");
        System.out.println("3- Adicionar palavra");
        System.out.println("4- Remover palavra");
        System.out.println("5- Voltar");
        System.out.print(":: ");
        int choice = scan.nextInt();
        scan.nextLine();

        switch(choice)
        {
            case 1:
                cR = adicionarTema(cR);
                break;

            case 2:
                cR = removerTema(cR);
                break;

            case 3:
                cR = adicionarPalavra(cR);
                break;

            case 4:
                cR = removerPalavra(cR);
                break;

            default:
                break;
        }

        return cR;
    }

    public static ControleRodada adicionarTema(ControleRodada cR)
    {
        ArrayList<Tema>   listaTemas    = cR.getRodada().getTemas();
        Tema              holder        = new Tema();
        ArrayList<String> listaPalavras = new ArrayList<String>();
        String            palavra       = "";
        boolean           found         = false;

        System.out.print("\033[H\033[2J");
        System.out.print("Informe o nome do tema: ");
        String nome = scan.nextLine();

        for(Tema t : cR.getRodada().getTemas())
        {
            if(t.getNome().toLowerCase().equals(nome.toLowerCase()))
            {
                found = true;
                break;
            }
        }

        if(!found) {
            while(!palavra.equals("q!"))
            {
                System.out.print("Insira uma palavra ou frase (q! = sair): ");
                palavra = scan.nextLine();

                if(!palavra.equals("q!"))
                {
                    listaPalavras.add(palavra);
                }
            }

            holder.setNome(nome);
            holder.setBancoDePalavras(listaPalavras);

            listaTemas.add(holder);

            cR.getRodada().setTemas(listaTemas);
        }

        return cR;
    }

    public static ControleRodada removerTema(ControleRodada cR)
    {
        ArrayList<Tema> listaTemas = cR.getRodada().getTemas();

        System.out.print("\033[H\033[2J");
        System.out.print("Informe o nome do tema: ");
        String nome = scan.nextLine();

        for(Tema t : listaTemas)
        {
            if(t.getNome().toLowerCase().equals(nome.toLowerCase()))
            {
                int index = listaTemas.indexOf(t);
                listaTemas.remove(index);

                cR.getRodada().setTemas(listaTemas);
                break;
            }
        }

        return cR;
    }

    public static ControleRodada adicionarPalavra(ControleRodada cR)
    {
        ArrayList<Tema>   listaTemas = cR.getRodada().getTemas();
        ArrayList<String> listaPalavras;
        String            palavra    = "";

        System.out.print("\033[H\033[2J");
        for(Tema t : listaTemas)
        {
            System.out.print((listaTemas.indexOf(t) + 1) + "- ");
            System.out.println(t.getNome());
        }

        System.out.print("Insira o índice do tema que vai adicionar palavra:: ");
        int indice = scan.nextInt();
        scan.nextLine();

        if((indice-1) <= listaTemas.size())
        {
            Tema holder = listaTemas.get((indice-1));
            listaPalavras = holder.getBancoDePalavras();

            System.out.print("\033[H\033[2J");
            System.out.println("Tema: " + holder.getNome());
            while(!palavra.equals("q!"))
            {
                System.out.print("Insira uma palavra ou frase (q! = sair): ");
                palavra = scan.nextLine();

                if(!palavra.equals("q!"))
                {
                    listaPalavras.add(palavra);
                }
            }

            listaTemas.get((indice-1)).setBancoDePalavras(listaPalavras);
        }
        cR.getRodada().setTemas(listaTemas);

        return cR;
    }

    public static ControleRodada removerPalavra(ControleRodada cR)
    {
        ArrayList<Tema>   listaTemas = cR.getRodada().getTemas();
        ArrayList<String> listaPalavras;

        System.out.print("\033[H\033[2J");
        for(Tema t : listaTemas)
        {
            System.out.print((listaTemas.indexOf(t) + 1) + "- ");
            System.out.println(t.getNome());
        }

        System.out.print("Insira o índice do tema que vai adicionar palavra:: ");
        int indice = scan.nextInt();
        scan.nextLine();

        if((indice-1) <= listaTemas.size())
        {
            Tema holder = listaTemas.get((indice-1));
            listaPalavras = holder.getBancoDePalavras();

            System.out.print("\033[H\033[2J");
            System.out.println("Tema: " + holder.getNome());
            
            for(String s : listaPalavras)
            {
                System.out.print((listaPalavras.indexOf(s) + 1) + "- ");
                System.out.println(s);
            }

            System.out.print("Insira o índice do tema que vai adicionar palavra:: ");
            int indiceWrd = scan.nextInt();

            if((indice -1) <= listaPalavras.size())
            {
                listaPalavras.remove((indiceWrd-1));
            }

            listaTemas.get((indice-1)).setBancoDePalavras(listaPalavras);
        }
        cR.getRodada().setTemas(listaTemas);

        return cR;
    }
}

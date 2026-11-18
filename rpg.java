
import java.util.Scanner;

public class rpg {


    // Lê uma opção numérica e impede que o programa quebre
    // caso o jogador digite algo que não seja um número.
    public static int lerOpcao(Scanner entrada, String mensagem) {

        int opcao = -1;
        boolean valido = false;

        do {
            System.out.print(mensagem);

            String texto = entrada.nextLine();

            try {
                opcao = Integer.parseInt(texto);
                valido = true;
            } catch (NumberFormatException erro) {
                System.out.println("Digite apenas numeros!");
            }

        } while (!valido);

        return opcao;
    }

    // Pausa a história até o jogador apertar ENTER.
    public static void pausar(Scanner entrada) {

        System.out.println("\nPressione ENTER para continuar...");
        entrada.nextLine();
    }

    // Calcula o dano, impedindo que ele fique negativo.
    public static int calcularDano(int ataque, int defesa) {

        int dano = ataque - defesa;

        if (dano < 0) {
            dano = 0;
        }

        return dano;
    }

    // Sorteia um número entre o mínimo e o máximo.
    // Futuramente será usado para crítico e esquiva.
    public static int sortear(int min, int max) {

        return (int) (Math.random() * (max - min + 1)) + min;
    }



    // Verifica se o ataque foi crítico.
public static boolean verificarCritico(int[] personagem) {

    int resultado = sortear(1, 20);

    System.out.println("\nResultado do dado: " + resultado);

    if (resultado >= personagem[3] &&
        resultado <= personagem[4]) {

        System.out.println("ATAQUE CRITICO!");

        return true;

    } else {

        return false;
    }
}

    //escolha de classes

    public static void mostrarClasses() {

        System.out.println("             ESCOLHA SUA CLASSE");
     

        System.out.println("\n[1] MAGO");
        System.out.println("Vida: 50");
        System.out.println("Ataque: 50");
        System.out.println("Defesa: 0");
        System.out.println("Habilidade: Bola de Fogo");

        System.out.println("\n[2] LADINO");
        System.out.println("Vida: 50");
        System.out.println("Ataque: 35");
        System.out.println("Defesa: 5");
        System.out.println("Habilidade: Ataque Furtivo");

        System.out.println("\n[3] PALADINO");
        System.out.println("Vida: 100");
        System.out.println("Ataque: 20");
        System.out.println("Defesa: 20");
        System.out.println("Habilidade: Escudo Sagrado");

      
    }

    public static int escolherClasse(Scanner entrada) {

        int classe;

        do {
            mostrarClasses();

            classe = lerOpcao(entrada, "\nEscolha sua classe: ");

            if (classe < 1 || classe > 3) {
                System.out.println("\nOpcao invalida!");
            }

        } while (classe < 1 || classe > 3);

        return classe;
    }

    // O vetor guarda os atributos do personagem:
    // [0] Vida
    // [1] Ataque
    // [2] Defesa
    // [3] Critico minimo
    // [4] Critico maximo
    // [5] Esquiva minima
    // [6] Esquiva maxima

    public static void configurarPersonagem(int classe, int[] personagem) {

        if (classe == 1) {

            // MAGO
            personagem[0] = 50;
            personagem[1] = 50;
            personagem[2] = 0;
            personagem[3] = 15;
            personagem[4] = 20;
            personagem[5] = 17;
            personagem[6] = 20;

        } else if (classe == 2) {

            // LADINO
            personagem[0] = 50;
            personagem[1] = 35;
            personagem[2] = 5;
            personagem[3] = 10;
            personagem[4] = 20;
            personagem[5] = 10;
            personagem[6] = 20;

        } else {

            // PALADINO
            personagem[0] = 100;
            personagem[1] = 20;
            personagem[2] = 20;
            personagem[3] = 19;
            personagem[4] = 20;
            personagem[5] = 19;
            personagem[6] = 20;
        }
    }

    public static boolean confirmarClasse(
            Scanner entrada,
            String nomeClasse,
            int[] personagem) {

   
        System.out.println("          CONFIRME SEU PERSONAGEM");
  
        System.out.println("Classe: " + nomeClasse);
        System.out.println("Vida: " + personagem[0]);
        System.out.println("Ataque: " + personagem[1]);
        System.out.println("Defesa: " + personagem[2]);

        System.out.println("\n[1] Confirmar classe");
        System.out.println("[2] Escolher novamente");

        int opcao;

        do {
            opcao = lerOpcao(entrada, "\nEscolha: ");

            if (opcao != 1 && opcao != 2) {
                System.out.println("Opcao invalida!");
            }

        } while (opcao != 1 && opcao != 2);

        return opcao == 1;
    }

// inicio da historía

    public static void introducaoClasse(int classe, Scanner entrada) {

     
        System.out.println("             SUA JORNADA COMEÇA");
      

        System.out.println(
            "\nO reino ja nao conhece a luz do sol."
        );

        System.out.println(
            "Ha anos, uma maldicao cobre estas terras."
        );

        System.out.println(
            "Seu responsavel e Nosferatu, uma criatura que"
        );

        System.out.println(
            "habita um castelo isolado nas montanhas cinzentas."
        );

        System.out.println(
            "\nDiversas expedicoes foram enviadas para derrota-lo."
        );

        System.out.println(
            "Nenhum guerreiro retornou."
        );

        System.out.println(
            "\nAgora, resta apenas voce."
        );

        if (classe == 1) {

            System.out.println(
                "\nComo Mago, voce domina as artes arcanas."
            );

            System.out.println(
                "Sua magia pode causar danos devastadores."
            );

        } else if (classe == 2) {

            System.out.println(
                "\nComo Ladino, voce aprendeu a lutar nas sombras."
            );

            System.out.println(
                "Velocidade e precisao sao suas maiores armas."
            );

        } else {

            System.out.println(
                "\nComo Paladino, voce jurou proteger os inocentes."
            );

            System.out.println(
                "Sua resistencia e sua determinacao sao lendarias."
            );
        }

        System.out.println(
            "\nMas existe algo em voce que Nosferatu nao consegue controlar."
        );

        System.out.println(
            "Sua mente e imune a maldicao que domina o reino."
        );

        pausar(entrada);
    }


    

    public static void cenaCastelo(Scanner entrada) {

      
        System.out.println("              AS MONTANHAS");
      

        System.out.println(
            "\nDepois de uma longa jornada, voce finalmente"
        );

        System.out.println(
            "alcanca as montanhas que cercam o castelo."
        );

        System.out.println(
            "O vento sopra violentamente."
        );

        System.out.println(
            "A neve cobre o caminho e o silencio e assustador."
        );

        System.out.println(
            "\nAo longe, uma enorme fortaleza surge entre a nevoa."
        );

        System.out.println(
            "O lugar onde tudo comecou."
        );

        System.out.println(
            "\nO castelo de Nosferatu."
        );

        System.out.println();

        String torre =
    "              _.._                        +                        ^v^           \n" +
    "            .' .-'`                      / \\          ^v^                    \n" +
    "            |  |              +         /   \\         +                        \n" +
    "            \\  \\             / \\       /     \\       / \\                       \n" +
    "             '._'-._        /   \\     /   ^   \\     /   \\            ^v^       \n" +
    "          +     '```       /     \\   /   / \\   \\   /     \\            +        \n" +
    "         / \\              /   ^   \\ /   /   \\   \\ /   ^   \\          / \\       \n" +
    "        /   \\            /   / \\   /   |  _  |   \\   / \\   \\        /   \\      \n" +
    "       /  ^  \\          /____|_|__/____|_|_|_|____\\__|_|____\\      /  ^  \\     \n" +
    "      /__/_\\__\\         |  _   _  |  |  _   _   _  |  |  _   _  | /__/_\\__\\    \n" +
    "      | | | ||_||_||| |_| |_| ||_|_| |_| |_| |_| |_|_|| |_| |_| ||_||_|| | | |\n" +
    "       |  _  |  ||  | / \\ / \\ | || |   _______   | || | / \\ / \\ |  ||  |  _  | \n" +
    "       | | | |  ||  | | | | | | || |  /#######\\  | || | | | | | |  ||  | | | | \n" +
    "       | |_| |  ..  | |_| |_| | .. |  |#######|  | .. | |_| |_| |  ..  | |_| | \n" +
    "       |  .  |      |  .   .  |    |  |#######|  |    |  .   .  |      |  .  | \n" +
    "    __/_______\\____/___________\\__/____|#######|____\\__/___________\\____/_______\\__";

System.out.println(torre);

        pausar(entrada);
    }



    public static void encontroNosferatu(Scanner entrada) {

      
        System.out.println("             O SENHOR DO CASTELO");
       

        System.out.println(
            "\nAs enormes portas do castelo se abrem lentamente."
        );

        System.out.println(
            "O salao esta completamente escuro."
        );

        System.out.println(
            "Voce caminha alguns passos."
        );

        System.out.println(
            "\nUma voz surge do fundo do salao."
        );

        System.out.println(
            "\n\"Mais um guerreiro...\""
        );

        System.out.println(
            "\"Mais uma alma que acredita poder me derrotar.\""
        );

        System.out.println(
            "\nUma figura se levanta do trono."
        );

        System.out.println(
            "Nosferatu finalmente aparece."
        );

        System.out.println();
String nosferatu =
    "       _.---._          \n" +
    "    , /~~~ ~~~\\ ,       \n" +
    "    |\\|(0)|(0)|/|       \n" +
    "    | |  'V'  |,|      \n" +
    "    |_/\\ /W\\ /\\_|       \n" +
    "    __/|\\_`_/|\\__       \n" +
    "   /     \\---/     \\    \n" +
    "   \\  `   \\_/   ,  /    \n" +
    "    |  |   /    |  |    \n" +
    "    |  |  | o o |  |    \n" +
    "    |  |  | o o |  |    ";

System.out.println(nosferatu);

        System.out.println(
            "\n\"Voce nao passa de mais um corpo para minha colecao.\""
        );

        System.out.println(
            "\"Vamos acabar logo com isso.\""
        );

        pausar(entrada);
    }




    public static void batalhaInicial(
            Scanner entrada,
            int[] personagem,
            int classe) {

        int vidaNosferatu = 10000;
        int ataqueNosferatu = 100;
        int defesaNosferatu = 100;

        int dano;
        int danoRecebido;
        int opcao;

        
        System.out.println("             BATALHA: NOSFERATU");
    

        System.out.println(
            "\nNosferatu observa voce sem demonstrar preocupacao."
        );

        // A luta dura exatamente três turnos.
        for (int turno = 1; turno <= 3; turno++) {

            System.out.println("\n----------------------------------------");
            System.out.println("TURNO " + turno);
            System.out.println("----------------------------------------");

            System.out.println("Sua vida: " + personagem[0]);

            System.out.println("\n[1] Atacar");
            System.out.println("[2] Usar poder");
            System.out.println("[3] Bloquear");

            do {
                opcao = lerOpcao(entrada, "\nEscolha sua acao: ");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opcao invalida!");
                }

            } while (opcao < 1 || opcao > 3);

            if (opcao == 1) {

                dano = calcularDano(
                    personagem[1],
                    defesaNosferatu
                );

                vidaNosferatu -= dano;

                System.out.println(
                    "\nVoce ataca Nosferatu e causa " + dano + " de dano."
                );

                System.out.println(
                    "Ele sequer parece ter sentido o golpe."
                );

            } else if (opcao == 2) {

                if (classe == 1) {

                    System.out.println(
                        "\nVoce dispara uma Bola de Fogo!"
                    );

                } else if (classe == 2) {

                    System.out.println(
                        "\nVoce tenta um Ataque Furtivo!"
                    );

                } else {

                    System.out.println(
                        "\nVoce ergue seu Escudo Sagrado!"
                    );
                }

                System.out.println(
                    "Nosferatu permanece completamente intacto."
                );

            } else {

                System.out.println(
                    "\nVoce assume uma postura defensiva."
                );
            }

            // O ataque de Nosferatu aumenta durante a luta.
            if (turno == 1) {
                danoRecebido = 15;
            } else if (turno == 2) {
                danoRecebido = 25;
            } else {
                danoRecebido = ataqueNosferatu;
            }

            // O bloqueio reduz o dano a zero.
            if (opcao == 3 || (opcao == 2 && classe == 3)) {
                danoRecebido = 0;
            } else {

                danoRecebido = calcularDano(
                    danoRecebido,
                    personagem[2]
                );
            }

            personagem[0] -= danoRecebido;

            if (personagem[0] < 0) {
                personagem[0] = 0;
            }

            System.out.println(
                "\nNosferatu ataca e causa " + danoRecebido + " de dano."
            );

            System.out.println(
                "Sua vida restante: " + personagem[0]
            );
        }

        // A derrota acontece independentemente do resultado.
        personagem[0] = 0;

        System.out.println("                 DERROTA");


        System.out.println(
            "\nNosferatu segura voce pelo pescoco."
        );

        System.out.println(
            "\"Eu avisei... voce nao tinha a menor chance.\""
        );

        System.out.println(
            "\nSua visao comeca a escurecer."
        );

        System.out.println(
            "Seu corpo cai no chao do castelo."
        );

        pausar(entrada);
    }



    public static void cenaMorte(Scanner entrada) {

  
        System.out.println("                  MORTE");


        System.out.println(
            "\nO silencio toma conta do salao."
        );

        System.out.println(
            "Nosferatu retorna ao seu trono."
        );

        System.out.println(
            "\"Mais um corpo para minha colecao.\""
        );

        System.out.println(
            "\nMas sua historia ainda nao terminou."
        );

        System.out.println(
            "Quando tudo parece desaparecer..."
        );

        System.out.println(
            "Voce sente algo puxando sua alma."
        );

        System.out.println(
            "Uma queda interminavel comeca."
        );

        System.out.println(
            "\nVoce esta sendo levado para outro lugar."
        );

        pausar(entrada);
    }



    public static void despertarSubmundo(
            Scanner entrada,
            int[] personagem,
            int classe) {

   
        System.out.println("                SUBMUNDO");
    

        System.out.println(
            "\nVoce abre os olhos."
        );

        System.out.println(
            "O chao e coberto por cinzas."
        );

        System.out.println(
            "Rios de lava iluminam um horizonte infinito."
        );

        System.out.println(
            "Ao seu redor, almas vagam sem rumo."
        );

        System.out.println(
            "\nVoce percebe que esta no inferno."
        );

        System.out.println(
            "Mas, de alguma forma, ainda esta vivo."
        );

        // Recupera a vida inicial da classe.
        if (classe == 3) {
            personagem[0] = 100;
        } else {
            personagem[0] = 50;
        }

        System.out.println(
            "\nSua vida foi restaurada."
        );

        System.out.println(
            "Vida atual: " + personagem[0]
        );

        pausar(entrada);
    }



    public static void encontroDiabinho(Scanner entrada) {

       
        System.out.println("                UMA PRESENÇA");
     

        System.out.println(
            "\nUm barulho estranho surge atras de uma rocha."
        );

        System.out.println(
            "\"Ei! Voce ai!\""
        );

        System.out.println(
            "\"Nao deveria estar andando por aqui!\""
        );

        System.out.println(
            "\nUma pequena criatura aparece."
        );

        System.out.println();

        String arte =
    "             ,      ,       \n" +
    "          /(.-\"\"-.)\\           \n" +
    "      |\\  \\/      \\/  /|       \n" +
    "      | \\ / =.  .= \\ / |       \n" +
    "      \\( \\   o\\/o   / )/       \n" +
    "       \\_, '-/  \\-' ,_/        \n" +
    "         /   \\__/   \\           \n" +
    "         \\ \\__/\\__/ /           \n" +
    "       ___\\ \\|--|/ /___          \n" +
    "     /`    \\      /    `\\        \n" +
    "    /       '----'       \\       ";

System.out.println(arte);

        System.out.println(
            "\n\"Sou um dos demonios mais importantes daqui!\""
        );

        System.out.println(
            "\"E nao, nao estou com medo de voce.\""
        );

        System.out.println(
            "A criatura parece estar tremendo."
        );

        pausar(entrada);
    }




    public static void batalhaDiabinho(
            Scanner entrada,
            int[] personagem,
            int classe) {

        int vidaInimigo = 60;
        int ataqueInimigo = 15;
        int defesaInimigo = 5;

        int opcao;
        int dano;
        int danoRecebido;
        int turno = 0;

       
        System.out.println("             BATALHA: DIABINHO");
     

        while (personagem[0] > 0 && vidaInimigo > 0) {

            turno++;

            System.out.println("\n----------------------------------------");
            System.out.println("Sua vida: " + personagem[0]);
            System.out.println("Vida do Diabinho: " + vidaInimigo);
            System.out.println("----------------------------------------");

            System.out.println("\n[1] Atacar");
            System.out.println("[2] Usar poder");
            System.out.println("[3] Bloquear");

            do {
                opcao = lerOpcao(entrada, "\nEscolha sua acao: ");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opcao invalida!");
                }

            } while (opcao < 1 || opcao > 3);

            boolean bloqueou = false;

            if (opcao == 1) {

                dano = calcularDano(
                    personagem[1],
                    defesaInimigo
                );

                vidaInimigo -= dano;

                System.out.println(
                    "\nVoce ataca e causa " + dano + " de dano!"
                );

            } else if (opcao == 2) {

                if (classe == 1) {

                    dano = calcularDano(
                        personagem[1] + 15,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nBOLA DE FOGO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else if (classe == 2) {

                    dano = calcularDano(
                        personagem[1] * 2,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nATAQUE FURTIVO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else {

                    bloqueou = true;

                    System.out.println(
                        "\nESCUDO SAGRADO!"
                    );

                    System.out.println(
                        "Voce bloqueia completamente o proximo ataque."
                    );
                }

            } else {

                bloqueou = true;

                System.out.println(
                    "\nVoce assume uma postura defensiva."
                );
            }

            if (vidaInimigo < 0) {
                vidaInimigo = 0;
            }

            // Se o inimigo morreu, ele nao pode atacar.
            if (vidaInimigo <= 0) {
                break;
            }

            if (bloqueou) {

                danoRecebido = 0;

            } else {

                danoRecebido = calcularDano(
                    ataqueInimigo,
                    personagem[2]
                );
            }

            personagem[0] -= danoRecebido;

            if (personagem[0] < 0) {
                personagem[0] = 0;
            }

            System.out.println(
                "\nO Diabinho ataca e causa " + danoRecebido + " de dano!"
            );

            System.out.println(
                "Sua vida restante: " + personagem[0]
            );
        }

        if (vidaInimigo <= 0) {

  
            System.out.println("                 VITORIA");
        

            System.out.println(
                "\nO Diabinho cai de joelhos."
            );

            System.out.println(
                "\"ESPERA! ESPERA! EU ME RENDO!\""
            );

            System.out.println(
                "\n\"Voce nao precisa me matar! Posso ser util!\""
            );

            System.out.println(
                "\"Conheco esse lugar melhor do que ninguem!\""
            );

            System.out.println(
                "\"Posso mostrar um caminho para voce sair daqui!\""
            );

            System.out.println(
                "\nO pequeno demonio parece desesperado."
            );

            System.out.println(
                "\"So precisamos atravessar o territorio do meu antigo mestre...\""
            );

            System.out.println(
                "\"O Diabo.\""
            );

            System.out.println(
                "\nO Diabinho agora sera seu guia."
            );

        } else {

            System.out.println("                 DERROTA");


            System.out.println(
                "\nO Diabinho comemora sua vitoria."
            );

            System.out.println(
                "\"Eu sabia! Quer dizer... foi uma luta dificil!\""
            );

            System.out.println(
                "Sua jornada termina no submundo."
            );
        }

        pausar(entrada);
    }


    public static void evoluirPersonagem(int[] personagem) {

        System.out.println("              EVOLUCAO");
   

        System.out.println(
            "\nA energia do Diabinho comeca a se dissipar."
        );

        System.out.println(
            "Uma parte dessa energia e absorvida por voce."
        );

        personagem[0] += 10;
        personagem[1] += 5;
        personagem[2] += 2;

        System.out.println(
            "\nSeus atributos aumentaram!"
        );

        System.out.println(
            "Vida: " + personagem[0]
        );

        System.out.println(
            "Ataque: " + personagem[1]
        );

        System.out.println(
            "Defesa: " + personagem[2]
        );

        System.out.println(
            "\nO Diabinho observa, claramente arrependido."
        );

        System.out.println(
            "\"Eu devia ter ficado quieto...\""
        );
    }




    public static void caminhoAteDiabo(Scanner entrada) {

        System.out.println("              VALE DAS CINZAS");


        System.out.println(
            "\nO Diabinho comeca a caminhar."
        );

        System.out.println(
            "\"Venha por aqui. Conheco um caminho mais rapido.\""
        );

        System.out.println(
            "\nVoce atravessa um enorme vale coberto por cinzas."
        );

        System.out.println(
            "Criaturas observam sua passagem de longe."
        );

        System.out.println(
            "Nenhuma delas parece querer se aproximar."
        );

        System.out.println(
            "\nDepois de algum tempo, voce avista uma fortaleza."
        );

        System.out.println(
            "Suas torres se erguem acima de um mar de lava."
        );

        System.out.println(
            "\n\"E ali que meu antigo mestre vive...\""
        );

        System.out.println(
            "\"O Diabo.\""
        );

        System.out.println(
            "\nO Diabinho engole seco."
        );

        System.out.println(
            "\"So para deixar claro, nos somos amigos agora, certo?\""
        );

        System.out.println(
            "\"Porque eu realmente nao gostaria de morrer hoje.\""
        );

        pausar(entrada);
    }




    public static void encontroDiabo(Scanner entrada) {


        System.out.println("                A FORTALEZA");
     

        System.out.println(
            "\nAs portas da fortaleza se abrem."
        );

        System.out.println(
            "Um calor insuportavel toma conta do ambiente."
        );

        System.out.println(
            "No fundo do salao, uma figura observa sua chegada."
        );

        System.out.println(
            "\n\"Diabinho...\""
        );

        System.out.println(
            "\"O que voce pensa que esta fazendo trazendo um humano ate aqui?\""
        );

        System.out.println(
            "\nO pequeno demonio se esconde atras de voce."
        );

        System.out.println(
            "\"Entao... sobre isso...\""
        );

        System.out.println(
            "\"Eu posso explicar!\""
        );

        System.out.println(
            "\nO Diabo se levanta de seu trono."
        );

        System.out.println(
            "\"Nao tenho interesse em suas explicacoes.\""
        );

        System.out.println(
            "\"Se deseja continuar, tera que passar por mim.\""
        );

        System.out.println();

       String demonio =
    "      __ _____________________     |\\         /|   _____________________ __\n" +
    "         \\___             / | |\\ \\  .---.---.  / /| | \\             ___/\n" +
    "             \\___    /|  /  | |   \\<>  / \\  <>/  | |  \\  |\\    ___/\n" +
    "                 ____ | /   | |   \\ VvV___VvV /   | |   \\ | ____\n" +
    "             ____   / |/    | |    \\ ^_____^ /    | |    \\| \\   ____\n" +
    "         ____    /    | \\   | |     \\_____/     | |   / |    \\    ____\n" +
    "     ____      /      |   \\ | | ___/ /|___|\\ \\___ | | /   |      \\      ____\n" +
    " ____        /___     |__  \\| |___  | | | | |  ___| |/  __|     ___\\        ____\n" +
    "     ____\\       /    |  /  | \\   | \\ |___| | /   | /  |  \\    \\       /____\n" +
    "          \\     /     | /   |  \\ / | \\|___|/ | \\ /  |   \\ |     \\     /\n" +
    "           \\   /      |/    |   \\| \\  \\___/  / |/   |    \\|      \\";

System.out.println(demonio);

        pausar(entrada);
    }


    public static void batalhaDiabo(
            Scanner entrada,
            int[] personagem,
            int classe) {

        int vidaInimigo = 150;
        int ataqueInimigo = 18;
        int defesaInimigo = 5;

        int opcao;
        int dano;
        int danoRecebido;
        int turno = 0;

    
        System.out.println("               BATALHA: DIABO");
    

        while (personagem[0] > 0 && vidaInimigo > 0) {

            turno++;

            System.out.println("\n----------------------------------------");
            System.out.println("Sua vida: " + personagem[0]);
            System.out.println("Vida do Diabo: " + vidaInimigo);
            System.out.println("----------------------------------------");

            System.out.println("\n[1] Atacar");
            System.out.println("[2] Usar poder");
            System.out.println("[3] Bloquear");

            do {
                opcao = lerOpcao(entrada, "\nEscolha sua acao: ");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opcao invalida!");
                }

            } while (opcao < 1 || opcao > 3);

            boolean bloqueou = false;

            dano = 0;

            if (opcao == 1) {

                dano = calcularDano(
                    personagem[1],
                    defesaInimigo
                );

                vidaInimigo -= dano;

                System.out.println(
                    "\nVoce ataca e causa " + dano + " de dano!"
                );

            } else if (opcao == 2) {

                if (classe == 1) {

                    dano = calcularDano(
                        personagem[1] + 15,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nBOLA DE FOGO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else if (classe == 2) {

                    dano = calcularDano(
                        personagem[1] * 2,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nATAQUE FURTIVO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else {

                    bloqueou = true;

                    System.out.println(
                        "\nESCUDO SAGRADO!"
                    );

                    System.out.println(
                        "O ataque sera completamente bloqueado."
                    );
                }

            } else {

                bloqueou = true;

                System.out.println(
                    "\nVoce se prepara para defender o proximo ataque."
                );
            }

            if (vidaInimigo < 0) {
                vidaInimigo = 0;
            }

            if (vidaInimigo <= 0) {
                break;
            }

            // A cada três turnos, o Diabo usa um ataque especial.
            if (turno % 3 == 0) {

                danoRecebido = 30;

                System.out.println(
                    "\nO DIABO PREPARA UM ATAQUE ESPECIAL!"
                );

            } else {

                danoRecebido = ataqueInimigo;
            }

            if (bloqueou) {

                danoRecebido = 0;

            } else {

                danoRecebido = calcularDano(
                    danoRecebido,
                    personagem[2]
                );
            }

            personagem[0] -= danoRecebido;

            if (personagem[0] < 0) {
                personagem[0] = 0;
            }

            System.out.println(
                "\nO Diabo causa " + danoRecebido + " de dano!"
            );

            System.out.println(
                "Sua vida restante: " + personagem[0]
            );
        }

        if (vidaInimigo <= 0) {

  
            System.out.println("                 VITORIA");
   

            System.out.println(
                "\nO Diabo cai de joelhos."
            );

            System.out.println(
                "\"Impossivel... como um simples humano...\""
            );

            System.out.println(
                "\nO Diabinho aparece atras de voce."
            );

            System.out.println(
                "\"Eu sempre soube que voce conseguiria!\""
            );

            System.out.println(
                "\"Quer dizer... eu tinha certeza absoluta!\""
            );

            System.out.println(
                "\nO Diabo ergue a cabeca."
            );

            System.out.println(
                "\"Se realmente deseja retornar ao mundo dos vivos...\""
            );

            System.out.println(
                "\"Existe um caminho.\""
            );

            System.out.println(
                "\n\"Atras deste salao existe uma passagem.\""
            );

            System.out.println(
                "\"Ela leva ao Portao do Renascimento.\""
            );

            System.out.println(
                "\"Mas existe um guardiao protegendo sua entrada.\""
            );

            System.out.println(
                "\"Ele e muito mais antigo e poderoso do que eu.\""
            );

        } else {


            System.out.println("                 DERROTA");


            System.out.println(
                "\nO Diabo permanece de pe."
            );

            System.out.println(
                "\"Voce nunca deveria ter chegado ate aqui.\""
            );
        }

        pausar(entrada);
    }


    public static void encontroDemonio(Scanner entrada) {

  
        System.out.println("           PORTAO DO RENASCIMENTO");


        System.out.println(
            "\nA passagem atras do trono comeca a se abrir."
        );

        System.out.println(
            "Uma corrente de ar frio atravessa o salao."
        );

        System.out.println(
            "O Diabinho caminha lentamente atras de voce."
        );

        System.out.println(
            "\"Eu nunca gostei desse lugar...\""
        );

        System.out.println(
            "\nA passagem termina em uma enorme camara."
        );

        System.out.println(
            "No centro dela existe um portao gigantesco."
        );

        System.out.println(
            "Uma criatura permanece diante da entrada."
        );

        System.out.println(
            "\nO Diabo abaixa a cabeca."
        );

        System.out.println(
            "\"O Guardiao...\""
        );

        System.out.println(
            "\nA criatura finalmente se move."
        );

        System.out.println();

        System.out.println("   /\\                                                                   /\\   ");
        System.out.println("  /  \\                                                                 /  \\  ");
        System.out.println(" /    '-._                        .-\"\"\"\"\"-.                        _.-'    \\ ");
        System.out.println("/         '-._                  /           \\                  _.-'         \\");
        System.out.println("\\             '-._              |  \\_. ._/  |              _.-'             /");
        System.out.println(" \\      /\\         /\\       _.-'(_   /^\\   _)'-.       /\\         /\\      / ");
        System.out.println("  \\    /  \\       /  \\  _.-'      | |III| |      '-._  /  \\       /  \\    /  ");
        System.out.println("   \\  /    \\     /    \\/          '-.   .-'          \\/    \\     /    \\  /   ");
        System.out.println("    \\/      \\   /      V             '---'             V      \\   /      \\/    ");
        System.out.println("             \\ /                                               \\ /             ");
        System.out.println("              V                                                 V              ");

        System.out.println(
            "\n\"Mais uma alma tentando retornar ao mundo?\""
        );

        System.out.println(
            "\"Voce derrotou o Diabo...\""
        );

        System.out.println(
            "\"Mas isso nao significa absolutamente nada.\""
        );

        System.out.println(
            "\n\"Eu sou o guardiao deste portao.\""
        );

        System.out.println(
            "\"Enquanto eu existir, nenhuma alma abandonara este lugar.\""
        );

        System.out.println(
            "\nO Diabinho se esconde atras de uma coluna."
        );

        System.out.println(
            "\"Acho que agora estamos encrencados...\""
        );

        pausar(entrada);
    }



    public static void batalhaDemonio(
            Scanner entrada,
            int[] personagem,
            int classe) {

        int vidaInimigo = 200;
        int ataqueInimigo = 25;
        int defesaInimigo = 8;

        int opcao;
        int dano;
        int danoRecebido;
        int turno = 0;

   
        System.out.println("             BATALHA: GUARDIAO");


        while (personagem[0] > 0 && vidaInimigo > 0) {

            turno++;

            System.out.println("\n----------------------------------------");
            System.out.println("Sua vida: " + personagem[0]);
            System.out.println("Vida do Guardiao: " + vidaInimigo);
            System.out.println("----------------------------------------");

            System.out.println("\n[1] Atacar");
            System.out.println("[2] Usar poder");
            System.out.println("[3] Bloquear");

            do {
                opcao = lerOpcao(entrada, "\nEscolha sua acao: ");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opcao invalida!");
                }

            } while (opcao < 1 || opcao > 3);

            boolean bloqueou = false;

            dano = 0;

            if (opcao == 1) {

                dano = calcularDano(
                    personagem[1],
                    defesaInimigo
                );

                vidaInimigo -= dano;

                System.out.println(
                    "\nVoce ataca e causa " + dano + " de dano!"
                );

            } else if (opcao == 2) {

                if (classe == 1) {

                    dano = calcularDano(
                        personagem[1] + 20,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nBOLA DE FOGO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else if (classe == 2) {

                    dano = calcularDano(
                        personagem[1] * 2,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nATAQUE FURTIVO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else {

                    bloqueou = true;

                    System.out.println(
                        "\nESCUDO SAGRADO!"
                    );

                    System.out.println(
                        "Voce bloqueia o ataque do Guardiao."
                    );
                }

            } else {

                bloqueou = true;

                System.out.println(
                    "\nVoce se prepara para defender o ataque."
                );
            }

            if (vidaInimigo < 0) {
                vidaInimigo = 0;
            }

            if (vidaInimigo <= 0) {
                break;
            }

            // O Guardiao usa um ataque especial a cada três turnos.
            if (turno % 3 == 0) {

                danoRecebido = 40;

                System.out.println(
                    "\nO GUARDIAO LIBERA UMA ONDA DE ENERGIA!"
                );

            } else {

                danoRecebido = ataqueInimigo;
            }

            if (bloqueou) {

                danoRecebido = 0;

            } else {

                danoRecebido = calcularDano(
                    danoRecebido,
                    personagem[2]
                );
            }

            personagem[0] -= danoRecebido;

            if (personagem[0] < 0) {
                personagem[0] = 0;
            }

            System.out.println(
                "\nO Guardiao causa " + danoRecebido + " de dano!"
            );

            System.out.println(
                "Sua vida restante: " + personagem[0]
            );
        }

        if (vidaInimigo <= 0) {

      
            System.out.println("          O GUARDIAO FOI DERROTADO!");
         

            System.out.println(
                "\nA criatura cai diante do portao."
            );

            System.out.println(
                "Sua armadura se desfaz em fragmentos de luz."
            );

            System.out.println(
                "Pela primeira vez em eras, o caminho esta livre."
            );

        } else {

  
            System.out.println("                 DERROTA");
          

            System.out.println(
                "\nO Guardiao permanece diante do portao."
            );

            System.out.println(
                "\"Sua alma permanecera aqui para sempre.\""
            );
        }

        pausar(entrada);
    }




    public static void cenaRenascimento(
            Scanner entrada,
            int[] personagem,
            int classe) {

       
        System.out.println("              RENASCIMENTO");
   

        System.out.println(
            "\nO Guardiao cai lentamente."
        );

        System.out.println(
            "O enorme portao comeca a se abrir."
        );

        System.out.println(
            "Uma luz intensa atravessa a camara."
        );

        System.out.println(
            "\nO Diabinho se aproxima."
        );

        System.out.println(
            "\"Bom... parece que chegamos ao fim.\""
        );

        System.out.println(
            "\"Foi um prazer trabalhar com voce.\""
        );

        System.out.println(
            "\"Quer dizer, foi um prazer sobreviver ao seu lado.\""
        );

        System.out.println(
            "\nO pequeno demonio para diante do portao."
        );

        System.out.println(
            "\"Eu nao posso atravessar.\""
        );

        System.out.println(
            "\"Mas voce... voce ainda tem uma conta para resolver.\""
        );

        System.out.println(
            "\nVoce atravessa o portao."
        );

        System.out.println(
            "Seu corpo e envolvido por uma luz intensa."
        );

        System.out.println(
            "A energia do submundo percorre suas veias."
        );

        System.out.println(
            "\nSua alma retorna ao mundo dos vivos."
        );

        // Recupera a vida e preserva o bônus de evolução.
        if (classe == 3) {
            personagem[0] = 110;
        } else {
            personagem[0] = 60;
        }

        System.out.println(
            "\nSeu corpo foi restaurado!"
        );

        System.out.println(
            "Vida: " + personagem[0]
        );

        System.out.println(
            "Ataque: " + personagem[1]
        );

        System.out.println(
            "Defesa: " + personagem[2]
        );

        System.out.println(
            "\nMas sua jornada ainda nao terminou."
        );

        System.out.println(
            "Nosferatu continua no castelo."
        );

        pausar(entrada);
    }



    public static void cenaRetornoCastelo(Scanner entrada) {

 
        System.out.println("             DE VOLTA AO MUNDO");


        System.out.println(
            "\nVoce desperta nas proximidades do castelo."
        );

        System.out.println(
            "O mesmo vento frio atravessa as montanhas."
        );

        System.out.println(
            "A fortaleza continua envolta pela escuridao."
        );


        System.out.println(
            "\nMas alguma coisa mudou."
        );

        System.out.println(
            "Voce nao e mais o guerreiro que entrou naquele salao."
        );

        System.out.println(
            "Agora sabe o que existe alem da morte."
        );

        System.out.println(
            "E nao pretende morrer novamente."
        );

        System.out.println(
            "\nO castelo esta diante de voce."
        );

        System.out.println(
            "Desta vez, Nosferatu nao tera a mesma facilidade."
        );

        pausar(entrada);
    }


  

    public static void encontroFinalNosferatu(Scanner entrada) {

    
        System.out.println("          O RETORNO DE NOSFERATU");
 

        System.out.println(
            "\nAs portas do castelo se abrem novamente."
        );

        System.out.println(
            "O salao continua exatamente como antes."
        );

        System.out.println(
            "Nosferatu esta sentado em seu trono."
        );

        String nosferatu =
    "       _.---._          \n" +
    "    , /~~~ ~~~\\ ,       \n" +
    "    |\\|(0)|(0)|/|       \n" +
    "    | |  'V'  |,|      \n" +
    "    |_/\\ /W\\ /\\_|       \n" +
    "    __/|\\_`_/|\\__       \n" +
    "   /     \\---/     \\    \n" +
    "   \\  `   \\_/   ,  /    \n" +
    "    |  |   /    |  |    \n" +
    "    |  |  | o o |  |    \n" +
    "    |  |  | o o |  |    ";

        System.out.println(nosferatu);

        System.out.println(
            "\nAo perceber sua presenca, ele se levanta."
        );

        System.out.println(
            "\"Nao...\""
        );

        System.out.println(
            "\"Isso e impossivel.\""
        );

        System.out.println(
            "\nEle observa seu corpo restaurado."
        );

        System.out.println(
            "\"Eu vi voce morrer.\""
        );

        System.out.println(
            "\"Como conseguiu retornar?\""
        );

        System.out.println(
            "\nVoce caminha em sua direcao."
        );

        System.out.println(
            "Desta vez, nao existe medo."
        );

        System.out.println(
            "\nNosferatu se levanta completamente."
        );

        System.out.println(
            "\"Entao terei que acabar com voce novamente!\""
        );

        pausar(entrada);
    }




    public static void batalhaFinalNosferatu(
            Scanner entrada,
            int[] personagem,
            int classe) {

        int vidaInimigo = 120;
        int ataqueInimigo = 15;
        int defesaInimigo = 5;

        int opcao;
        int dano;
        int danoRecebido;
        int turno = 0;

        System.out.println("          BATALHA FINAL: NOSFERATU");
    

        while (personagem[0] > 0 && vidaInimigo > 0) {

            turno++;

            System.out.println("\n----------------------------------------");
            System.out.println("Sua vida: " + personagem[0]);
            System.out.println("Vida de Nosferatu: " + vidaInimigo);
            System.out.println("----------------------------------------");

            System.out.println("\n[1] Atacar");
            System.out.println("[2] Usar poder");
            System.out.println("[3] Bloquear");

            do {
                opcao = lerOpcao(entrada, "\nEscolha sua acao: ");

                if (opcao < 1 || opcao > 3) {
                    System.out.println("Opcao invalida!");
                }

            } while (opcao < 1 || opcao > 3);

            boolean bloqueou = false;

            dano = 0;

            if (opcao == 1) {

                dano = calcularDano(
                    personagem[1],
                    defesaInimigo
                );

                vidaInimigo -= dano;

                System.out.println(
                    "\nVoce ataca Nosferatu e causa " + dano + " de dano!"
                );

            } else if (opcao == 2) {

                if (classe == 1) {

                    dano = calcularDano(
                        personagem[1] + 20,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nBOLA DE FOGO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else if (classe == 2) {

                    dano = calcularDano(
                        personagem[1] * 2,
                        defesaInimigo
                    );

                    vidaInimigo -= dano;

                    System.out.println(
                        "\nATAQUE FURTIVO!"
                    );

                    System.out.println(
                        "Voce causa " + dano + " de dano!"
                    );

                } else {

                    bloqueou = true;

                    System.out.println(
                        "\nESCUDO SAGRADO!"
                    );

                    System.out.println(
                        "Voce bloqueia completamente o ataque."
                    );
                }

            } else {

                bloqueou = true;

                System.out.println(
                    "\nVoce se prepara para defender o ataque."
                );
            }

            if (vidaInimigo < 0) {
                vidaInimigo = 0;
            }

            if (vidaInimigo <= 0) {
                break;
            }

            // Nosferatu usa um ataque especial a cada três turnos.
            if (turno % 3 == 0) {

                danoRecebido = 25;

                System.out.println(
                    "\nNOSFERATU LIBERA UMA EXPLOSAO DE ENERGIA SOMBRIA!"
                );

            } else {

                danoRecebido = ataqueInimigo;
            }

            if (bloqueou) {

                danoRecebido = 0;

            } else {

                danoRecebido = calcularDano(
                    danoRecebido,
                    personagem[2]
                );
            }

            personagem[0] -= danoRecebido;

            if (personagem[0] < 0) {
                personagem[0] = 0;
            }

            System.out.println(
                "\nNosferatu causa " + danoRecebido + " de dano!"
            );

            System.out.println(
                "Sua vida restante: " + personagem[0]
            );
        }

        if (vidaInimigo <= 0) {


            System.out.println("           NOSFERATU FOI DERROTADO!");


            System.out.println(
                "\nNosferatu cai de joelhos."
            );

            System.out.println(
                "\"Nao... isso nao pode estar acontecendo...\""
            );

            System.out.println(
                "\nA criatura tenta se levantar, mas seu corpo comeca a se desfazer."
            );

            System.out.println(
                "A maldicao que cobria o reino finalmente se quebra."
            );

        } else {


            System.out.println("                 DERROTA");
     

            System.out.println(
                "\nNosferatu permanece de pe."
            );

            System.out.println(
                "\"Voce deveria ter permanecido morto.\""
            );
        }

        pausar(entrada);
    }




    public static void finalHistoria(Scanner entrada) {

        System.out.println("              O FIM DA MALDICAO..");


        System.out.println(
            "\nUma luz atravessa as janelas do castelo."
        );

        System.out.println(
            "Pela primeira vez em muitos anos, o sol volta a nascer."
        );

        System.out.println(
            "A escuridao abandona as montanhas."
        );

        System.out.println(
            "As almas presas pela maldicao finalmente encontram paz."
        );

        System.out.println(
            "\nO reino esta livre."
        );

        System.out.println(
            "E sua historia sera lembrada por muitas geracoes."
        );



        System.out.println(
            "              FIM DE JOGO"
        );


        pausar(entrada);
    }


   

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Vetor que guarda os atributos do personagem.
        int[] personagem = new int[7];

        int classe;
        boolean confirmar;

   
        System.out.println("           RPG: O PORTAO DO RENASCIMENTO");
   

        // O jogador escolhe e confirma sua classe.
        do {

            classe = escolherClasse(entrada);

            configurarPersonagem(classe, personagem);

            String nomeClasse;

            if (classe == 1) {
                nomeClasse = "Mago";
            } else if (classe == 2) {
                nomeClasse = "Ladino";
            } else {
                nomeClasse = "Paladino";
            }

            confirmar = confirmarClasse(
                entrada,
                nomeClasse,
                personagem
            );

        } while (!confirmar);


     

        introducaoClasse(classe, entrada);

        cenaCastelo(entrada);

        encontroNosferatu(entrada);

        batalhaInicial(entrada, personagem, classe);

        cenaMorte(entrada);

        despertarSubmundo(entrada, personagem, classe);

        encontroDiabinho(entrada);

        batalhaDiabinho(entrada, personagem, classe);

        // Só continua se o personagem venceu.
        if (personagem[0] > 0) {

            evoluirPersonagem(personagem);

            caminhoAteDiabo(entrada);

            encontroDiabo(entrada);


            batalhaDiabo(entrada, personagem, classe);

            if (personagem[0] > 0) {

             

                encontroDemonio(entrada);

                batalhaDemonio(entrada, personagem, classe);

                if (personagem[0] > 0) {


                    cenaRenascimento(
                        entrada,
                        personagem,
                        classe
                    );

                    cenaRetornoCastelo(entrada);

                    encontroFinalNosferatu(entrada);


                    batalhaFinalNosferatu(
                        entrada,
                        personagem,
                        classe
                    );

                    if (personagem[0] > 0) {
                        finalHistoria(entrada);
                    }
                }
            }
        }

        entrada.close();
    }
}

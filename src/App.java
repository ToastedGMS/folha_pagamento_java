import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
        Scanner sc = new Scanner(System.in);
        int opcao; // declara a variavel fora do loop para que ela nao seja criada novamente em
                   // cada execução

        do {
            System.out.printf(
                    "Digite sua escolha:\n1-Cadastrar Funcionario Padrao\n2-Cadastrar Funcionario Comissionado\n3-Cadastrar Funcionario Producao\n4-Gerar Folha de Pagamento\n0-Sair do Programa");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.println("Cadastro de colaborador padrão");
                    System.out.println("Informe o nome do colaborador:");
                    String nomeColaboradorPadrao = sc.nextLine();

                    System.out.println("Informe o número de registro do colaborador:");
                    String registroColaboradorPadrao = sc.nextLine();

                    Colaborador newColaborador = new Colaborador(nomeColaboradorPadrao, registroColaboradorPadrao);
                    colaboradores.add(newColaborador);
                    System.out.println("Colaborador " + newColaborador.nomeCompleto + " adicionado.");

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine(); // opção de melhoria para UX
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Cadastro de colaborador comissionado");
                    System.out.println("Informe o nome do colaborador:");
                    String nomeColaboradorComissionado = sc.nextLine();

                    System.out.println("Informe o número de registro do colaborador:");
                    String registroColaboradorComissionado = sc.nextLine();

                    System.out.println("Informe o valor das vendas do colaborador:");
                    double vendasColaboradorComissionado = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Informe a comissão percentual do colaborador:");
                    double comissaoColaboradorComissionado = sc.nextDouble();
                    sc.nextLine();

                    Colaborador newColaboradorComissionado = new ColaboradorComissionado(nomeColaboradorComissionado,
                            registroColaboradorComissionado, vendasColaboradorComissionado,
                            comissaoColaboradorComissionado);

                    colaboradores.add(newColaboradorComissionado);
                    System.out.println("Colaborador " + newColaboradorComissionado.nomeCompleto + " adicionado.");

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}

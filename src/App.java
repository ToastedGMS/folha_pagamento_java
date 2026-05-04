import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
        Scanner sc = new Scanner(System.in);
        int opcao; // declara a variavel fora do loop para que ela nao seja criada novamente em
                   // cada execução

        do {
            System.out.println("\n-------------------------------------------");
            System.out.printf(
                    "1-Cadastrar Funcionario Padrao\n2-Cadastrar Funcionario Comissionado\n3-Cadastrar Funcionario Producao\n4-Gerar Folha de Pagamento\n0-Sair do Programa\nEscolha: ");
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
                    System.out.println("Colaborador " + newColaborador.getNomeCompleto() + " adicionado.");

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
                    System.out.println("Colaborador " + newColaboradorComissionado.getNomeCompleto() + " adicionado.");

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine();
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Cadastro de colaborador da produção");
                    System.out.println("Informe o nome do colaborador:");
                    String nomeColaboradorProducao = sc.nextLine();

                    System.out.println("Informe o número de registro do colaborador:");
                    String registroColaboradorProducao = sc.nextLine();

                    System.out.println("Informe a quantidade de peças produzidas pelo colaborador:");
                    double pecasColaboradorProducao = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Informe o valor por peça:");
                    double valorPeca = sc.nextDouble();
                    sc.nextLine();

                    Colaborador newColaboradorProducao = new ColaboradorProducao(nomeColaboradorProducao,
                            registroColaboradorProducao, pecasColaboradorProducao,
                            valorPeca);

                    colaboradores.add(newColaboradorProducao);
                    System.out.println("Colaborador " + newColaboradorProducao.getNomeCompleto() + " adicionado.");

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("\n======= FOLHA DE PAGAMENTO =======");
                    System.out.println("Total de funcionários: " + colaboradores.size());
                    System.out.println("----------------------------------");

                    for (Colaborador item : colaboradores) {
                        item.imprimirDetalhes();
                        // Usando printf para formatar o dinheiro com 2 casas decimais
                        System.out.printf("Salário Total: R$ %.2f\n", item.calcularSalario());
                        System.out.println("----------------------------------");
                    }

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 0:
                    System.out.println("Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, digite um número entre 0 e 4.");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // força o uso de ponto (.) para decimais
        int opcao; // declara a variavel fora do loop para que ela nao seja criada novamente em
                   // cada execução

        do {
            System.out.println("\n-------------------------------------------");
            System.out.printf(
                    "1-Cadastrar Funcionario Padrao\n2-Cadastrar Funcionario Comissionado\n3-Cadastrar Funcionario Producao\n4-Gerar Folha de Pagamento\n0-Sair do Programa\nEscolha: ");
            opcao = validarOpcao(sc);
            switch (opcao) {
                case 1:
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
                    System.out.println("Cadastro de colaborador comissionado");
                    System.out.println("Informe o nome do colaborador:");
                    String nomeColaboradorComissionado = sc.nextLine();

                    System.out.println("Informe o número de registro do colaborador:");
                    String registroColaboradorComissionado = sc.nextLine();

                    System.out.println("Informe o valor das vendas do colaborador:");
                    double vendasColaboradorComissionado = validarLeitura(sc);

                    while (vendasColaboradorComissionado < 0) { // impede valores negativos
                        System.out.println("Valor inválido! As vendas não podem ser negativas. Tente novamente:");
                        vendasColaboradorComissionado = validarLeitura(sc);
                    }

                    System.out.println("Informe a comissão percentual do colaborador:");
                    double comissaoColaboradorComissionado = validarLeitura(sc);

                    while (comissaoColaboradorComissionado < 0) {
                        System.out.println("Valor inválido! A comissão não pode ser negativa. Tente novamente:");
                        comissaoColaboradorComissionado = validarLeitura(sc);
                    }

                    Colaborador newColaboradorComissionado = new ColaboradorComissionado(nomeColaboradorComissionado,
                            registroColaboradorComissionado, vendasColaboradorComissionado,
                            comissaoColaboradorComissionado);

                    colaboradores.add(newColaboradorComissionado);
                    System.out.println("Colaborador " + newColaboradorComissionado.getNomeCompleto() + " adicionado.");

                    System.out.println("\n[Pressione ENTER para voltar ao menu]");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("Cadastro de colaborador da produção");
                    System.out.println("Informe o nome do colaborador:");
                    String nomeColaboradorProducao = sc.nextLine();

                    System.out.println("Informe o número de registro do colaborador:");
                    String registroColaboradorProducao = sc.nextLine();

                    System.out.println("Informe a quantidade de peças produzidas pelo colaborador:");
                    double pecasColaboradorProducao = validarLeitura(sc);

                    while (pecasColaboradorProducao < 0) {
                        System.out.println(
                                "Valor inválido! A quantidade de peças produzidas não pode ser negativa. Tente novamente:");
                        pecasColaboradorProducao = validarLeitura(sc);
                    }

                    System.out.println("Informe o valor por peça:");
                    double valorPeca = validarLeitura(sc);
                    while (valorPeca < 0) {
                        System.out.println("Valor inválido! O valor por peça não pode ser negativo. Tente novamente:");
                        valorPeca = validarLeitura(sc);
                    }

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

    private static double validarLeitura(Scanner sc) { // valida a leitura do scanner para prevenir crash (em caso do
                                                       // usuario digitar uma string em vez de um numero), e melhorar UX
                                                       // (usuário não precisa se preocupar em usar , ou . para
                                                       // decimais)
        while (true) {
            try {
                String entrada = sc.nextLine();
                return Double.parseDouble(entrada.replace(",", ".")); // Aceita 0,5 ou 0.5
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número (use ponto ou vírgula):");
            }
        }
    }

    private static int validarOpcao(Scanner sc) {
        while (true) {
            try {
                String entrada = sc.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, digite um número entre as opções disponíveis:");
            }
        }
    }
}

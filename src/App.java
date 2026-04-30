import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();

        do {
            System.out.printf(
                    "Digite sua escolha:\n1-Cadastrar Funcionario Padrao\n2-Cadastrar Funcionario Comissionado\n3-Cadastrar Funcionario Producao\n4-Gerar Folha de Pagamento\n0-Sair do Programa");

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }
}

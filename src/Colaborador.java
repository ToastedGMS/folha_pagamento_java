public class Colaborador {
    private String nomeCompleto;
    private String numeroRegistro;
    final double salarioBase = 2000; // utiliza final e private para evitar modificação acidental dos valores

    double calcularSalario() {
        return salarioBase;
    }

    public String getNomeCompleto() { // força a aplicação a usar métodos sempre que precisar de informação sobre a
                                      // classe
        return nomeCompleto;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void imprimirDetalhes() {
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Matrícula: " + numeroRegistro);
        System.out.printf("Salário Base: R$ %.2f\n", salarioBase);
    }

    public Colaborador(String nome, String registro) { // construtor
        this.nomeCompleto = nome;
        this.numeroRegistro = registro;
    }
}

class ColaboradorComissionado extends Colaborador {
    private double valorVendas;
    private double comissaoPercentual;

    public double getValorComissao() {
        double valorComissao = valorVendas * comissaoPercentual / 100;
        return valorComissao;
    }

    @Override // utiliza override para evitar o uso de condicionais longas e repetitivas
    double calcularSalario() {
        double valorComissao = valorVendas * comissaoPercentual / 100;
        return salarioBase + valorComissao;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Nome: " + this.getNomeCompleto());
        System.out.println("Matrícula: " + this.getNumeroRegistro());
        System.out.printf("Salário Base: R$ %.2f\n", salarioBase);
        System.out.println("Valor Comissão: " + this.getValorComissao());
    }

    public ColaboradorComissionado(String nome, String registro, double vendas, double comissao) {
        super(nome, registro); // super garante que o construtor chama os metodos da classe pai antes de
                               // aplicar os seus
        this.valorVendas = vendas;
        this.comissaoPercentual = comissao;
    }

}

class ColaboradorProducao extends Colaborador {
    private double quantidadePecas;
    private double valorPeca;

    public double getBonusProdutividade() {
        double bonusProdutividade = valorPeca * quantidadePecas;
        return bonusProdutividade;
    }

    @Override
    double calcularSalario() {
        double bonusProdutividade = valorPeca * quantidadePecas;
        return salarioBase + bonusProdutividade;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Nome: " + this.getNomeCompleto());
        System.out.println("Matrícula: " + this.getNumeroRegistro());
        System.out.printf("Salário Base: R$ %.2f\n", salarioBase);
        System.out.println("Bônus Produtividade: " + this.getBonusProdutividade());
    }

    public ColaboradorProducao(String nome, String registro, double pecas, double valor) {
        super(nome, registro);
        this.quantidadePecas = pecas;
        this.valorPeca = valor;
    }

}
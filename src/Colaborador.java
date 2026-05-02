public class Colaborador {
    String nomeCompleto;
    String numeroRegistro;
    final double salarioBase = 2000; // utiliza final para evitar modificação do valor

    double calcularSalario() {
        return salarioBase;
    }

    public Colaborador(String nome, String registro) { // construtor
        this.nomeCompleto = nome;
        this.numeroRegistro = registro;
    }
}

class ColaboradorComissionado extends Colaborador {
    private double valorVendas;
    private double comissaoPercentual;
    double valorComissao;

    @Override // utiliza override para evitar o uso de condicionais longas e repetitivas
    double calcularSalario() {
        valorComissao = valorVendas * comissaoPercentual / 100;
        return salarioBase + valorComissao;
    }

    public ColaboradorComissionado(String nome, String registro, double vendas, double comissao) {
        super(nome, registro); // super garante que o construtor chama os metodos da classe pai antes de
                               // aplicar os seus
        this.valorVendas = vendas;
        this.comissaoPercentual = comissao;
    }

    public double getValorComissao() {
        return valorComissao;
    }
}

class ColaboradorProducao extends Colaborador {
    private double quantidadePecas;
    private double valorPeca;
    double bonusProdutividade;

    @Override
    double calcularSalario() {
        bonusProdutividade = valorPeca * quantidadePecas;
        return salarioBase + bonusProdutividade;
    }

    public ColaboradorProducao(String nome, String registro, double pecas, double valor) {
        super(nome, registro);
        this.quantidadePecas = pecas;
        this.valorPeca = valor;
    }

    public double getBonusProdutividade() {
        return bonusProdutividade;
    }
}
# Sistema de Folha de Pagamento em Java

Este projeto consiste em um software de gestão de folha de pagamento desenvolvido em Java, focado na aplicação de conceitos fundamentais de Orientação a Objetos e estruturas de dados. O sistema permite o cadastro de colaboradores em diferentes categorias e o processamento de seus vencimentos.

---

## Funcionalidades Principais

- **Cadastro Dinâmico:** Utiliza `ArrayList` para armazenar colaboradores, permitindo uma lista de tamanho variável.
- **Gestão de Vínculos:** Suporte para três categorias de funcionários:
  - **Padrão:** Recebe o salário base fixo.
  - **Comissionado:** Salário base + cálculo de comissão baseado em vendas.
  - **Produção:** Salário base + bônus por produtividade calculado por peças produzidas.
- **Validação de Dados:** Implementação de mecanismos de proteção contra entradas inválidas (ex: valores negativos, inserção de texto onde números são esperados), garantindo a integridade do sistema.
- **Interface Interativa:** Menu intuitivo via terminal para fácil navegação e operação.

---

## Detalhes Técnicos e Arquitetura

O sistema foi estruturado com foco em **Clean Code** e **Boas Práticas de Programação**:

- **Orientação a Objetos (POO):** Utilização intensiva de herança e polimorfismo. A classe base `Colaborador` define os atributos e comportamentos fundamentais, enquanto as classes filhas estendem a funcionalidade com seus cálculos específicos de salário.
- **Encapsulamento:** Todos os atributos críticos são privados, garantindo que os dados só sejam alterados através de métodos controlados e construtores.
- **Tratamento de Exceções:** Implementação de blocos `try-catch` para garantir que o software não interrompa sua execução (crash) devido a erros de digitação do usuário, melhorando significativamente a experiência do usuário (UX).
- **Formatadores de Locale:** Configuração de `Locale.US` para padronizar o uso de decimais, permitindo que o usuário utilize tanto ponto quanto vírgula na entrada de dados.

---

## Instruções de Execução

Para rodar o projeto, certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.

1.  **Clone ou baixe** os arquivos do projeto.
2.  **Abra o terminal** na pasta onde os arquivos `.java` estão localizados.
3.  **Compile** os arquivos:
    ```bash
    javac *.java
    ```
4.  **Execute** o programa:
    ```bash
    java App
    ```

---

## Regras de Negócio Implementadas

- **Salário Base:** Fixado em R$ 2.000,00 para todos os colaboradores (implementado como constante `static final`).
- **Cálculos Específicos:**
  - _Comissionado:_ `Salário Base + (Vendas * %Comissão / 100)`
  - _Produção:_ `Salário Base + (Quantidade de Peças * Valor por Peça)`

---

## Autor

Projeto desenvolvido para a unidade curricular de Algoritmos e Programação.

---

![Java badge showing OpenJDK logo with orange background and white text on a dark banner](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

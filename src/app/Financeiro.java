package app;

/**
 *  @author Kadu Floresta
 * 
 * 
*/

// Bibliotecas
import java.sql.Connection;
import java.util.Scanner;

// Classe Principal
public class Financeiro {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        // Conexão c/ o BD
        Connection connection = new ConnectionX().getConnection();

        // Impressão do Cabeçalho no Console
        System.out.println("..::[==============]::..");
        System.out.println("..::::[FINANCEIRO]::::..");
        System.out.println("..::[==============]::..\n");
        
        int opcao = 0;
        do {
            // Impressão do Menu
            imprimirOpcoes();
            opcao = scanner.nextInt();
            switch (opcao) { 
            case 1:
                cadastrarPessoas(scanner);
                break;
            case 2:
                cadastrarProventos(scanner);
                break;
            case 3:
                cadastrarDividas(scanner);
                break;
            case 4:
                consultarPessoas(scanner);
                break;
            case 5:
                consultarProventos(scanner);                
                break;
            case 6:
                consultarDividas(scanner);
                break;
            case 7:
                // Encerra do Menu
                System.out.println("OBRIGADO!");
                break;
            default:
                // Inserção da "Chave" Inválida no Menu
                System.out.println("OPÇÃO INVÁLIDA!");
                break;
            }
        } while (opcao != 7);
        scanner.close();
    }
    // Menu
    private static void imprimirOpcoes() {
        System.out.println("Escolha a Opção: ");
        System.out.println("1 >>> Cadastrar Pessoa");
        System.out.println("2 >>> Cadastrar Proventos");
        System.out.println("3 >>> Cadastrar Dividas");
        System.out.println("4 >>> Consultar Pessoas");
        System.out.println("5 >>> Consultar Proventos");
        System.out.println("6 >>> Consultar Dividas");
        System.out.println("7 >>> Sair");
    }
    // Cadastro Pessoa
    private static void cadastrarPessoas(Scanner scanner) {
        System.out.println("Digite o Nome: ");
        String nome = scanner.next();
        System.out.println("Digite o Email: ");
        String email = scanner.next();
        Pessoas pessoa = new Pessoas(nome, email);
    }
    // Cadastro Proventos pelo ID da Pessoa
    private static void cadastrarProventos(Scanner scanner) {
        System.out.println("Digite o Id da Pessoa: ");
        int idPessoa = scanner.nextInt();
        Pessoas pessoa = Pessoas.getPessoa(idPessoa);
        System.out.println("Digite o Mes: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o Ano: ");
        int ano = scanner.nextInt();
        System.out.println("Digite o Valor: R$ ");
        double valor = scanner.nextDouble();
        System.out.println("Digite a % do Imposto: ");
        double imposto = scanner.nextDouble();
        new Proventos(mes, ano, valor, pessoa, imposto);
    }
    // Cadastro Dividas pelo ID da Pessoa
    private static void cadastrarDividas(Scanner scanner) {
        System.out.println("Digite o Id da Pessoa: ");
        int idPessoa = scanner.nextInt();
        Pessoas pessoa = Pessoas.getPessoa(idPessoa);
        System.out.println("Digite o Mes: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o Ano: ");
        int ano = scanner.nextInt();
        System.out.println("Digite o Valor: R$ ");
        double valor = scanner.nextDouble();
        System.out.println("Digite o % da Divida: ");
        double percDesconto = scanner.nextDouble();
        new Dividas(mes, ano, valor, pessoa, percDesconto);
    }
    // Consulta Pessoa
    private static void consultarPessoas(Scanner scanner) {
        Pessoas.getPessoas();
    }
    // Consulta Dividas
    private static void consultarDividas(Scanner scanner) {
        System.out.println("Digite o ID da Pessoa: ");
        int idPessoa = scanner.nextInt();
        Dividas.getDividas(idPessoa);
    }

    // Consulta Proventos
    private static void consultarProventos(Scanner scanner) {
        System.out.println("Digite o ID da Pessoa: ");
        int idPessoa = scanner.nextInt();
        Proventos.getProventos(idPessoa);
    }

}
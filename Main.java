import java.util.*;

public class Main {
    static Map<Integer, conta> contas = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Consultar Saldo");
            System.out.println("7 - Mostrar Extrato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> criarConta(true);
                case 2 -> criarConta(false);
                case 3 -> depositar();
                case 4 -> sacar();
                case 5 -> transferir();
                case 6 -> consultarSaldo();
                case 7 -> mostrarExtrato();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    public static void criarConta(boolean corrente) {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nome do titular: ");
        String titular = sc.nextLine();

        conta conta;
        if (corrente) {
            conta = new ContaCorrente(numero, titular);
        } else {
            conta = new ContaPoupanca(numero, titular);
        }

        contas.put(numero, conta);
        System.out.println("Conta criada com sucesso!");
    }

    public static conta buscarConta(int numero) {
        if (!contas.containsKey(numero)) {
            System.out.println("Conta não encontrada!");
            return null;
        }
        return contas.get(numero);
    }

    public static void depositar() {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        conta conta = buscarConta(numero);
        if (conta != null) {
            System.out.print("Valor a depositar: ");
            double valor = sc.nextDouble();
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso.");
        }
    }

    public static void sacar() {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        conta conta = buscarConta(numero);
        if (conta != null) {
            System.out.print("Valor a sacar: ");
            double valor = sc.nextDouble();
            conta.sacar(valor);
        }
    }

    public static void transferir() {
        System.out.print("Número da conta origem: ");
        int origem = sc.nextInt();
        System.out.print("Número da conta destino: ");
        int destino = sc.nextInt();
        System.out.print("Valor a transferir: ");
        double valor = sc.nextDouble();

        conta cOrigem = buscarConta(origem);
        conta cDestino = buscarConta(destino);

        if (cOrigem != null && cDestino != null) {
            cOrigem.transferir(cDestino, valor);
            System.out.println("Transferência realizada com sucesso.");
        }
    }

    public static void consultarSaldo() {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        conta conta = buscarConta(numero);
        if (conta != null) {
            conta.consultarSaldo();
        }
    }

    public static void mostrarExtrato() {
        System.out.print("Número da conta: ");
        int numero = sc.nextInt();
        conta conta = buscarConta(numero);
        if (conta != null) {
            conta.mostrarExtrato();
        }
    }
}

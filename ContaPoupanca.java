public class ContaPoupanca extends conta {
    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            registrarTransacao("Saque (Poupança)", valor);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }
}

public class ContaCorrente extends conta {
    private double limite = 500.0;

    public ContaCorrente(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            registrarTransacao("Saque (Corrente)", valor);
        } else {
            System.out.println("Limite insuficiente para saque.");
        }
    }
}

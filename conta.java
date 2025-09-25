import java.util.ArrayList;
import java.util.List;

public abstract class conta {
    private int numero;
    private String titular;
    protected double saldo;
    private List<transacao> extrato;

    public conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(new transacao("Depósito", valor));
    }

    public abstract void sacar(double valor);

    public void transferir(conta destino, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.depositar(valor);
            extrato.add(new transacao("Transferência para conta " + destino.getNumero(), valor));
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual da conta " + numero + ": R$ " + String.format("%.2f", saldo));
    }

    public void mostrarExtrato() {
        System.out.println("Extrato da conta " + numero + ":");
        for (transacao t : extrato) {
            System.out.println(t);
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void registrarTransacao(String tipo, double valor) {
        extrato.add(new transacao(tipo, valor));
    }
}

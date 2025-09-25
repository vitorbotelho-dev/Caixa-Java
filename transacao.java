import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class transacao {
    private String tipo;
    private double valor;
    private LocalDateTime data;

    public transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "[" + data.format(formatador) + "] " + tipo + ": R$ " + String.format("%.2f", valor);
    }
}

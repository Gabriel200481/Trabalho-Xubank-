import java.util.ArrayList;
import java.util.List;

public class Conta {
    protected Cliente cliente;
    protected double saldo;
    protected List<String> transacoes;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    public double consultaSaldo() {
        return this.saldo;
    }

    public List<String> consultaExtrato() {
        return this.transacoes;
    }

    public void deposito(double valor) {
        this.saldo += valor;
        this.transacoes.add("Depósito: " + valor);
    }

    public boolean saque(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.transacoes.add("Saque: " + valor);
            return true;
        } else {
            return false;
        }
    }
}
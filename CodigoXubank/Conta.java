import java.util.ArrayList;
import java.util.List;

public class Conta implements ContaInterface{
    private int idConta;
    private static int id = 0;
    private Cliente cliente;
    private double saldo;
    private List<String> transacao;

    public Conta(Cliente cliente) {
        this.idConta = id++;
        this.cliente = cliente;
        this.saldo = 0;
        this.transacao = new ArrayList<>();
    }

    public int getIdConta() {
        return idConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getTransacao() {
        return transacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTransacao(List<String> transacao) {
        this.transacao = transacao;
    }

    @Override
    public double sacar(Double valor){
        double sacado = 0;
        if(this.saldo>=valor){
            sacado = valor;
            this.setSaldo(this.saldo-valor);
        }
        return sacado;
    }

    public void depositar(Double valor){
        setSaldo(getSaldo()+valor);
    }
}

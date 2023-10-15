public class ContaRendaFixa extends Conta{
    private double rendimentoContratado;
    private double imposto;

    public RendaFixa(Cliente cliente, double rendimentoContratado) {
        super(cliente);
        this.rendimentoContratado = rendimentoContratado;
        this.imposto = 0.15;
    }
}

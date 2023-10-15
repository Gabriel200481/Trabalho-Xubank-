public class ContaInvestimento extends Conta{
    private double rendimentoDiario;
    private double imposto;
    private double taxa;

    public Investimento(Cliente cliente, double rendimentoDiario) {
        super(cliente);
        this.rendimentoDiario = rendimentoDiario;
        this.imposto = 0.15;
        this.taxa = 0.015;
    }
}

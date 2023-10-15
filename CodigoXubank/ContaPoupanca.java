public class ContaPoupanca extends Conta{
    private double rendimentoMensal;

    public Poupanca(Cliente cliente) {
        super(cliente);
        this.rendimentoMensal = 0.005;
    }
}

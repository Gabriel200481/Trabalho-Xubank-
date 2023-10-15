public class ContaCorrente extends Conta {
    private double taxaMensal;
    private double limiteEspecial;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.taxaMensal = 20.0;
        this.limiteEspecial = 200.0;
    }
}

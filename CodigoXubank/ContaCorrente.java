public class ContaCorrente extends Conta {
    private double taxaMensal;
    private double limiteEspecial;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.taxaMensal = 20.0;
        this.limiteEspecial = 200.0;
    }

    public void aplicarTaxaMensal() {
        sacar(taxaMensal);
    }

    @Override
    public double sacar(Double valor){
        double sacado = 0;
        if(valor<=(this.getSaldo()+limiteEspecial)){
            sacado = valor;
            this.setSaldo(this.getSaldo()-valor);
        }
        return sacado;
    }
}

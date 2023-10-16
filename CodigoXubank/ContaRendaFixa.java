public class ContaRendaFixa extends Conta {
    private double rendimentoContratado;
    private double imposto;

    public ContaRendaFixa(Cliente cliente, double rendimentoContratado) {
        super(cliente);
        this.rendimentoContratado = rendimentoContratado;
        this.imposto = 0.15;
    }

    @Override
    public double sacar(Double valor){
        double sacado = 0;
        if (valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor);
            sacado = valor;
        }
        return sacado;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * rendimentoContratado;
        double impostoSobreRendimento = rendimento * imposto;
        depositar(rendimento - impostoSobreRendimento);
    }
}


public class ContaInvestimento extends Conta {
    private double rendimentoDiario;
    private double imposto;
    private double taxa;

    public ContaInvestimento(Cliente cliente, double rendimentoDiario) {
        super(cliente);
        this.rendimentoDiario = 0;
        this.imposto = 0.15;
        this.taxa = 0.015;
    }

    public void calcularRendimentoDiario() {
        double min = -10, max = 10;
        double taxaDiaria = (int) (Math.floor(Math.random() * (max - min + 1) + min));
        double rendimento = getSaldo() * taxaDiaria;
        setSaldo(getSaldo()+rendimento);
    }

    @Override
    public double sacar(Double valor) {
        double sacado = 0;
        if (valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - (valor));
            sacado = valor - (rendimentoDiario * imposto + rendimentoDiario * taxa);
        }
        return sacado;
    }

}

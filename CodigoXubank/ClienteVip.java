import java.util.*;

public class ClienteVip extends Cliente {
    private int pontosFidelidade;
    private final double mensalidade = 30;

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void setPontosFidelidade(int pontosFidelidade) {
        this.pontosFidelidade = pontosFidelidade;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public ClienteVip(String nome, int cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
    }

    @Override
    public void depositar(int id, Double valor){
        int div1, div2;
        for(Conta c : getContas()){
            if (c.getIdConta() == id){
                div1 = (int)c.getSaldo()/2000;
                c.setSaldo(c.getSaldo()+valor);
                div2 = (int)c.getSaldo()/2000;
                if(div1!=div2)
                    aplicaFidelidade();
            }
        }
    }

    @Override
    public void aplicaFidelidade(){
        setPontosFidelidade(getPontosFidelidade()+30);
    }

    public void calcularRendimento() {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, 5); // Diamês do
        date.set(Calendar.HOUR_OF_DAY, 12); // Hora do dia
        date.set(Calendar.MINUTE, 0); // Minuto
        date.set(Calendar.SECOND, 0); // Segundo
        date.set(Calendar.MILLISECOND, 0); // Milissegundo

        if (new Date().after(date.getTime())) {
            date.add(Calendar.MONTH, 1);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                aplicaFidelidade();
            }
        };

        timer.schedule(task, date.getTime(), 1000 * 60 * 60 * 24 * 30); // Repete a cada 30 dias
    }
}

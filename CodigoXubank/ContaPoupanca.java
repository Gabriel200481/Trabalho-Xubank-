import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ContaPoupanca extends Conta {
    private double rendimentoMensal = 0.05;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void calcularRendimento() {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, 5); 
        date.set(Calendar.HOUR_OF_DAY, 12); 
        date.set(Calendar.MINUTE, 0); 
        date.set(Calendar.SECOND, 0); 
        date.set(Calendar.MILLISECOND, 0); 

        if (new Date().after(date.getTime())) {
            date.add(Calendar.MONTH, 1);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                double rendimento = getSaldo() * (rendimentoMensal);
                setSaldo(getSaldo()+rendimento);
            }
        };

        timer.schedule(task, date.getTime(), 1000 * 60 * 60 * 24 * 30); 
    }

    @Override
    public double sacar(Double valor){
        double sacado = 0;
        if(valor<=this.getSaldo()){
            sacado = valor;
            this.setSaldo(this.getSaldo()-valor);
        }
        return sacado;
    }
}

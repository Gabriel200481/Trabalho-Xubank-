import java.util.ArrayList;
import java.util.List;

public class Gerente {
    public static List<Cliente> clientesCadastrados = new ArrayList<>();

    public Gerente() {}

    public void adicionarCliente(Cliente c) {
        clientesCadastrados.add(c);
    }
    public void removeCliente(Cliente c) {
        clientesCadastrados.remove(c);
    }

    public void calcularTotalCustodia() {
        double totalCorrente = 0;
        double totalInvestimento = 0;
        double totalPoupanca = 0;
        double totalRendaFixa = 0;

        for (Cliente cliente : clientesCadastrados) {
            for (Conta conta : cliente.getContas()) {
                if (conta instanceof ContaCorrente) {
                    totalCorrente += conta.getSaldo();
                } else if (conta instanceof ContaInvestimento) {
                    totalInvestimento += conta.getSaldo();
                } else if (conta instanceof ContaPoupanca) {
                    totalPoupanca += conta.getSaldo();
                } else if (conta instanceof ContaRendaFixa) {
                    totalRendaFixa += conta.getSaldo();
                }
            }
        }

        System.out.println("Total em Custódia (Conta Corrente): " + totalCorrente);
        System.out.println("Total em Custódia (Conta Investimento): " + totalInvestimento);
        System.out.println("Total em Custódia (Conta Poupança): " + totalPoupanca);
        System.out.println("Total em Custódia (Conta Renda Fixa): " + totalRendaFixa);
    }

    public void calcularSaldoMedioContas() {
        double totalSaldo = 0;
        int totalContas = 0;

        for (Cliente cliente : clientesCadastrados) {
            for (Conta conta : cliente.getContas()) {
                totalSaldo += conta.getSaldo();
                totalContas++;
            }
        }

        if (totalContas > 0) {
            double saldoMedio = totalSaldo / totalContas;
            System.out.println("Saldo Médio de Todas as Contas: " + saldoMedio);
        } else {
            System.out.println("Não há contas cadastradas.");
        }
    }

    public void contarClientesComSaldoNegativo() {
        int clientesComSaldoNegativo = 0;

        for (Cliente cliente : clientesCadastrados) {
            double saldoTotal = 0;
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
            }

            if (saldoTotal < 0) {
                clientesComSaldoNegativo++;
            }
        }

        System.out.println("Número de Clientes com Saldo Total Negativo: " + clientesComSaldoNegativo);
    }

    public void encontrarClientesMaiorEMenorSaldo() {
        Cliente clienteMaiorSaldo = null;
        Cliente clienteMenorSaldo = null;
        double maiorSaldo = Double.NEGATIVE_INFINITY;
        double menorSaldo = Double.POSITIVE_INFINITY;

        for (Cliente cliente : clientesCadastrados) {
            double saldoTotal = 0;
            for (Conta conta : cliente.getContas()) {
                saldoTotal += conta.getSaldo();
            }

            if (saldoTotal > maiorSaldo) {
                maiorSaldo = saldoTotal;
                clienteMaiorSaldo = cliente;
            }

            if (saldoTotal < menorSaldo) {
                menorSaldo = saldoTotal;
                clienteMenorSaldo = cliente;
            }
        }

        if (clienteMaiorSaldo != null) {
            System.out.println("Cliente com Maior Saldo Total: " + clienteMaiorSaldo.getNome());
            System.out.println("Maior Saldo Total: " + maiorSaldo);
        }

        if (clienteMenorSaldo != null) {
            System.out.println("Cliente com Menor Saldo Total: " + clienteMenorSaldo.getNome());
            System.out.println("Menor Saldo Total: " + menorSaldo);
        }
    }
}

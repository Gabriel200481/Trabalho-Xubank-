import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;

        Cliente cliente1= new Cliente ("Vitor",123, "senha123");
        Conta conta1= new Conta (cliente1);
        cliente1.getContas().add(conta1);

        Cliente cliente2= new Cliente("Alice",456,"senha456");
        Conta conta2 = new Conta(cliente2);
        cliente2.getContas().add(conta2);

        Cliente c1 = new Cliente("Vitor",123,"123");
        ClienteGold c2 = new ClienteGold("Vit",222,"123");
        ClienteVip c3 = new ClienteVip("V",333,"123");
        Cliente c4 = new Cliente("Vvv",113,"123");
        Gerente g = new Gerente();

        do {
            System.out.println("1-Consultar Saldo");
            System.out.println("2-Extrato:");
            System.out.println("3-Transferencia:");
            System.out.println("4-Gerente:");
            System.out.println("5-Sair:");
            System.out.println("Opção:");
            opcao= ler.nextInt();

            switch(opcao)
            {
                case 1:
                    System.out.println("Digite o ID da conta para consultar o saldo: ");
                    int idContaSaldo= ler.nextInt();
                    double saldo= cliente1.consultarSaldo(idContaSaldo);
                    System.out.println("Saldo atual: R$ "+ saldo);
                break;

                case 2:
                    System.out.println("Digite o ID da conta para consultar o extrato: ");
                    int idContaExtrato= ler.nextInt();
                    String extrato= cliente1.consultarExtrato(idContaExtrato);
                    System.out.println("Extrato:\n "+ extrato);
                break;

                case 3:
                    System.out.println("Digite o ID da conta de origem: ");
                    int idContaOrigem= ler.nextInt();
                    System.out.println("Digite o ID da conta de destino:");
                    int idContaDestino= ler.nextInt();
                    System.out.println("Digite o valor a ser transferido:");
                    double valorTransferencia= ler.nextDouble();
                    boolean transferenciaSucesso= cliente1.transferir(cliente2,idContaOrigem,idContaDestino,valorTransferencia);
                    if(transferenciaSucesso)
                    {
                        System.out.println("Transferencia realizada com sucesso");
                    }else{
                        System.out.println("Falha na transferencia.Verifique as contas e o saldo ");}
                break;

                case 4:
                    System.out.println("1-Adicionar todos os cliente:");
                    System.out.println("2-Calculos gerais:");
                    System.out.println("3-Maior e menos saldos:");
                    System.out.println("Opção:");
                    opcao = ler.nextInt();
                    switch (opcao){
                        case 1:
                            g.adicionarCliente(c1);
                            g.adicionarCliente(c2);
                            g.adicionarCliente(c3);
                            g.adicionarCliente(c4);
                            break;
                        case 2:
                            g.calcularTotalCustodia();
                            g.calcularSaldoMedioContas();
                            g.contarClientesComSaldoNegativo();
                            break;
                        case 3:
                            g.encontrarClientesMaiorEMenorSaldo();
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida.Tente outro número.");
            }
        }while (opcao != 4);
        ler.close();
    }
}

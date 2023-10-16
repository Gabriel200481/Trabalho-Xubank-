import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;

        Cliente c1 = new Cliente("Vitor",123,"123");
        ClienteGold c2 = new ClienteGold("Vit",222,"123");
        ClienteVip c3 = new ClienteVip("V",333,"123");
        Cliente c4 = new Cliente("Vvv",113,"123");
        ContaCorrente co1 = new ContaCorrente(c1);
        ContaPoupanca co2 = new ContaPoupanca(c2);
        ContaRendaFixa co3 = new ContaRendaFixa(c3,10);
        ContaInvestimento co4 = new ContaInvestimento(c4,20);
        Gerente g = new Gerente();

        do {
            System.out.println("Bem-vindo ao XuBank! Escolha uma opção:");
            System.out.println("1- Interface de cliente");
            System.out.println("2- Interface de conta");
            System.out.println("3. Inteface de gerente");
            System.out.println("4. ....");
            System.out.println("5. ....");
            System.out.println("6. Sair");
            System.out.print("Opção: ");
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    
                    break;
                case 6:
                    System.out.println("Obrigado por utilizar de nossos serviços! Volte sempre.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente outro número.");
            }
        }while (opcao != 6);
        ler.close();
    }
}

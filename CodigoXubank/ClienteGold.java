public class ClienteGold extends Cliente{
    private int pontosFidelidade;

    public ClienteGold(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
    }
}

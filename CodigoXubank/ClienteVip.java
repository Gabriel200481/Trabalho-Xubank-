public class ClienteVip extends Cliente{
    private int pontosFidelidade;

    public ClienteVip(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.pontosFidelidade = 0;
    }
}

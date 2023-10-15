public abstract class Cliente {
    private String nome;
    private int cpf;
    private String senha;

    public Cliente(String nome, int cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
}

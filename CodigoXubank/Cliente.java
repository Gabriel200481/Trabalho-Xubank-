import java.util.List;
import java.util.ArrayList;

public class Cliente implements ClienteInterface{
    private String nome;
    private int cpf;
	private String senha;
    private List<Conta> contas;

	public List<Conta> getContas() {
        return contas;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

     public Cliente(String nome, int cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public double consultarSaldo(int id){
        for(Conta c : getContas()){
            if(c.getIdConta() == id)
                return c.getSaldo();
        }
        return 0;
    }

    public String consultarExtrato(int id){
        String concat = "";
        for(Conta c : getContas()){
            if (c.getIdConta() == id)
                concat = String.join(",\n", c.getTransacao());
        }
        return concat;
    }

    @Override
    public void depositar(int id, Double valor){
        for(Conta c : getContas()){
            if (c.getIdConta() == id)
                c.setSaldo(c.getSaldo()+valor);
        }
    }

    @Override
    public void aplicaFidelidade(){}

    public boolean transferir(Cliente destinatario, int idOrigem, int idDestino, Double valor){
        Conta contaOrigem = new Conta(destinatario);
        Conta contaDestino = new Conta(destinatario);
        for(Conta origem : getContas()){
            if (origem.getIdConta() == idOrigem)
                contaOrigem = origem;
        }
        for(Conta destino : getContas()){
            if (destino.getIdConta() == idDestino)
                contaDestino = destino;
        }
        if(getContas().contains(contaOrigem) && destinatario.getContas().contains(contaDestino)){
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                return true;
        }
        else
            return false;
    }
}

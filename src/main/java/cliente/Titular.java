package cliente;

public class Titular {

    private String nome;
    private String cpf;
    private String profissao;
    private String endereco;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    @Override
    public String toString() {
        return "cliente.Titular{" +
                "Nome=" + this.nome +
                ", CPF=" + this.cpf +
                ", Profissao=" + this.profissao +
                ", Endereco=" + this.endereco +
                '}';
    }
}

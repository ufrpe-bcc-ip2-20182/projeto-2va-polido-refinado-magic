package beans;



import java.util.Date;

public class Pessoa
{
    private String nome;
    private Date datadenascimento;
    private String cpf;
    private Conta conta;

    public Date getDatadenascimento()
    {
        return datadenascimento;
    }

    public void setDatadenascimento(Date datadenascimento)
    {
        this.datadenascimento = datadenascimento;
    }

    public String getCpf()
    {
        return cpf;
    }

    public boolean setCpf(String cpf)
    {
        this.cpf = cpf;
        return true;
    }

    public Conta getConta()
    {
        return conta;
    }

    public void setConta(Conta conta)
    {
        this.conta = conta;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void cadastro()
    {

    }
}

package beans;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Conta extends Pessoa
{
    private String login;
    private String senha;
    private String id;
    private Date dataDeCriacao;
    private double saldo;
    private boolean status;
    private ArrayList<Boleto> boletos;
    private String email;

    public void setEmail(String email){this.email = email; }
    public String getEmail(){return email;}

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }
    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public Date getDataDeCriacao()
    {
        return dataDeCriacao;
    }
    public void setDataDeCriacao(Date dataDeCriacao)
    {
        this.dataDeCriacao = dataDeCriacao;
    }

    public double getSaldo()
    {
        return saldo;
    }
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public boolean isStatus()
    {
        return status;
    }
    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public ArrayList<Boleto> getBoletos()
    {
        return this.boletos;
    }
    public void setBoletos(Boleto boleto)
    {
        this.boletos.add(boleto);
    }

    public void setBoletos()
    {
        this.boletos.clear();
    }
    public void removeBoleto(Boleto boleto)
    {
        this.boletos.remove(boleto);
    }

    public Conta()
    {
        this.setNome("Nome");
        this.setCpf("000.000.000-00");
        SimpleDateFormat h = new SimpleDateFormat("dd/MM/yyyy");
        Date aux = null;
        try
        {
            aux = h.parse("01/01/0000");
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        this.setDatadenascimento(aux);
    }

}

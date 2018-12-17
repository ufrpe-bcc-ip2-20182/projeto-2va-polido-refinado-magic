package br.ufrpe.bcc.ip2.projeto.beans;
import java.util.Date;

public class Boleto
{
    private String nomeDoBoleto;
    private Date dataDeCriacao;
    private Date dataDeVencimento;
    private boolean pagamento;
    private double valor;



    public String getNomeDoBoleto()
    {
        return nomeDoBoleto;
    }

    public void setNomeDoBoleto(String nomeDoBoleto)
    {
        this.nomeDoBoleto = nomeDoBoleto;
    }

    public Date getDataDeCriacao()
    {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(Date dataDeCriacao)
    {
        this.dataDeCriacao = dataDeCriacao;
    }

    public Date getDataDeVencimento()
    {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento)
    {
        this.dataDeVencimento = dataDeVencimento;
    }

    public boolean isPagamento()
    {
        return pagamento;
    }

    public void setPagamento(boolean pagamento)
    {
        this.pagamento = pagamento;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

}

package br.ufrpe.bcc.ip2.projeto;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public Boleto()
    {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;

        System.out.println("Digite o nome do Boleto:");
        setNomeDoBoleto(scan.nextLine());

        System.out.println("Digite a data de criação do Boleto (formato 'dd/mm/aaaa'):");
        try
        {
            data = dateFormat.parse(scan.nextLine());
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        setDataDeCriacao(data);

        System.out.println("Digite a data de vencimento do Boleto (formato 'dd/mm/aaaa'):");
        try
        {
            data = dateFormat.parse(scan.nextLine());
        }
        catch (ParseException x)
        {
            //Salvar erro em arquivo, sei lá
        }
        setDataDeVencimento(data);

        System.out.println("Digite o valor a ser pago:");
        setValor(scan.nextDouble());

        setPagamento(false);

        System.out.println("Novo Boleto registrado com sucesso.");
    }
}

package beans;

import java.util.ArrayList;

public class Sistema
{
    private ArrayList<Conta> contas = new ArrayList<>();

    public ArrayList<Conta> getContas()
    {
      return contas;
    }

    public void addContas(Conta conta)
    {
        this.contas.add(conta);
    }

    public void removeContas(Conta conta)
    {
        this.contas.remove(conta);
        if(this.contas.contains(conta))
        {
            this.contas.remove(conta);
        }
        else
        {
            System.out.println("Irremovivel.");
        }
    }
}
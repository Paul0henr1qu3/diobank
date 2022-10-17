package banco;

import cliente.Titular;
import exceptions.SemSaldoException;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Conta implements Juros{

    private int agencia;
    private int numeroDaConta;
    private double saldo;
    Titular titular;

    private Map<Date, String> extrato = new LinkedHashMap<Date, String>();

    public Conta(int agencia, int numeroDaConta, Titular titular) {
        this.agencia = agencia;
        this.numeroDaConta = numeroDaConta;
        this.saldo = 0.0;
        this.titular = titular;
    }

    public void saca(double valor) throws SemSaldoException {
        if (valor > this.saldo) {
            throw new SemSaldoException();
        }

        this.saldo -= valor;
        this.extrato.put(Calendar.getInstance().getTime(),"Saque");
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void deposita(double valor) {
        this.saldo += valor;
        this.extrato.put(Calendar.getInstance().getTime(),"Deposito");
    }

    public void transfere(Conta origem, Conta destino, double valor) {
        try {
            valor -= origem.jurosPorTransferencia(valor);
            origem.saca(valor);
            destino.deposita(valor);
            this.extrato.put(Calendar.getInstance().getTime(),"Transferencia");
        } catch (SemSaldoException sse) {
            sse.printStackTrace();
        }
    }

    public Map<Date, String> getExtrato() {
        System.out.println("----INICIO DO EXTRATO----");
        return extrato;
    }

    @Override
    public String toString() {
        return "banco.Conta{" +
                "agencia=" + this.agencia +
                ", numeroDaConta=" + this.numeroDaConta +
                ", saldo=" + this.saldo +
                ", titular=" + this.titular +
                '}';
    }
}



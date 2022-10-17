package banco;

import cliente.Titular;

public class ContaPoupanca extends Conta implements Juros{

    public ContaPoupanca(int agencia, int numeroDaConta, Titular titular) {
        super(agencia, numeroDaConta, titular);
    }


    @Override
    public double jurosPorTransferencia(double valorDaTransação) {
        return valorDaTransação * 0.1;
    }
}

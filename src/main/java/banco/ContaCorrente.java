package banco;

import cliente.Titular;

public class ContaCorrente extends Conta implements Juros{

    public ContaCorrente(int agencia, int numeroDaConta, Titular titular) {
        super(agencia, numeroDaConta, titular);
    }

    @Override
    public double jurosPorTransferencia(double valorDaTransação) {
        return valorDaTransação * 0.3;
    }

}

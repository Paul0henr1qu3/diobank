import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;
import cliente.Titular;
import exceptions.SemSaldoException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContaTeste {
    private static Conta cc;
    private static Conta cp;

    @BeforeAll
    static void criaConta(){
        Titular titular = new Titular();
        titular.setNome("Paulo");
        titular.setCpf("222.222.222-90");
        titular.setProfissao("Analista");
        titular.setEndereco("Rua 2");

        cc = new ContaCorrente(2,42,titular);
        cc.deposita(250);
        cp = new ContaPoupanca(2,42,titular);


    }


    @Test
    void validatransferenciaComSucesso(){

        cc.transfere(cc,cp,100);
        System.out.println(cc.getSaldo());
        assertEquals(70,cp.getSaldo());

    }

    @Test
    void validaTransferenciaSemSucesso(){
        cc.transfere(cc,cp,1000);
        assertEquals(250,250);
    }

    @Test
    void validaSaqueSemSaldo(){
        assertThrows(SemSaldoException.class, () -> cc.saca(1000));
        assertEquals(250,250);
    }

    @Test
    void validaDepositoComSucesso(){
        cc.deposita(100);
        assertEquals(280,cc.getSaldo());
    }


}

package banco;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new LinkedList<>();

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionaConta(Conta contas) {
        this.contas.add(contas);
    }
}

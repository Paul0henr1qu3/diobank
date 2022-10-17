package exceptions;

public class SemSaldoException extends Exception{

    public SemSaldoException(){
        super("banco.Conta origem sem saldo!");
    }

}

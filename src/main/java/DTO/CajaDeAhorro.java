package DTO;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{
    private int operaciones;

    public CajaDeAhorro(double saldoInicial) {
        super(saldoInicial);
        this.operaciones = 0;
    }

    public synchronized boolean agregarSaldo(double monto){
        if (monto > 0) {
            saldo += monto;
            operaciones = operaciones +1;
            return true;
        }
        return false;
    }

    public synchronized boolean quitarSaldo(double monto){
        if (monto > 0 && saldo > monto) {
            saldo -= monto;
            operaciones = operaciones + 1;
            return true;
        }
        return false;
    }

    public synchronized double getSaldo(){
        return saldo;
    }

    public synchronized int getOperaciones(){
        return operaciones;
    }
}

package DTO;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{
    private int operaciones;
    private double giroDescubierto;

    public CuentaCorriente(double saldoInicial, double giroDescubierto) {
        super(saldoInicial);
        this.giroDescubierto = giroDescubierto;
        this.operaciones = 0;
    }

    public synchronized  boolean agregarSaldo(double monto) {
        if (monto > 0) {
            saldo += monto;
            operaciones = operaciones + 1;
            return true;
        }
        return false;

    }

    public synchronized boolean quitarSaldo(double monto) {
        if (monto > 0 && (saldo - monto) >= -giroDescubierto) {
            saldo -= monto;
            operaciones = operaciones + 1;
            return true;
        }
        return false;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized int getOperaciones() {
        return operaciones;
    }
    public synchronized void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }
}

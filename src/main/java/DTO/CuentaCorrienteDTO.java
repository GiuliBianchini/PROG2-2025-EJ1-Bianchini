package DTO;

public class CuentaCorrienteDTO {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    public CuentaCorrienteDTO(double saldo, int operaciones, double giroDescubierto) {
        this.saldo = saldo;
        this.operaciones = operaciones;
        this.giroDescubierto = giroDescubierto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(int operaciones) {
        this.operaciones = operaciones;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }
}

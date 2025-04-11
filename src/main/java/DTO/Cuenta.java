package DTO;

public class Cuenta {
    protected double saldo;

    public Cuenta(){
        this.saldo =0.0;
    }

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

}

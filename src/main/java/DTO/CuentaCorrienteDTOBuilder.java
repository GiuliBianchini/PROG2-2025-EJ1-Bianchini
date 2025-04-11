package DTO;

public class CuentaCorrienteDTOBuilder {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    public CuentaCorrienteDTOBuilder setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CuentaCorrienteDTOBuilder setOperaciones(int operaciones) {
        this.operaciones = operaciones;
        return this;
    }

    public CuentaCorrienteDTOBuilder setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
        return this;
    }

    public CuentaCorrienteDTO build() {
        return new CuentaCorrienteDTO(saldo, operaciones, giroDescubierto);
    }
}

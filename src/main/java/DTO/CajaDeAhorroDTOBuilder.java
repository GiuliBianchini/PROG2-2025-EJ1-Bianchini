package DTO;

public class CajaDeAhorroDTOBuilder {
    private double saldo;
    private int operaciones;

    public CajaDeAhorroDTOBuilder setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CajaDeAhorroDTOBuilder setOperaciones(int operaciones) {
        this.operaciones = operaciones;
        return this;
    }

    public CajaDeAhorroDTO build() {
        return new CajaDeAhorroDTO(saldo, operaciones);
    }
}

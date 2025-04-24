package org.Banco.dto;

public abstract class Cuenta {
    protected double Saldo;
    protected int Operaciones;

    public abstract boolean agregarSaldo(double monto);
    public abstract boolean quitarSaldo(double Monto);

    public synchronized double getSaldo() {
        return Saldo;
    }

    public synchronized int getOperaciones() {
        return Operaciones;
    }
}

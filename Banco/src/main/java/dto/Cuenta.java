package dto;

public abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldo) {
        saldo = saldo;
    }

    protected synchronized boolean operar(double monto) {
        saldo += monto;
        return true;
    }

    protected synchronized boolean puedeQuitar(double monto) {
        return saldo >= monto;
    }

    protected synchronized double obtenerSaldo() {
        return saldo;
    }
}

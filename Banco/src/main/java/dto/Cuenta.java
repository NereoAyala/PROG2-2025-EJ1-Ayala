package dto;

public abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    protected synchronized boolean operar(double monto) {
        saldo += monto;
        return true;
    }

    protected synchronized boolean puedeQuitar(double monto) {
        return saldo >= monto;
    }

    public synchronized double obtenerSaldo() {
        return saldo;
    }
}

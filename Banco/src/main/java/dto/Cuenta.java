package dto;

public abstract class Cuenta {
    protected double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized double obtenerSaldo() {
        return saldo;
    }
}

package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{

    private final double giroDescubierto;
    private int operaciones = 0;

    public CuentaCorriente(double saldoInicial, double giroDescubierto) {
        super(saldoInicial);
        this.giroDescubierto = giroDescubierto;
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        operaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto <= 0) return false;

        double saldoProvisorio = saldo - monto;
        if (saldoProvisorio < -giroDescubierto) return false;

        saldo = saldoProvisorio;
        operaciones++;
        return true;
    }

    @Override
    public synchronized double getSaldo() {
        return saldo;
    }

    @Override
    public synchronized double getOperaciones() {
        return operaciones;
    }
}

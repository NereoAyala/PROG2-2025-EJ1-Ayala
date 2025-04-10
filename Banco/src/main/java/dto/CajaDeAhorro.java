package dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    private int operaciones = 0;

    public CajaDeAhorro(double saldoInicial) {
        super(saldoInicial);
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
        if (monto <= 0 || saldo < monto) return false;
        saldo -= monto;
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

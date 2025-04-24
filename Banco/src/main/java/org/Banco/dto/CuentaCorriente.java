package org.Banco.dto;

public class CuentaCorriente extends Cuenta implements TGestionSaldo{

    private final double giroDescubierto;

    private CuentaCorriente(Builder builder)
    {
        this.Saldo= builder.saldoInicial;
        this.giroDescubierto= builder.giroDescubierto;
        this.Operaciones=0;
    }

    public static class Builder
    {
        private double saldoInicial=0;
        private double giroDescubierto=0;

        public Builder whitSaldoInicial(double saldoInicial)
        {
            this.saldoInicial=saldoInicial;
            return this;
        }

        public Builder whitGiroDescubierto(double giroDescubierto)
        {
            this.giroDescubierto=giroDescubierto;
            return this;
        }

        public CuentaCorriente build()
        {
            return new CuentaCorriente(this);
        }
    }

    @Override
    public boolean agregarSaldo(double monto) {
        if (monto <=0) {
            return false;
        } else {
            Saldo+=monto;
            Operaciones++;
            return true;
        }
    }

    @Override
    public boolean quitarSaldo(double Monto) {
        if (Monto <= 0) {
            return false;
        }
        if ((Saldo-Monto)<giroDescubierto)
        {
            return false;
        }
        Saldo-=Monto;
        return true;
    }
}

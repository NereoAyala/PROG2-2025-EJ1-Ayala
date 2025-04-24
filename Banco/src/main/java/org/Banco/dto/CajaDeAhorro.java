package org.Banco.dto;

import java.lang.module.ModuleDescriptor;

public class CajaDeAhorro extends Cuenta implements TGestionSaldo {

    private CajaDeAhorro(Builder builder)
    {
        this.Saldo= builder.saldoInicial;
        this.Operaciones=0;
    }

    public static class Builder
    {
        private double saldoInicial=0;

        public Builder whitSaldoInicial(double saldoInicial)
        {
            this.saldoInicial=saldoInicial;
            return this;
        }

        public CajaDeAhorro build()
        {
            return new CajaDeAhorro(this);
        }
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
        if (monto <=0) {
            return false;
        } else {
            Saldo+=monto;
            Operaciones++;
            return true;
        }
    }

    @Override
    public synchronized boolean quitarSaldo(double Monto) {
        if (Monto <= 0 || Monto>Saldo) {
            return false;
        } else {
            Saldo-=Monto;
            Operaciones++;
            return true;
        }
    }


}

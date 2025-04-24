package org.Banco.services;

import org.Banco.dto.CajaDeAhorro;
import org.Banco.dto.Cuenta;
import org.Banco.dto.CuentaCorriente;

import java.util.ArrayList;
import java.util.List;


public class LogicaCuenta {
    private static volatile LogicaCuenta instance;
    public List<Cuenta>Cuentas=new ArrayList<>();

    private LogicaCuenta() {}

    public static LogicaCuenta getInstance() {
        if (instance == null) {
            synchronized (LogicaCuenta.class) {
                if (instance == null) {
                    instance = new LogicaCuenta();
                }
            }
        }
        return instance;
    }

    public synchronized void setCuentas(List<Cuenta> cuentasIniciales) {
        Cuentas.clear();
        Cuentas.addAll(cuentasIniciales);
    }

    public void agregarCuenta(Cuenta cuenta)
    {
        Cuentas.add(cuenta);
    }

    private boolean esIndiceValido(int i) {
        return i >= 0 && i < Cuentas.size();
    }

    public boolean agregarSaldo(int indice,double monto)
    {
        if (esIndiceValido(indice)) {
            Cuenta cuenta=Cuentas.get(indice);
            if (cuenta instanceof CajaDeAhorro caja) {
                return caja.agregarSaldo(monto);
            } else if (cuenta instanceof CuentaCorriente c) {
                return c.agregarSaldo(monto);
            }
        }
        return false;
    }

    public boolean quitarSaldo(int indice,double monto)
    {
        if (esIndiceValido(indice)) {
            Cuenta cuenta=Cuentas.get(indice);
            if (cuenta instanceof CajaDeAhorro caja) {
                return caja.quitarSaldo(monto);
            } else if (cuenta instanceof CuentaCorriente c) {
                return c.quitarSaldo(monto);
            }
        }
        return false;
    }

    public double consultarSaldo(int indice)
    {
        if (esIndiceValido(indice)) {
            Cuenta cuenta=Cuentas.get(indice);
            return cuenta.getSaldo();
        }
        return -1;
    }

    public int cantidadCuentas()
    {
        return Cuentas.size();
    }

    public Cuenta getCuenta(int indice)
    {
        if (esIndiceValido(indice)) {
            return Cuentas.get(indice);
        } else{
            System.out.println("Indice no Valido: "+indice);
            return null;
        }
    }
}


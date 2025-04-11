package servicios;
import dto.*;
import java.util.ArrayList;
import java.util.List;

public class LogicaCuenta {
    private static volatile LogicaCuenta instancia;
    private final List<Cuenta> cuentas;

    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }

    public static LogicaCuenta getInstance()
    {
        if (instancia == null) {
            synchronized (LogicaCuenta.class)
            {
                if (instancia == null) {
                    instancia= new LogicaCuenta();
                }
            }
        }
        return instancia;
    }

    public void agregarCuenta(Cuenta cuenta)
    {
        cuentas.add(cuenta);
    }

    private boolean esIndiceValido(int i) {
        return i >= 0 && i < cuentas.size();
    }

    public boolean agregarSaldo(int indiceCuenta,double monto)
    {
        if (esIndiceValido(indiceCuenta)) {
            Cuenta cuenta = cuentas.get(indiceCuenta);

            if (cuenta instanceof CajaDeAhorro caja) {
                return caja.agregarSaldo(monto);
            } else if (cuenta instanceof CuentaCorriente cc) {
                return cc.agregarSaldo(monto);
            }
        }
        return false;
    }
    
    public boolean quitarSaldo(int indiceCuenta,double monto)
    {
        if (esIndiceValido(indiceCuenta)) {
            Cuenta cuenta=cuentas.get(indiceCuenta);

            if (cuenta instanceof CajaDeAhorro caja) {
                return caja.quitarSaldo(monto);
            } else if (cuenta instanceof CuentaCorriente cuentaCorriente) {
                return cuentaCorriente.quitarSaldo(monto);
            }
        }
        return false;
    }

    public double consultarSaldo(int indiceCuenta) {
        if (esIndiceValido(indiceCuenta)) {
            Cuenta cuenta = cuentas.get(indiceCuenta);
            return cuenta.obtenerSaldo();
        }
        return -1;
    }

    public int cantidadCuentas() {
        return cuentas.size();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}

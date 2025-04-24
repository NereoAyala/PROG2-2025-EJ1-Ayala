package org.Banco;

import org.Banco.dto.CajaDeAhorro;
import org.Banco.dto.Cuenta;
import org.Banco.dto.CuentaCorriente;
import org.Banco.services.LogicaCuenta;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        LogicaCuenta logica = LogicaCuenta.getInstance();
        Random rand=new Random();
        int index = rand.nextInt(10);

        for (int i = 0; i < 10; i++) {
            if (rand.nextBoolean()) {
                logica.agregarCuenta(new CajaDeAhorro.Builder()
                        .whitSaldoInicial(0).build());
            } else {
                double giro = rand.nextDouble() * 500;
                logica.agregarCuenta(new CuentaCorriente.Builder()
                        .whitSaldoInicial(0).whitGiroDescubierto(0).build());
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10.000; i++) {
            executor.submit(() -> {
                int cuentaId = rand.nextInt(10);
                double monto = rand.nextDouble() * 100;
                boolean agregar = rand.nextBoolean();

                if (agregar) {
                    logica.agregarSaldo(cuentaId, monto);
                } else {
                    logica.quitarSaldo(cuentaId, monto);
                }
            });
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("---- RESULTADOS ----");
        for (int i = 0; i < 10; i++) {
            Cuenta cuenta = logica.getCuenta(i);

            int operaciones = 0;

            if (cuenta instanceof CajaDeAhorro) {
                operaciones = ((CajaDeAhorro) cuenta).getOperaciones();
            } else if (cuenta instanceof CuentaCorriente) {
                operaciones = ((CuentaCorriente) cuenta).getOperaciones();
            }

            System.out.printf("Cuenta %d (%s): Saldo final = %.2f | Movimientos = %d%n",
                    i,
                    cuenta.getClass().getSimpleName(),
                    cuenta.getSaldo(),
                    operaciones);
        }
    }
}

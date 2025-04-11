package servicios;
import dto.CajaDeAhorro;
import dto.Cuenta;
import dto.CuentaCorriente;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[]args)
    {
        LogicaCuenta logica = LogicaCuenta.getInstance();
        Random rand=new Random();
        int index = rand.nextInt(10);

        for (int i = 0; i < 10; i++) {
            if (rand.nextBoolean()) {
                logica.agregarCuenta(new CajaDeAhorro(0));
            } else {
                double giro = rand.nextDouble() * 500;
                logica.agregarCuenta(new CuentaCorriente(0, giro));
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10.000; i++) {
            executor.submit(() -> {
                int cuentaId = rand.nextInt(10);
                double monto = rand.nextDouble() * 1000;
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
                    cuenta.obtenerSaldo(),
                    operaciones);
        }
    }
}

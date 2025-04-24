import org.Banco.dto.CajaDeAhorro;
import org.Banco.dto.Cuenta;
import org.Banco.dto.CuentaCorriente;
import org.Banco.services.LogicaCuenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class LogicaCuentaTest {
    private LogicaCuenta logica;

    @BeforeEach
    void setUp() {
        logica = LogicaCuenta.getInstance();
        // Prepara dos cuentas: CajaDeAhorro y CuentaCorriente
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas.add(new CajaDeAhorro.Builder()
                .whitSaldoInicial(100.0)
                .build());
        cuentas.add(new CuentaCorriente.Builder()
                .whitSaldoInicial(100.0)
                .whitGiroDescubierto(50.0)
                .build());
        logica.setCuentas(cuentas);
    }

    @AfterEach
    void tearDown() {
        // Limpia las cuentas para evitar estados residuales
        logica.setCuentas(new ArrayList<>());
    }
}

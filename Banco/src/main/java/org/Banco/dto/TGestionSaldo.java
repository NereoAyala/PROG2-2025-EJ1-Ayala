package org.Banco.dto;

public interface TGestionSaldo {
     boolean agregarSaldo(double Monto);
     boolean quitarSaldo(double Monto);
     double getSaldo();
     int getOperaciones();
}

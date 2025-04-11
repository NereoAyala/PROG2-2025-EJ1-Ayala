package dto;

public class CajaCorrienteDTO {
    private double saldo;
    private int operaciones;
    private double giroDescubierto;

    public CajaCorrienteDTO(Builder builder)
    {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
        this.giroDescubierto = builder.giroDescubierto;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setOpetaciones(int opetaciones) {
        this.operaciones = opetaciones;
    }

    public void setGiroDescubierto(double giroDescubierto) {
        this.giroDescubierto = giroDescubierto;
    }

    public static class Builder
    {
        private double saldo;
        private int operaciones;
        private double giroDescubierto;

        public Builder conSaldo(double saldo)
        {
            this.saldo=saldo;
            return this;
        }

        public Builder conOperaciones(int operaciones)
        {
            this.operaciones=operaciones;
            return this;
        }

        public Builder conGrioDescubierto(double giroDescubierto)
        {
            this.giroDescubierto=giroDescubierto;
            return this;
        }

        public CajaCorrienteDTO build()
        {
            return new CajaCorrienteDTO(this);
        }

    }
}

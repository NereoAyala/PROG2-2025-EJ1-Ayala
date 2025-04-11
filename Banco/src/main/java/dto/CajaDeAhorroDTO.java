package dto;

public class CajaDeAhorroDTO {
    private double saldo;
    private int operaciones;

    public CajaDeAhorroDTO (Builder builder)
    {
        this.saldo = builder.saldo;
        this.operaciones = builder.operaciones;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getOperaciones() {
        return operaciones;
    }

   public static class Builder
   {
       private double saldo;
       private int operaciones;

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

       public CajaDeAhorroDTO build()
       {
            return new CajaDeAhorroDTO(this);
       }
   }
}

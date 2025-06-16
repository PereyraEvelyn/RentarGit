package rentar.vehiculo;

import java.math.BigDecimal;

public class SuvCombustion extends Vehiculo implements MotorACombustion, Suv{
     private double consumoCombustible;
     private double NivelEmision;

     public SuvCombustion(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, double consumoCombustible, double nivelEmision) {
        super(patente, kilometraje, estado, modelo);
        this.consumoCombustible = consumoCombustible;
        NivelEmision = nivelEmision;
        super.setKilometros_para_mantenimiento(kilometros_a_realizar + kilometraje);
     }

     public double getConsumoCombustible() {
         return consumoCombustible;
     }

     public double getNivelEmision() {
         return NivelEmision;
     }

      @Override
    public BigDecimal aplicarDescuentoPromocional(BigDecimal costoBase) {
        return MotorACombustion.super.aplicarDescuentoPromocional(costoBase);
    }
     
}

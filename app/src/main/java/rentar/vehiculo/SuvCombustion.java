package rentar.vehiculo;


public class SuvCombustion extends Vehiculo implements MotorACombustion, Suv{
     private double consumoCombustible;
     private double NivelEmision;

     public SuvCombustion(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, double consumoCombustible, double nivelEmision) {
        super(patente, kilometraje, estado, modelo);
        this.consumoCombustible = consumoCombustible;
        NivelEmision = nivelEmision;
        super.setKilometros_para_mantenimiento(kilometros_a_realizar + kilometraje);
        super.setCosto_alquiler_por_dia(costo_alquiler_por_dia_auto);
     }

     public double getConsumoCombustible() {
         return consumoCombustible;
     }

     public double getNivelEmision() {
         return NivelEmision;
     }

     
     
}

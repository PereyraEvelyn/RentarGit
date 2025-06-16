package rentar.vehiculo;
import java.math.BigDecimal;


public class AutoCombustion extends Vehiculo implements MotorACombustion, Auto {
    private double consumoCombustible;
    private double NivelEmision;

    public AutoCombustion(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, double consumoCombustible, double nivelEmision) {
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

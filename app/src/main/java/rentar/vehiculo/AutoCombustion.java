package rentar.vehiculo;

public class AutoCombustion extends Vehiculo implements MotorACombustion {
    private double consumoCombustible;
    private double NivelEmision;

    public AutoCombustion(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, double consumoCombustible, double nivelEmision) {
        super(patente, kilometraje, estado, modelo);
        this.consumoCombustible = consumoCombustible;
        NivelEmision = nivelEmision;
    }

    public double getConsumoCombustible() {
        return consumoCombustible;
    }

    public double getNivelEmision() {
        return NivelEmision;
    }

    
    
}

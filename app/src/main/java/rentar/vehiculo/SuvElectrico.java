
import rentar.vehiculo.*;

public class SuvElectrico extends Vehiculo implements MotorElectrico{
    private int AutonomiaKM;
    private int TiempoDeCarga;

    public SuvElectrico(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, int autonomiaKM,
            int tiempoDeCarga) {
        super(patente, kilometraje, estado, modelo);
        AutonomiaKM = autonomiaKM;
        TiempoDeCarga = tiempoDeCarga;
    }
    public int getAutonomiaKM() {
        return AutonomiaKM;
    }
    public int getTiempoDeCarga() {
        return TiempoDeCarga;
    }
    
}

package main.java.rentar.vehiculo;

import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.MotorElectrico;
import rentar.vehiculo.Vehiculo;

public class AutoElectrico extends Vehiculo implements MotorElectrico{
    private int AutonomiaKM;
    private int TiempoDeCarga;

    public AutoElectrico(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, int autonomiaKM, int tiempoDeCarga) {
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

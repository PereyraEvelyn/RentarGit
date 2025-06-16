package rentar.vehiculo;

public class FurgonetaElectrica extends Vehiculo implements MotorElectrico, Furgoneta{
    private int AutonomiaKM;
    private int TiempoDeCarga;

    public FurgonetaElectrica(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, int autonomiaKM, int tiempoDeCarga) {
        super(patente, kilometraje, estado, modelo);
        AutonomiaKM = autonomiaKM;
        TiempoDeCarga = tiempoDeCarga;
        super.setKilometros_para_mantenimiento(kilometros_a_realizar + kilometraje);
        super.setCosto_alquiler_por_dia(costo_alquiler_por_dia_auto);
    }

    public int getAutonomiaKM() {
        return AutonomiaKM;
    }

    public int getTiempoDeCarga() {
        return TiempoDeCarga;
    }

    
    

}

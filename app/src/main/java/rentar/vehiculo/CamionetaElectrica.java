package rentar.vehiculo;

import java.math.BigDecimal;

public class CamionetaElectrica extends Vehiculo implements MotorElectrico, Camioneta{
    private int AutonomiaKM;
    private int TiempoDeCarga;

    public CamionetaElectrica(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo, int autonomiaKM,
            int tiempoDeCarga) {
        super(patente, kilometraje, estado, modelo);
        AutonomiaKM = autonomiaKM;
        TiempoDeCarga = tiempoDeCarga;
        super.setKilometros_para_mantenimiento(kilometros_a_realizar + kilometraje);
    }

    public int getAutonomiaKM() {
        return AutonomiaKM;
    }

    public int getTiempoDeCarga() {
        return TiempoDeCarga;
    }
    
   @Override
    public BigDecimal aplicarDescuentoPromocional(BigDecimal costoBase) {
        return MotorElectrico.super.aplicarDescuentoPromocional(costoBase);
    }
    
    
}

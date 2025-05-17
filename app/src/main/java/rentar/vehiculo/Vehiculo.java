package rentar.vehiculo;

import java.math.BigDecimal;

public abstract class Vehiculo {
    private String patente;
    private double kilometraje;
    private Estado estado;
    private ModeloVehiculo modelo;

    public enum Estado{
        Disponible, Rentado, EnMantenimiento;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        }
        Vehiculo vehiculo1 = (Vehiculo) obj;
        return patente.equals(vehiculo1.patente);
        }

    
}

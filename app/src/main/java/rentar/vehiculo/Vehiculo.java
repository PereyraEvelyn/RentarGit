package rentar.vehiculo;

import java.math.BigDecimal;

import rentar.mantenimiento.GestorMantenimiento;
import rentar.reservas.RegistroReservas;

public abstract class Vehiculo {
    private String patente;
    private double kilometraje;
    private Estado estado;
    private ModeloVehiculo modelo;
    private double kilometros_para_mantenimiento;
    private GestorMantenimiento gestorMantenimiento = new GestorMantenimiento();
    

    public Vehiculo(String patente, double kilometraje, Estado estado, ModeloVehiculo modelo) {
        this.patente = patente;
        this.kilometraje = kilometraje;
        this.estado = estado;
        this.modelo = modelo;
    }

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


    public String getPatente() {
        return patente;
    }


    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ModeloVehiculo getModelo() {
        return modelo;
    }




    public double getKilometros_para_mantenimiento() {
        return kilometros_para_mantenimiento;
    }


    public void setKilometros_para_mantenimiento(double kilometros_para_mantenimiento) {
        this.kilometros_para_mantenimiento = kilometros_para_mantenimiento;
    }

    public abstract BigDecimal aplicarDescuentoPromocional(BigDecimal costoBase);
    
    public GestorMantenimiento getGestorMantenimiento() {
        return gestorMantenimiento;
    }
   
    
}

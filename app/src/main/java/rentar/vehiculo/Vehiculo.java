package rentar.vehiculo;

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private double kilometraje;
    private int año;
    private Estado estado;

    public enum Estado {
     Disponible, Rentado, EnMantenimiento;
    }
     
  
    /*Getters 
    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public int getAño() {
        return año;
    }

    public Estado getEstado() {
        return estado;
    }*/

    
}

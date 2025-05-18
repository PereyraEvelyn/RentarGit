package rentar.vehiculo;

public abstract class Vehiculo {
    private String patente;
    private double kilometraje;
    private Estado estado;
    private ModeloVehiculo modelo;

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

    public void setPatente(String patente) {
        this.patente = patente;
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

    public void setModelo(ModeloVehiculo modelo) {
        this.modelo = modelo;
    }

    
}

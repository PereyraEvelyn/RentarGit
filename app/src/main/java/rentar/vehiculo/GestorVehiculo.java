package rentar.vehiculo;

import java.util.ArrayList;

public class GestorVehiculo {
    private ArrayList<Vehiculo> vehiculos;

    public GestorVehiculo() {
        setVehiculos(new ArrayList<Vehiculo>());
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public void eliminarVehiculo(String patente){
        Vehiculo vehiculoEncontrado = getVehiculo(patente);
        vehiculos.remove(vehiculoEncontrado);
    }

     public Vehiculo getVehiculo(String patente){
        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo var : vehiculos) {
            if (var.getPatente().equals(patente)) {
                vehiculoEncontrado = var;
                break;
            }
        }   
        return vehiculoEncontrado;
    }

    public void modificarVehiculo(Vehiculo nuevoVehiculo){
        Vehiculo vehiculoEncontrado;
        vehiculoEncontrado = getVehiculo(nuevoVehiculo.getPatente());
        vehiculos.remove(vehiculoEncontrado); 
        vehiculos.add(nuevoVehiculo);               
	}
}

package rentar.vehiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import rentar.mantenimiento.*;
import rentar.vehiculo.Vehiculo.Estado;

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
        Vehiculo vehiculoEncontrado = encontrarVehiculo(patente);
        vehiculos.remove(vehiculoEncontrado);
    }

     public Vehiculo encontrarVehiculo(String patente){
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
        vehiculoEncontrado = encontrarVehiculo(nuevoVehiculo.getPatente());
        vehiculos.remove(vehiculoEncontrado); 
        vehiculos.add(nuevoVehiculo);               
	}

    public ArrayList<Vehiculo> vehiculosListosParaMantenimiento(){
        ArrayList<Vehiculo> lista = new ArrayList<>(); 
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getKilometraje()>= vehiculo.getKilometros_para_mantenimiento()){
                lista.add(vehiculo);
            }
        }
        return lista;
    }

    public ArrayList<Vehiculo> vehiculosEnMantenimiento(){
        ArrayList<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getEstado() == Estado.EnMantenimiento){
                lista.add(vehiculo);
            }
        }
        return lista;
    }

    public void ingresar_a_mantenimiento_vehiculos(Vehiculo vehiculo, String detalle_mantenimiento, LocalDate fecha){
        vehiculo.getGestorMantenimiento().agregarMantenimiento(new Mantenimiento(fecha, detalle_mantenimiento));
        vehiculo.setEstado(Estado.EnMantenimiento);
    }
        
    public void egresar_mantenimiento(Vehiculo vehiculo, LocalDate fecha){
        if(fecha.isEqual(vehiculo.getGestorMantenimiento().getMantenimiento(fecha).getFecha_fin_mantenimiento())){
            vehiculo.setEstado(Estado.Disponible);
        }
    }

    public ArrayList<Vehiculo> todosLosVehiculos() {
        return vehiculos;
    }

    public ArrayList<Vehiculo> todosLosVehiculos(String tipo){
        String obj = tipo;
        ArrayList<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getClass().getSimpleName().equals(obj)){
                lista.add(vehiculo);
            }
        }
        return lista;
    }

    public ArrayList<Mantenimiento> listaDeMantenimientosVehiculo(Vehiculo vehiculo){
        return vehiculo.getGestorMantenimiento().getMantenimientos();
    }




    
    
}                                                                     

package rentar.reservas; 

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import rentar.cliente.Cliente;
import rentar.vehiculo.Vehiculo;

public class RegistroReservas {
     private ArrayList<Reserva> reservas;

     public RegistroReservas(){
        this.reservas = new ArrayList<>();
     }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

     public void agregarReserva(Reserva nuevaReserva) throws VehiculoNoDisponibleException, ReservaInvalidaException {
    // Validamos que el objeto no sea nulo
    if (nuevaReserva == null) {
        throw new ReservaInvalidaException("La reserva a registrar no puede ser nula.");
    }
    // Verificamos la disponibilidad antes de agregar
    if (verificarDisponibilidad(nuevaReserva.getVehiculoAsociado(), nuevaReserva.getFechaInicio(), nuevaReserva.getFechaFin())) {
        this.reservas.add(nuevaReserva);
    } else {
        throw new VehiculoNoDisponibleException("El vehículo no está disponible para las fechas solicitadas.");
    }
}

public void eliminarReserva(Reserva reserva) throws ReservaNoEncontradaException {
    boolean fueEliminada = this.reservas.remove(reserva);
    if (!fueEliminada) {
        throw new ReservaNoEncontradaException("No se pudo eliminar la reserva con código: " + reserva.getCodigoReserva());
    }
}


public Reserva getReserva(String codigoReserva) throws ReservaNoEncontradaException {
    for (Reserva aux : reservas) {
        if (aux.getCodigoReserva().equals(codigoReserva)) {
            return aux;
        }
    }
    throw new ReservaNoEncontradaException("No se encontró una reserva con el código: " + codigoReserva);
}




public boolean verificarDisponibilidad(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
    for (Reserva existente : this.reservas) {
        if (existente.getVehiculoAsociado().equals(vehiculo)) {
            boolean seSuperponen = fechaInicio.isBefore(existente.getFechaFin()) &&
                                   existente.getFechaInicio().isBefore(fechaFin);
            if (seSuperponen) {
                return false; // No está disponible, hay un choque de reservas
            }
        }
    }

    // Verificar que el vehículo no esté en mantenimiento en esas fechas
    //  la clase Vehiculo o GestorMantenimiento tiene un método para esto?
    // Por ejemplo: if (vehiculo.estaEnMantenimientoDurante(fechaInicio, fechaFin)) { ... }
    // Por ahora solo usa una comprobación del estado actual 
    if (vehiculo.getEstado() == Vehiculo.Estado.EnMantenimiento) {
        return false; // No está disponible
    }

    return true; // El vehículo está disponible
}




public List<Reserva> consultarReservasPorPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
    return this.reservas.stream()
        .filter(reserva -> fechaInicio.isBefore(reserva.getFechaFin()) && reserva.getFechaInicio().isBefore(fechaFin))
        .collect(Collectors.toList());
}



public List<Reserva> consultarReservasPorCliente(Cliente cliente) {
    return this.reservas.stream()
        .filter(reserva -> reserva.getCliente().equals(cliente))
        .collect(Collectors.toList());
}

/**
 * Nota de Diseño: Este método necesita la flota completa de vehículos para funcionar.
 * Lógicamente, debería estar en una clase de nivel superior (un "GestorPrincipal" o "Sistema")
 * que tenga acceso tanto al RegistroReservas como al GestorVehiculo.
 * Aquí lo incluimos para mostrar la lógica.
 */
public List<Vehiculo> consultarVehiculosDisponibles(List<Vehiculo> flotaCompleta, LocalDate fechaInicio, LocalDate fechaFin) {
    List<Vehiculo> vehiculosDisponibles = new ArrayList<>();
    for (Vehiculo vehiculo : flotaCompleta) {
        if (verificarDisponibilidad(vehiculo, fechaInicio, fechaFin)) {
            vehiculosDisponibles.add(vehiculo);
        }
    }
    return vehiculosDisponibles;
}
}

   
 



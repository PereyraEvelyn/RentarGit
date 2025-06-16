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
    if (nuevaReserva == null) {
        throw new ReservaInvalidaException("La reserva a registrar no puede ser nula.");
    }
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

    public List<Reserva> consultarReservasPorVehiculo(Vehiculo vehiculo) {
        return this.reservas.stream()
            .filter(reserva -> reserva.getVehiculoAsociado().equals(vehiculo))
            .collect(Collectors.toList());
    }
}
   
 



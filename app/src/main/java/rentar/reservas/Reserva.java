package rentar.reservas; 
import java.time.LocalDate;
import java.time.Period;

import rentar.cliente.Cliente;
import rentar.vehiculo.*;


public class Reserva {
    private String codigoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;
    private Cliente cliente;
    private Vehiculo vehiculoAsociado;

    public Reserva(String codigoReserva, LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculo, Cliente cliente) {
        this.codigoReserva = codigoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculoAsociado = vehiculo;
        this.cliente = cliente;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public enum EstadoReserva {
    PENDIENTE, ACTIVA, FINALIZADA, CANCELADA
    }
    
    public void setEstado(EstadoReserva estado) { 
        this.estado = estado; 
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){ 
            return true;
        }
        if(obj == null || getClass() !=obj.getClass()){ 
            return false;
        } 
        Reserva reserva1 = (Reserva) obj; 
        return codigoReserva.equals(reserva1.codigoReserva); 
    }


     
    public String getCodigoReserva() {
        return codigoReserva; 
    }
    /* 
    // Getters y setters
    public LocalDate getFechaInicio() {
     return fechaInicio; 
    }
    public LocalDate getFechaFin() { 
        return fechaFin;
    }
    public EstadoReserva getEstado() {
     return estado; 
    }
    public Vehiculo getVehiculo() { 
    return vehiculo; 
    }
    public Cliente getCliente() { 
    return cliente;
    }
    */
}

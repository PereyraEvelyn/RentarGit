package rentar.reservas; 
import rentar.cliente.*;
import rentar.vehiculo.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Reserva {
    private String codigoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;
    private Cliente cliente;
    private Vehiculo vehiculoAsociado;

    public Reserva(String codigoReserva, LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculoAsociado, Cliente cliente) {
        this.codigoReserva = codigoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculoAsociado = vehiculoAsociado;
        this.cliente = cliente;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public enum EstadoReserva {
    PENDIENTE, ACTIVA, FINALIZADA
    }
    
    public void setEstado(EstadoReserva estadoNuevo){
        this.estado = estadoNuevo;
    }
    
    public int getDuracionEnDiasAlquiler() {
        return Period.between(fechaInicio, fechaFin).getDays();
    }

    public BigDecimal calcularCostoTotal() {
        int dias = getDuracionEnDiasAlquiler();
        if (dias <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal costoDiario = this.vehiculoAsociado.getModelo().getCosto_renta();
        BigDecimal costoBase = costoDiario.multiply(new BigDecimal(dias));
        /* 
        if (vehiculoAsociado instanceof MotorElectrico) {
            // Aplicamos un descuento del 10% para vehículos eléctricos
            BigDecimal descuento = costoBase.multiply(new BigDecimal("0.10"));
            return costoBase.subtract(descuento);
        }*/

        return costoBase;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva otraReserva = (Reserva) obj;
        return Objects.equals(cliente, otraReserva.cliente) &&
               Objects.equals(vehiculoAsociado, otraReserva.vehiculoAsociado) &&
               Objects.equals(fechaInicio, otraReserva.fechaInicio);
    }
  
  
    // Getters y setters
    public String getCodigoReserva() {
        return codigoReserva; 
    }
    
    public LocalDate getFechaInicio() {
     return fechaInicio; 
    }
    public LocalDate getFechaFin() { 
        return fechaFin;
    }
    public EstadoReserva getEstado() {
     return estado; 
    }

    public Vehiculo getVehiculoAsociado() { 
        return vehiculoAsociado; 
    }

    public Cliente getCliente() {
         return cliente; 
        }
}




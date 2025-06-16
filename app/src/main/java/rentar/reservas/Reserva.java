package rentar.reservas; 
import rentar.cliente.*;
import rentar.vehiculo.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reserva {
    private String codigoReserva;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoReserva estado;
    private Cliente cliente;
    private Vehiculo vehiculoAsociado;
    private List<ConceptoExtra> extras;

   public Reserva(String codigoReserva, LocalDate fechaInicio, LocalDate fechaFin, Vehiculo vehiculoAsociado, Cliente cliente) throws ReservaInvalidaException {
        if (codigoReserva == null || fechaInicio == null || fechaFin == null || vehiculoAsociado == null || cliente == null) {
            throw new ReservaInvalidaException("Los argumentos para crear una reserva no pueden ser nulos.");
        }
        if (fechaFin.isBefore(fechaInicio)) {
            throw new ReservaInvalidaException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
        if (fechaInicio.isBefore(LocalDate.now())) {
            throw new ReservaInvalidaException("No se pueden crear reservas para fechas pasadas.");
        }

        this.codigoReserva = codigoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.vehiculoAsociado = vehiculoAsociado;
        this.cliente = cliente;
        this.estado = EstadoReserva.PENDIENTE;
        this.extras = new ArrayList<>();
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
        int diasDelAlquiler = getDuracionEnDiasAlquiler();
        if (diasDelAlquiler <= 0) {
            return BigDecimal.ZERO;
        }

        BigDecimal costoDiario = this.vehiculoAsociado.getModelo().getCosto_renta();
        BigDecimal costoBase = costoDiario.multiply(new BigDecimal(diasDelAlquiler));
        
        BigDecimal costoTotalExtras = BigDecimal.ZERO;
        for (ConceptoExtra extra : this.extras) {
            costoTotalExtras = costoTotalExtras.add(extra.getCosto());
        }
        BigDecimal costoSubtotal = costoBase.add(costoTotalExtras);
        BigDecimal costoFinal = this.vehiculoAsociado.aplicarDescuentoPromocional(costoSubtotal);
        return costoFinal;
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
  
  
    public void agregarExtra(ConceptoExtra extra) {
        this.extras.add(extra);
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
    
    public List<ConceptoExtra> getExtras() {
        return extras;
    }
}




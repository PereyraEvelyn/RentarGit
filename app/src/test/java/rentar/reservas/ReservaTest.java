package rentar.reservas;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import rentar.cliente.Cliente;
import rentar.vehiculo.*;

public class ReservaTest {
    private Cliente cliente1;
    private Vehiculo autoCombustion;
    private Vehiculo autoElectrico;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Reserva reserva;

    @Before
    public void setUp() {
        cliente1 = new Cliente("30123456", "Juan Perez", "A123", "juan@perez.com", "3834111222");
        ModeloVehiculo modeloCombustion = new ModeloVehiculo("Cronos", "Fiat", 2023, new BigDecimal("50000.00"));
        autoCombustion = new AutoCombustion("AC123BD", 15000, Vehiculo.Estado.Disponible, modeloCombustion, 8.0, 115);

        ModeloVehiculo modeloElectrico = new ModeloVehiculo("Model 3", "Tesla", 2024, new BigDecimal("90000.00"));
        autoElectrico = new AutoElectrico("AE456FG", 5000, Vehiculo.Estado.Disponible, modeloElectrico, 500, 8);
        
        

        fechaInicio = LocalDate.of(2025, 6, 20);
        fechaFin = LocalDate.of(2025, 6, 25); // 5 días de reserva
        
        reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente1);
    }

    // Tests de Creación 
    
    @Test
    public void crearReservaConEstadoPendiente() {
        Reserva reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente1);
        assertEquals(Reserva.EstadoReserva.PENDIENTE, reserva.getEstado());
    }

    //Tests de equals
    
    @Test
    public void dosReservasSonIguales() {
        Reserva reserva2 = new Reserva("R002", fechaInicio, fechaFin, autoCombustion, cliente1); // Mismos datos clave
        assertEquals(reserva, reserva2);
    }
    
    @Test
    public void dosReservasSonDiferentes() {
        Reserva reserva2 = new Reserva("R002", fechaInicio, fechaFin, autoElectrico, cliente1); // Diferente vehículo
        assertNotEquals(reserva, reserva2);
    }

    // Tests de Cambio de Estado de la Reserva

    @Test
    public void CambiarEstadoReserva() {
        Reserva reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente1);
        reserva.setEstado(Reserva.EstadoReserva.ACTIVA);
        assertEquals(Reserva.EstadoReserva.ACTIVA, reserva.getEstado());
    }

    // Tests de Calculo de Costo 
    
    @Test
    public void calcularDuracionAlquiler() {
        assertEquals(5, reserva.getDuracionEnDiasAlquiler());
    }


    @Test
    public void calcularCostoTotalVehiculoCombustionSinExtras() {
        // Costo = 50000.00 * 5 días = 250000.00
        BigDecimal costoEsperado = new BigDecimal("250000.00");
        assertTrue(costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }

}

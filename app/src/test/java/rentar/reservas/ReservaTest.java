package rentar.reservas;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import rentar.cliente.Cliente;
import rentar.vehiculo.*;

public class ReservaTest {

    private Cliente cliente;
    private Vehiculo autoCombustion;
    private Vehiculo autoElectrico;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ConceptoExtra accesorioGPS;
    private ConceptoExtra seguroTerceros;

    @Before
    public void setUp() {
        cliente = new Cliente("30123456", "Juan Perez", "A123", "juan@perez.com", "3834111222");

        // Vehículo a Combustión
        ModeloVehiculo modeloCombustion = new ModeloVehiculo("Cronos", "Fiat", 2023, new BigDecimal("50000.00"));
        autoCombustion = new AutoCombustion("AC123BD", 15000, Vehiculo.Estado.Disponible, modeloCombustion, 8.0, 115);

        // Vehículo Eléctrico
        ModeloVehiculo modeloElectrico = new ModeloVehiculo("Model 3", "Tesla", 2024, new BigDecimal("90000.00"));
        autoElectrico = new AutoElectrico("AE456FG", 5000, Vehiculo.Estado.Disponible, modeloElectrico, 500, 8);
        
        // Fechas de la reserva
        fechaInicio = LocalDate.of(2025, 8, 10);
        fechaFin = LocalDate.of(2025, 8, 15); // 5 días

        // Extras
        accesorioGPS = new Accesorio("GPS", "Navegador GPS", new BigDecimal("5000.00"));
        seguroTerceros = new Seguro("POL-123", new BigDecimal("10000.00"), cliente, autoCombustion, fechaInicio, fechaFin, Seguro.TipoCobertura.TERCEROS_BASICO, new BigDecimal("1500000.00"));
    }

    @Test
    public void creacionReservaExitosa() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
        assertNotNull("La reserva no debería ser nula si los datos son válidos.", reserva);
    }
    
    @Test
    public void estadoInicialDeReservaDebeSerPendiente() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
        assertEquals("El estado inicial de una nueva reserva debe ser PENDIENTE.", Reserva.EstadoReserva.PENDIENTE, reserva.getEstado());
    }

    @Test(expected = ReservaInvalidaException.class)
    public void creacionReservaConFechaFinAnteriorAInicio() throws ReservaInvalidaException {
        LocalDate fechaFinIncorrecta = LocalDate.of(2025, 8, 9);
        new Reserva("R002", fechaInicio, fechaFinIncorrecta, autoCombustion, cliente);
    }

    @Test(expected = ReservaInvalidaException.class)
    public void creacionReservaConClienteNulo() throws ReservaInvalidaException {
        new Reserva("R003", fechaInicio, fechaFin, autoCombustion, null);
    }
    
    @Test(expected = ReservaInvalidaException.class)
    public void creacionReservaConVehiculoNulo() throws ReservaInvalidaException {
        new Reserva("R004", fechaInicio, fechaFin, null, cliente);
    }


    @Test
    public void getDuracionEnDiasAlquiler() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R005", fechaInicio, fechaFin, autoCombustion, cliente);
        assertEquals("La duración debe ser 5.", 5, reserva.getDuracionEnDiasAlquiler());
    }

    @Test
    public void calcularCostoTotalVehiculoCombustionSinExtras() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R006", fechaInicio, fechaFin, autoCombustion, cliente);
        // Costo = 50000.00 (diario) * 5 días = 250000.00
        BigDecimal costoEsperado = new BigDecimal("250000.00");
        assertTrue("El costo total debe ser 250000.00.", costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }

    @Test
    public void calcularCostoTotalVehiculoElectricoAplicaDescuento() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R007", fechaInicio, fechaFin, autoElectrico, cliente);
        // Costo = 90000.00 * 5 = 450000.00. Descuento 10% = -45000.00. Total = 405000.00
        BigDecimal costoEsperado = new BigDecimal("405000.00");
        assertTrue("El costo para un vehículo eléctrico debe tener un 10% de descuento.", costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }
    
    @Test
    public void calcularCostoTotalConUnExtra() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R008", fechaInicio, fechaFin, autoCombustion, cliente);
        reserva.agregarExtra(accesorioGPS);
        // Costo = (50000.00 * 5) + 5000.00 (GPS) = 255000.00
        BigDecimal costoEsperado = new BigDecimal("255000.00");
        assertTrue("El costo total debe sumar el valor del GPS.", costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }

    @Test
    public void calcularCostoTotalConVariosExtras() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R009", fechaInicio, fechaFin, autoCombustion, cliente);
        reserva.agregarExtra(accesorioGPS);
        reserva.agregarExtra(seguroTerceros);
        // Costo = (50000.00 * 5) + 5000.00 (GPS) + 10000.00 (Seguro) = 265000.00
        BigDecimal costoEsperado = new BigDecimal("265000.00");
        assertTrue("El costo total debe sumar el valor de todos los extras.", costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }
    
    @Test
    public void calcularCostoTotalVehiculoElectricoConExtras() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R010", fechaInicio, fechaFin, autoElectrico, cliente);
        reserva.agregarExtra(accesorioGPS);
        // Subtotal = (90000.00 * 5) + 5000.00 = 455000.00
        // Descuento 10% de 455000 = -45500.00. Total = 409500.00
        BigDecimal costoEsperado = new BigDecimal("409500.00");
        assertTrue("El descuento debe aplicarse sobre el subtotal (vehículo + extras).", costoEsperado.compareTo(reserva.calcularCostoTotal()) == 0);
    }

    
    @Test
    public void agregarExtra() throws ReservaInvalidaException {
        Reserva reserva = new Reserva("R011", fechaInicio, fechaFin, autoCombustion, cliente);
        reserva.agregarExtra(accesorioGPS);
        assertEquals("La lista de extras debe contener 1 elemento.", 1, reserva.getExtras().size());
    }



    @Test
    public void equals_DosReservasIguales() throws ReservaInvalidaException {
    Reserva reserva1 = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
    Reserva reserva2 = new Reserva("R999", fechaInicio, fechaFin, autoCombustion, cliente);
    assertTrue("Dos reservas con el mismo cliente, vehículo y fecha de inicio deben ser iguales.", reserva1.equals(reserva2));
}

    @Test
    public void equals_DosReservasConDiferenteCliente() throws ReservaInvalidaException {
    Cliente clienteDiferente = new Cliente("99888777", "Ana Gomez", "B456", "ana@gomez.com", "3834000111");
    Reserva reserva1 = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
    Reserva reserva2 = new Reserva("R002", fechaInicio, fechaFin, autoCombustion, clienteDiferente);

    assertFalse("Dos reservas con diferente cliente deben ser distintas.", reserva1.equals(reserva2));
}

@Test
    public void equals_DosReservasConDiferenteVehiculo() throws ReservaInvalidaException {
    Reserva reserva1 = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
    Reserva reserva2 = new Reserva("R002", fechaInicio, fechaFin, autoElectrico, cliente);

    assertFalse("Dos reservas con diferente vehículo deben ser distintas.", reserva1.equals(reserva2));
}

    @Test
    public void equals_DosReservasConDiferenteFechaInicio() throws ReservaInvalidaException {
    LocalDate fechaInicioDiferente = fechaInicio.plusDays(1);
    Reserva reserva1 = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente);
    Reserva reserva2 = new Reserva("R002", fechaInicioDiferente, fechaFin, autoCombustion, cliente);

    assertFalse("Dos reservas con diferente fecha de inicio deben ser distintas.", reserva1.equals(reserva2));
}

}
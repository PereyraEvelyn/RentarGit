package rentar.reservas;

import rentar.cliente.*;
import rentar.vehiculo.AutoCombustion;
import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.Vehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class RegistroReservasTest {
    private Cliente cliente1;
    private Reserva reserva1;
    private Reserva reserva2;
    private Vehiculo autoCombustion1;
    private Vehiculo autoCombustion2;
    private ModeloVehiculo modeloCombustion1;
    private ModeloVehiculo modeloCombustion2;
    private RegistroReservas registroReservas;

    @Before
    public void setUp() {
        // Inicialización de datos de prueba
        registroReservas = new RegistroReservas();

        cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");

        modeloCombustion1 = new ModeloVehiculo("Cronos", "Fiat", 2023, new BigDecimal("50000.00"));
        modeloCombustion2 = new ModeloVehiculo("Mustang", "Ford", 2021, new BigDecimal("150000.00"));

        autoCombustion1 = new AutoCombustion("AC123BD", 15000, Vehiculo.Estado.Disponible, modeloCombustion1, 8.0, 115);
        autoCombustion2 = new AutoCombustion("AD456FG", 25000, Vehiculo.Estado.Disponible, modeloCombustion2, 12.0, 180);

        reserva1 = new Reserva("R001", LocalDate.of(2025, 6, 20), LocalDate.of(2025, 6, 25), autoCombustion1, cliente1);
        reserva2 = new Reserva("R002", LocalDate.of(2025, 7, 10), LocalDate.of(2025, 7, 15), autoCombustion2, cliente1);
    }

    @Test
    public void agregarUnaReserva() {
        registroReservas.agregarReserva(reserva1);
        assertEquals("El tamaño del registro debería ser 1.", 1, registroReservas.getReservas().size());
    }

    @Test
    public void buscarUnaReserva() {
        registroReservas.agregarReserva(reserva1);
        Reserva reservaEncontrada = registroReservas.getReserva("R001");
        assertNotNull("Se debería encontrar una reserva con un código existente.", reservaEncontrada);
    }

    @Test
    public void devolverLaReservaCorrecta() {
        registroReservas.agregarReserva(reserva1);
        registroReservas.agregarReserva(reserva2);
        Reserva reservaEncontrada = registroReservas.getReserva("R001");
        assertEquals("La reserva encontrada debería ser la que corresponde al código buscado.", reserva1, reservaEncontrada);
    }


    @Test
    public void eliminarUnaReserva() {
        registroReservas.agregarReserva(reserva1);
        registroReservas.agregarReserva(reserva2);
        registroReservas.eliminarReserva("R001");
        assertEquals("El registro debería tener 1 reserva después de eliminar.", 1, registroReservas.getReservas().size());
    }

    @Test
    public void modificarUnaReserva() {
        registroReservas.agregarReserva(reserva1);

        // nueva reserva con el mismo código pero con fecha de finalizacion diferente
        Reserva reservaModificada = new Reserva("R001", reserva1.getFechaInicio(), LocalDate.of(2025, 6, 30), reserva1.getVehiculoAsociado(), reserva1.getCliente());

        registroReservas.modificarReserva(reservaModificada);

        Reserva reservaEncontrada = registroReservas.getReserva("R001");
        
        assertEquals("La fecha de finalizacion de la reserva encontrada debe ser la de la reserva modificada.", LocalDate.of(2025, 6, 30), reservaEncontrada.getFechaFin());
    }
}
   
    

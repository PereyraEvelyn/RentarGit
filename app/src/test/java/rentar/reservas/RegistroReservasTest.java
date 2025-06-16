package rentar.reservas;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import rentar.cliente.Cliente;
import rentar.vehiculo.*;

public class RegistroReservasTest {

    private RegistroReservas registro;
    private Cliente cliente1;
    private Cliente cliente2;
    private Vehiculo vehiculo1;
    private Vehiculo vehiculo2;
    private Reserva reserva1;
    private Reserva reserva2;

    @Before
    public void setUp() throws ReservaInvalidaException {
        registro = new RegistroReservas();
        
        cliente1 = new Cliente("30111222", "Juan Perez", "A123", "juan@perez.com", "3834111222");
        cliente2 = new Cliente("31333444", "Maria Lopez", "B456", "maria@lopez.com", "3834333444");

        ModeloVehiculo modelo1 = new ModeloVehiculo("Cronos", "Fiat", 2023, new BigDecimal("50000.00"));
        vehiculo1 = new AutoCombustion("AC123BD", 15000, Vehiculo.Estado.Disponible, modelo1, 8.0, 115);

        ModeloVehiculo modelo2 = new ModeloVehiculo("Model 3", "Tesla", 2024, new BigDecimal("90000.00"));
        vehiculo2 = new AutoElectrico("AE456FG", 5000, Vehiculo.Estado.Disponible, modelo2, 500, 8);

        reserva1 = new Reserva("R001", LocalDate.of(2025, 8, 10), LocalDate.of(2025, 8, 20), vehiculo1, cliente1);
        reserva2 = new Reserva("R002", LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 10), vehiculo2, cliente2);
    }

    @Test
    public void agregarReservaExitosa() throws VehiculoNoDisponibleException, ReservaInvalidaException {

        registro.agregarReserva(reserva1);

        assertEquals("El registro debería tener 1 reserva después de agregar.", 1, registro.getReservas().size());
    }

    @Test(expected = VehiculoNoDisponibleException.class)
    public void agregarReservaConVehiculoNoDisponible() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(reserva1);
        Reserva reservaConflictiva = new Reserva("R003", LocalDate.of(2025, 8, 15), LocalDate.of(2025, 8, 25), vehiculo1, cliente2);

        registro.agregarReserva(reservaConflictiva);
    }
    
    @Test(expected = ReservaInvalidaException.class)
    public void agregarReservaNula() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(null);
    }
    

    @Test
    public void eliminarReservaExistente() throws VehiculoNoDisponibleException, ReservaInvalidaException, ReservaNoEncontradaException {
        registro.agregarReserva(reserva1);
        registro.eliminarReserva(reserva1);
        assertEquals("El registro debería estar vacío después de eliminar la única reserva.", 0, registro.getReservas().size());
    }

    @Test(expected = ReservaNoEncontradaException.class)
    public void eliminarReservaInexistente() throws ReservaNoEncontradaException {
        registro.eliminarReserva(reserva1); // Intenta eliminar una reserva que no fue agregada
    }

    @Test
    public void getReservaExistente() throws VehiculoNoDisponibleException, ReservaInvalidaException, ReservaNoEncontradaException {
        registro.agregarReserva(reserva1);
        Reserva encontrada = registro.getReserva("R001");
        assertEquals("La reserva encontrada debe ser la misma que la agregada.", reserva1, encontrada);
    }

    @Test(expected = ReservaNoEncontradaException.class)
    public void getReservaInexistentee() throws ReservaNoEncontradaException {
        registro.getReserva("R999"); // Código que no existe
    }

    
    @Test
    public void verificarDisponibilidadVehiculoLibre() {
        assertTrue("Un vehículo sin reservas debe estar disponible.", registro.verificarDisponibilidad(vehiculo1, LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 5)));
    }

    @Test
    public void verificarDisponibilidadVehiculoReservadoEnOtrasFechas() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(reserva1); // Reserva en Agosto
        assertTrue("El vehículo debe estar disponible en fechas no superpuestas.", registro.verificarDisponibilidad(vehiculo1, LocalDate.of(2025, 9, 1), LocalDate.of(2025, 9, 5)));
    }

    @Test
    public void verificarDisponibilidadVehiculoReservadoEnFechasSuperpuestas() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(reserva1); // Reserva del 10 al 20 de Agosto
        assertFalse("El vehículo no debe estar disponible en fechas superpuestas.", registro.verificarDisponibilidad(vehiculo1, LocalDate.of(2025, 8, 15), LocalDate.of(2025, 8, 25)));
    }
    
    @Test
    public void verificarDisponibilidadVehiculoEnMantenimiento() {
        vehiculo1.setEstado(Vehiculo.Estado.EnMantenimiento);
        assertFalse("Un vehículo en mantenimiento nunca debe estar disponible.", registro.verificarDisponibilidad(vehiculo1, LocalDate.of(2025, 10, 1), LocalDate.of(2025, 10, 5)));
    }

    @Test
    public void consultarReservasPorCliente() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(reserva1); // Cliente 1
        registro.agregarReserva(reserva2); // Cliente 2
        assertEquals("La consulta para cliente1 debe devolver 1 reserva.", 1, registro.consultarReservasPorCliente(cliente1).size());
    }

    @Test
    public void consultarReservasPorPeriodo() throws VehiculoNoDisponibleException, ReservaInvalidaException {
        registro.agregarReserva(reserva1); // Reserva en Agosto
        registro.agregarReserva(reserva2); // Reserva en Septiembre
        
        assertEquals("La consulta para Agosto debe devolver 1 reserva.", 1, registro.consultarReservasPorPeriodo(LocalDate.of(2025, 8, 1), LocalDate.of(2025, 8, 31)).size());
    }

}
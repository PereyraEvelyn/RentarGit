package rentar.reservas;
import rentar.cliente.*;
import rentar.vehiculo.AutoCombustion;
import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.Vehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
public class RegistroReservasTest {
    private Cliente cliente1;
    private Reserva reserva;
    private Vehiculo autoCombustion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ModeloVehiculo modeloCombustion;
    private RegistroReservas listaReservas;

    @Before
    public void setUp(){
        cliente1 = new Cliente("12345678", "Juan Perez", "LP12345", "juan.perez@email.com", "3834556677");
        fechaInicio = LocalDate.of(2025, 6, 20);
        fechaFin = LocalDate.of(2025, 6, 25); // 5 días de reserva
        modeloCombustion = new ModeloVehiculo("Cronos", "Fiat", 2023, new BigDecimal("50000.00"));
        autoCombustion = new AutoCombustion("AC123BD", 15000, Vehiculo.Estado.Disponible, modeloCombustion, 8.0, 115);
        
        reserva = new Reserva("R001", fechaInicio, fechaFin, autoCombustion, cliente1);
        
    }

    //Pruebas agregar reserva
    
}

package rentar.reservas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import rentar.cliente.Cliente;
import rentar.mantenimiento.Mantenimiento;
import rentar.reservas.Seguro.TipoCobertura;
import rentar.vehiculo.AutoCombustion;
import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.Vehiculo.Estado;

public class SeguroTest {
    Cliente titular;
    ModeloVehiculo m;
    AutoCombustion b;
    Seguro seg;
    Seguro seg2;

    @Before
    public void setUp() {
        seg2 = new Seguro("1234", new BigDecimal(40000), titular, b, LocalDate.of(2025, 7, 4), LocalDate.of(2025, 8, 4), TipoCobertura.TERCEROS_BASICO, new BigDecimal(40000));
        titular = new Cliente("44444", "Pedro Ruiz", "466465", "pedroruiz@gmail.com", "354637");
        seg = new Seguro("123", new BigDecimal(40000), titular, b, LocalDate.of(2025, 7, 4), LocalDate.of(2025, 8, 4), TipoCobertura.TERCEROS_BASICO, new BigDecimal(40000));
        m = new ModeloVehiculo("peugeot", "peugeot", 2010, new BigDecimal("100000"));
        b = new AutoCombustion("3333", 3000, Estado.Disponible, m, 30, 10);
    }

    @Test
    public void testCreacionAccesorio() {
        assertEquals("123", seg.getNumero_poliza());
    }

    @Test
    public void testEquals() {

        assertFalse("Un seguro es igual a otro si su numero de poliza son iguales", seg.equals(seg2));
    }
}

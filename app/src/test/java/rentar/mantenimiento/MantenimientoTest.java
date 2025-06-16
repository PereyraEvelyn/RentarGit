package rentar.mantenimiento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import rentar.vehiculo.AutoCombustion;
import rentar.vehiculo.ModeloVehiculo;
import rentar.vehiculo.Vehiculo.Estado;

public class MantenimientoTest {
    private ModeloVehiculo m;
    private AutoCombustion b;
    private Mantenimiento mante;
    private Mantenimiento mante2;
    @Before
    public void setUp() {
        m = new ModeloVehiculo("peugeot", "peugeot", 2010, new BigDecimal("100000"));
        b = new AutoCombustion("3333", 3000, Estado.Disponible, m, 30, 10);
        mante = new Mantenimiento(LocalDate.of(1999,5,30), "coso");
        mante2= new Mantenimiento(LocalDate.of(1999,5,24), "coso");
    }
    
    /*@Test
    public void testCreacionMantenimiento() {

        assertEquals(LocalDate.of(1999, 5, 24), mante.getFecha_fin_mantenimiento());
    }*/

    @Test
    public void testEquals() {
        
        assertFalse("Un mantenimiento es igual al otro si es del mismo vehiculo en la misma fecha", mante.equals(mante2));
    }
}
